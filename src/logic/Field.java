package logic;

import com.example.GameListener;

import java.util.Random;

public class Field {

	enum Mode {Shift, MegaShift};
	private Mode mode;

	private static final int BALL_WIDTH_COUNT = 11;
	private static final int BALL_HEIGHT_COUNT = 13;
	private static final int COUNT_BALLS = 3;

	private Cell field[][];
	private int score;
	private GameListener listener;

	public Field() {
		this.mode = Mode.Shift;
		score = 1;
		createField();
	}

	public Field(Mode mode) {
		this.mode = mode;
		score = 1;
		createField();
	}

	private void createField() {

		Random random = new Random();

		field = new Cell[BALL_WIDTH_COUNT + 2][];
		for (int i = 0; i < BALL_WIDTH_COUNT + 2; i++) {
			field[i] = new Cell[BALL_HEIGHT_COUNT + 2];
			for (int j = 0; j < BALL_HEIGHT_COUNT + 2; j++) {
				field[i][j] = new Cell(-1);

				if ((i == 0) || (i == BALL_WIDTH_COUNT + 1) || (j == 0) || (j == BALL_HEIGHT_COUNT + 1)) {
					field[i][j].setState(false);
					continue;
				}

				field[i][j].setSign(random.nextInt(COUNT_BALLS));
			}
		}
	}

	public void setListener(GameListener listener){
		this.listener = listener;
	}

	public Cell getCell(int x, int y) {
		return field[x + 1][y + 1];
	}

	public int getBallWidthCount(){
		return BALL_WIDTH_COUNT;
	}

	public int getBallHeightCount(){
		return BALL_HEIGHT_COUNT;
	}

	public void updateField(int x, int y){
		x++; y++;
		if (!checkingSuccess(x, y)) {
			return;
		}
		searchSameBalls(x, y);
		modifyFieldByShift();
		if (!checkingSuccessAll()) {
			if(listener != null){
				listener.onGameEnd();
			}
		}
		if (listener != null){
			listener.getScore(score);
		}

	}

	private boolean checkingSuccessAll(){
		for (int i = 1; i < BALL_WIDTH_COUNT + 1; i++){
			for (int j = 1; j < BALL_HEIGHT_COUNT + 1; j++){
				if (checkingSuccess(i, j)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkingSuccess(int x, int y) {
		if ((field[x][y].getSign() == field[x][y + 1].getSign()) && field[x][y + 1].getState()) {
			return true;
		}
		if ((field[x][y].getSign() == field[x][y - 1].getSign()) && field[x][y - 1].getState()) {
			return true;
		}
		if ((field[x][y].getSign() == field[x + 1][y].getSign()) && field[x + 1][y].getState()) {
			return true;
		}
		if ((field[x][y].getSign() == field[x - 1][y].getSign()) && field[x - 1][y].getState()) {
			return true;
		}
		return false;
	}

	private void searchSameBalls(int x, int y) {
		field[x][y].setState(false);
		score += 2;
		if ((field[x][y].getSign() == field[x][y + 1].getSign()) && field[x][y + 1].getState()) {
			searchSameBalls(x, y + 1);
		}
		if ((field[x][y].getSign() == field[x][y - 1].getSign()) && field[x][y - 1].getState()) {
			searchSameBalls(x, y - 1);
		}
		if ((field[x][y].getSign() == field[x + 1][y].getSign()) && field[x + 1][y].getState()) {
			searchSameBalls(x + 1, y);
		}
		if ((field[x][y].getSign() == field[x - 1][y].getSign()) && field[x - 1][y].getState()) {
			searchSameBalls(x - 1, y);
		}
	}

	private void modifyFieldByShift() {
		for (int i = 1; i < BALL_WIDTH_COUNT + 1; i++) {
			for (int j = BALL_HEIGHT_COUNT; j >= 1; j--) {
				if (!field[i][j].getState()) {
					int k = j - 1; // index of first alive
					for (; k >= 0 && !field[i][k].getState(); k--) {
					}
					int size = j - k; // size of

					for (int x = k; x >= 0; x--) {
						Cell cell = field[i][x];
						field[i][x] = field[i][x + size];
						field[i][x + size] = cell;
					}
				}
			}
		}
	}

}

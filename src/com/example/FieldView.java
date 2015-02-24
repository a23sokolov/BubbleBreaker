package com.example;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import logic.Field;

public class FieldView extends View {

	private Field field;
	private int BALL_WIDTH;
	private int BALL_HEIGHT;
	private Bitmap[] balls;

	public FieldView(Context context) {
		super(context);
		init();
	}

	public FieldView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public FieldView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init();
	}

	private void init() {
		field = new Field();
		//textView = (TextView) findViewById (R.id.textCountScore);
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);

		BALL_WIDTH = BALL_HEIGHT = Math.min(w / field.getBallWidthCount(), h / field.getBallHeightCount());

		balls = new Bitmap[3];
		Bitmap tmp = null;
		tmp = BitmapFactory.decodeResource(getResources(), R.drawable.ball_1);
		balls[0] = Bitmap.createScaledBitmap(tmp, BALL_WIDTH, BALL_HEIGHT, false);
		tmp.recycle();
		tmp = BitmapFactory.decodeResource(getResources(), R.drawable.ball_3);
		balls[1] = Bitmap.createScaledBitmap(tmp, BALL_WIDTH, BALL_HEIGHT, false);
		tmp.recycle();
		tmp = BitmapFactory.decodeResource(getResources(), R.drawable.ball_2);
		balls[2] = Bitmap.createScaledBitmap(tmp, BALL_WIDTH, BALL_HEIGHT, false);
		tmp.recycle();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();

		for (int i = 0; i < field.getBallWidthCount(); i++){
			for (int j = 0; j < field.getBallHeightCount(); j++){
				if(field.getCell(i, j).getState()){
					canvas.drawBitmap(balls[field.getCell(i, j).getSign()],
									i * BALL_WIDTH, j * BALL_HEIGHT, paint);
				}
			}
		}
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			int i = (int) (event.getX() / BALL_WIDTH);
			int j = (int) (event.getY() / BALL_HEIGHT);

			field.updateField(i, j);
			invalidate();
			return true;
		}
		return false;
	}

	public Field getField() {
		return field;
	}
}

package logic;

public class Cell
{
	private int sign;
	private boolean state;

	public Cell(int sign){
		this.sign = sign;
		state = true;
	}

	public int getSign(){
		return sign;
	}

	public void setSign(int x){
		sign = x;
	}

	public boolean getState(){
		return state;
	}

	public void setState(boolean state){
		this.state = state;
	}

}

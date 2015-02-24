package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import logic.Field;

public class GameActivity extends Activity implements GameListener {

	private Field field;
	private FieldView fieldView;
	private TextView textView;

	@Override
	public void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_field);

		textView = (TextView) findViewById(R.id.countScore);
		fieldView = (FieldView) findViewById(R.id.fieldView);
		field = fieldView.getField();
		field.setListener(this);

	}

	public void onClickPause(View view){
		Intent intent = new Intent(this, PauseActivity.class);
		startActivity(intent);
	}

	@Override
	public void onGameEnd() {
		Intent intent = new Intent(this, GameEnd.class);
		startActivity(intent);
	}

	@Override
	public void getScore(int score) {
		//To change body of implemented methods use File | Settings | File Templates.
		textView.setText(Integer.toString(score));
	}
}

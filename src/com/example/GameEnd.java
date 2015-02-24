package com.example;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameEnd extends Activity implements View.OnClickListener {

	Button btnAgain;
	Button btnEnought;

	@Override
	public void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.game_end_menu);

		btnAgain = (Button) findViewById(R.id.btnAgain);
		btnEnought = (Button) findViewById(R.id.btnEnough);

		btnAgain.setOnClickListener(this);
		btnEnought.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		Intent intent;
		switch (view.getId()){
			case R.id.btnAgain:
				intent = new Intent(this, GameActivity.class);
				startActivity(intent);
				break;
			case R.id.btnEnough:
				intent = new Intent(this, MyActivity.class);
				startActivity(intent);
		}

	}
}

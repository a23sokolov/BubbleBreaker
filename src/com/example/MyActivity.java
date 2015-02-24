package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MyActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_menu);
	}

	public void onClickOption(View view) {
		Intent intent = new Intent(this, OptionActivity.class);
		startActivity(intent);
	}

	public void onClickHighscore(View view){
		Intent intent = new Intent(this, HighscoreActivity.class);
		startActivity(intent);
	}

	public void onClickStartGame(View view){
		Intent intent = new Intent(this, TypeGameActivity.class);
		startActivity(intent);
	}

	public void onClickExit(View view){
		this.finish();
	}

}

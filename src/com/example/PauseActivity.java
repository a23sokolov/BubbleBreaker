package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import org.apache.http.entity.InputStreamEntity;

public class PauseActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pause_game_menu);
	}

	public void onClickResume(View view){
		this.finish();
	}

	public void onClickSurrenderRestart(View view){
		Intent intent = new Intent(this, MyActivity.class);
		startActivity(intent);
	}

	public void onClickOption(View view){
		Intent intent = new Intent(this, OptionActivity.class);
		startActivity(intent);
	}

}

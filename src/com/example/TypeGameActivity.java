package com.example;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class TypeGameActivity extends Activity {

	@Override
	public void onCreate (Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.type_game_menu);
	}

	public void onClickPlayAlone(View view){
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}

	public void onClickPlayWithFriend(View view){
		Intent intent = new Intent(this, ConnectActivity.class);
		startActivity(intent);
	}

}

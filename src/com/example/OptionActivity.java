package com.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.util.Log;

public class OptionActivity extends Activity implements AdapterView.OnItemSelectedListener, CompoundButton.OnCheckedChangeListener {

	Spinner spinner;
	ToggleButton tButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.option_menu);

		spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setOnItemSelectedListener(this);
		tButton = (ToggleButton) findViewById(R.id.toggleOnOff);
		tButton.setOnCheckedChangeListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
		System.out.println(spinner.getSelectedItem().toString());
	}

	@Override
	public void onNothingSelected(AdapterView<?> adapterView) {

	}

	@Override
	public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

	}
}

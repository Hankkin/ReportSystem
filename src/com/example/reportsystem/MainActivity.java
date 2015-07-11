package com.example.reportsystem;

import com.baidu.mapapi.SDKInitializer;
import com.example.reportsystem.R;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class MainActivity extends FragmentActivity {
	private Fragment[] fragments;
	private RadioGroup rgNavbar;
	private FragmentManager fmanager;
	private FragmentTransaction ftransaction;//

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		//在使用SDK各组件之前初始化context信息，传入ApplicationContext  
        //注意该方法要再setContentView方法之前实现  
        SDKInitializer.initialize(getApplicationContext());
		setContentView(R.layout.activity_main);
		fragments = new Fragment[4];
		fmanager = getSupportFragmentManager();
		fragments[0] = fmanager.findFragmentById(R.id.fragment_help);
		fragments[1] = fmanager.findFragmentById(R.id.fragment_report);
		fragments[2] = fmanager.findFragmentById(R.id.fragment_more);
		fragments[3] = fmanager.findFragmentById(R.id.fragment_personal);
		ftransaction = fmanager.beginTransaction().hide(fragments[0])
				.hide(fragments[1]).hide(fragments[2]).hide(fragments[3]);
		ftransaction.show(fragments[0]).commit();
		setFragmentIndicator();
	}

	private void setFragmentIndicator() {
		rgNavbar = (RadioGroup) findViewById(R.id.navbar);
		rgNavbar.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				ftransaction = fmanager.beginTransaction().hide(fragments[0])
						.hide(fragments[1]).hide(fragments[2])
						.hide(fragments[3]);
				switch (arg1) {
				case R.id.navbtnHelp:
					ftransaction.show(fragments[0]).commit();
					break;
				case R.id.navbtnReport:
					ftransaction.show(fragments[1]).commit();
					break;
				case R.id.navbtnMore:
					ftransaction.show(fragments[2]).commit();
					break;
				case R.id.navbtnPersonal:
					ftransaction.show(fragments[3]).commit();
					break;
				default:
					break;
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}

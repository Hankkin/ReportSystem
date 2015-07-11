package com.example.fg;

import com.example.reportsystem.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentPersonal extends Fragment {
	TextView titletv;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// 绑定布局文件
		return inflater.inflate(R.layout.fragment_personal, container, false);
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		titletv=(TextView) getView().findViewById(R.id.titletv);
		titletv.setText("我的");
	}
}

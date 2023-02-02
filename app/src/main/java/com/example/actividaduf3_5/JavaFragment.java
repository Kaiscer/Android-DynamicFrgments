package com.example.actividaduf3_5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class JavaFragment extends Fragment {




    public JavaFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_java, container, false);
        TextView tvJava = view.findViewById(R.id.tv_javaFragment);
        tvJava.setTextSize(TypedValue.COMPLEX_UNIT_SP,MainActivity.TAG);
        return view;
    }
}
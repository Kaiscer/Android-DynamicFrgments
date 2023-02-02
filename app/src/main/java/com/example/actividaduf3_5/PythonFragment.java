package com.example.actividaduf3_5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 *
 * create an instance of this fragment.
 */
public class PythonFragment extends Fragment {

         public PythonFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_python, container, false);
        TextView tvPython = view.findViewById(R.id.tv_pythonFragment);
        tvPython.setTextSize(TypedValue.COMPLEX_UNIT_SP,MainActivity.TAG);
        return view;
    }
}
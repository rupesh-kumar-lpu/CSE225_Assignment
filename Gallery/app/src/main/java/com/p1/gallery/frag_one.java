package com.p1.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import android.widget.TextView;



public class frag_one extends Fragment {
    TextView t1;

    public frag_one() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragone, container, false);
        t1= (TextView) v.findViewById(R.id.tex1);

        Bundle b3=getArguments();
        String name=b3.getString("name");

        t1.setText(name);



        return v;
    }

}
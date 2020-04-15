package com.p1.gallery;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class childfragment extends Fragment implements View.OnClickListener{
ImageView imgv;
    View v ;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View rootView = inflater.inflate(R.layout.fragment_childfragment, container, false);
imgv=rootView.findViewById(R.id.imageView);
imgv.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher_foreground));

        v = rootView;


        return rootView;
    }



    @Override
    public void onClick(View view) {


    }


}
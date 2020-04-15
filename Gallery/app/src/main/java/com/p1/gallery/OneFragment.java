package com.p1.gallery;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;


public class OneFragment extends Fragment {
    View root;
    ImageView child;
    ImageView child2;
    ImageView child3;
    ImageView child4;
    ImageView child5;
    ImageView child6;
    ImageView child7;
    ImageView child8;


    private int PICK_IMAGE_REQUEST = 1;
    private static final String TAG = "Tab One";
    private PageViewModel pageViewModel;
    public OneFragment() {
        // Required empty public constructor
    }
    /**
     * @return A new instance of fragment SpeedDialFragment.
     */
    public static OneFragment newInstance() {
        return new OneFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        pageViewModel.setIndex(TAG);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment1, container, false);
      //  final TextView textView = root.findViewById(R.id.section_label);
        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });

        //child fragment
        FragmentManager childFragMan = getChildFragmentManager();
        FragmentTransaction childFragTrans = childFragMan.beginTransaction();
        final childfragment fragg = new childfragment ();
        childFragTrans.add(R.id.FRAGMENT_PLACEHOLDER, fragg);
        childFragTrans.addToBackStack("B");



        final childfragment fragB2 = new childfragment ();
        childFragTrans.add(R.id.FRAGMENT_PLACEHOLDER2, fragB2);
        childFragTrans.addToBackStack("B2");



        final childfragment fragB3 = new childfragment ();
        childFragTrans.add(R.id.FRAGMENT_PLACEHOLDER3, fragB3);
        childFragTrans.addToBackStack("B3");



        final childfragment fragB4 = new childfragment ();
        childFragTrans.add(R.id.FRAGMENT_PLACEHOLDER4, fragB4);
        childFragTrans.addToBackStack("B4");

        final childfragment fragg5 = new childfragment ();
        childFragTrans.add(R.id.FRAGMENT_PLACEHOLDER5, fragg5);
        childFragTrans.addToBackStack("B");



        final childfragment fragB6 = new childfragment ();
        childFragTrans.add(R.id.FRAGMENT_PLACEHOLDER6, fragB6);
        childFragTrans.addToBackStack("B2");



        final childfragment fragB7 = new childfragment ();
        childFragTrans.add(R.id.FRAGMENT_PLACEHOLDER7, fragB7);
        childFragTrans.addToBackStack("B3");



        final childfragment fragB8 = new childfragment ();
        childFragTrans.add(R.id.FRAGMENT_PLACEHOLDER8, fragB8);
        childFragTrans.addToBackStack("B4");

        childFragTrans.commit();

        ((Button)root.findViewById(R.id.btnimg)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                child=fragg.imgv;
                child2=fragB2.imgv;
                child3=fragB3.imgv;
                child4= fragB4.imgv;
                child5=fragg5.imgv;
                child6=fragB6.imgv;
                child7=fragB7.imgv;
                child8= fragB8.imgv;
                chooseImage();
            }
        });

        return root;

    }


    public void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();
            Context applicationContext = MainActivity.getContextOfApplication();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(applicationContext.getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                child.setImageBitmap(bitmap);
                child2.setImageBitmap(bitmap);
                child3.setImageBitmap(bitmap);
                child4.setImageBitmap(bitmap);
                child5.setImageBitmap(bitmap);
                child6.setImageBitmap(bitmap);
                child7.setImageBitmap(bitmap);
                child8.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }}
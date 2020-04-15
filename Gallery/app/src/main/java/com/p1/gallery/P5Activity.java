package com.p1.gallery;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class P5Activity extends AppCompatActivity {
    EditText e1,e2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p5activity);
        FragmentManager manager=getSupportFragmentManager();
        final FragmentTransaction t=manager.beginTransaction();
        final frag_one m4=new frag_one();

        b= (Button) findViewById(R.id.btn1);
        e1= (EditText) findViewById(R.id.ed1);



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle b2=new Bundle();
                b2.putString("name",e1.getText().toString());
                m4.setArguments(b2);
                t.add(R.id.fram1234,m4);
                t.commit();


            }
        });


    }
}
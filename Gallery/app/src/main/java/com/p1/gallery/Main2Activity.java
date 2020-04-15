package com.p1.gallery;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ((Button)findViewById(R.id.p1bt)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentp1=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(intentp1);
            }
        });
        ((Button)findViewById(R.id.p4bt)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentp1=new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(intentp1);
            }
        });
        ((Button)findViewById(R.id.p5bt)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentp1=new Intent(Main2Activity.this,P5Activity.class);
                startActivity(intentp1);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.itmsl:
                showMessage("About Project", getResources().getString(R.string.about_string)+"\n\n "+getResources().getString(R.string.Github_Link));
                break;
        }
        return true;
    }
    public void showMessage(String Title,String message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(Title);
        builder.setMessage(message);
        builder.show();
    }
}

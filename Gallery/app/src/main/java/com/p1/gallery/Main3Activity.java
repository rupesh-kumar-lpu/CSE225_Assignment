package com.p1.gallery;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main3_activity);

        ((Button)findViewById(R.id.savebt)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writeToFile(((EditText)findViewById(R.id.filecontented)).getText().toString(),Main3Activity.this,((EditText)findViewById(R.id.filenm)).getText().toString());

            }
        });
        ((Button)findViewById(R.id.showbt)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main3Activity.this, readFromFile(Main3Activity.this,((EditText)findViewById(R.id.filenm)).getText().toString()), Toast.LENGTH_SHORT).show();
            }
        });



    }
    private void writeToFile(String data, Context context, String filename) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(filename, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
            Toast.makeText(Main3Activity.this, "Done!", Toast.LENGTH_SHORT).show();

        }
        catch (IOException e) {
            Toast.makeText(Main3Activity.this,e.toString(),Toast.LENGTH_LONG).show();

            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context,String filename) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(filename);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Toast.makeText(Main3Activity.this,e.toString(),Toast.LENGTH_LONG).show();
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Toast.makeText(Main3Activity.this,e.toString(),Toast.LENGTH_LONG).show();

            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}

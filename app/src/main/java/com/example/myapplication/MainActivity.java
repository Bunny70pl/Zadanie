package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button przyciskPolub;
    private Button przyciskUsun;
    private TextView tekstPolubienia;
    private static int liczbaPolubien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null) {
            liczbaPolubien = savedInstanceState.getInt("liczba");
        }
        przyciskPolub = findViewById(R.id.button);
        przyciskUsun = findViewById(R.id.button2);
        tekstPolubienia = findViewById(R.id.textView);
        tekstPolubienia.setText(liczbaPolubien + " polubien");
        przyciskPolub.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        liczbaPolubien++;
                        tekstPolubienia.setText(liczbaPolubien + " polubien");
                    }
                }
        );
        przyciskUsun.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        liczbaPolubien--;
                        if(liczbaPolubien<=0){
                            liczbaPolubien = 0;
                        }
                        tekstPolubienia.setText(liczbaPolubien + " polubien");
                    }
                }
        );
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("liczba", liczbaPolubien);

    }

}
package com.example.forca_integrado;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivityJogo extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    private EditText textWord;

    private Button btnlist, btnlog;

    private RadioGroup group;

    private Database DB;

    private String selectCategory, Word;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_jogo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        DB = new Database(MainActivityJogo.this);
        textWord = findViewById(R.id.TextWord);
        btnlog = findViewById(R.id.button2);
        btnlog.setOnClickListener(this);
        btnlist = findViewById(R.id.button3);
        btnlist.setOnClickListener(this);
        group = findViewById(R.id.Radio);
        group.setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v == btnlog){
            String text = textWord.getText().toString();

            boolean TextDigit = false;

            if (text.isEmpty()){

                Toast.makeText(this, "ERROR: Missing word", Toast.LENGTH_SHORT).show();

            }

            else{

                TextDigit = true;

            }

            RadioButton RB = findViewById(R.id.radioButton);
            RadioButton RB1 = findViewById(R.id.radioButton2);
            RadioButton RB2 = findViewById(R.id.radioButton3);
            RadioButton RB3 = findViewById(R.id.radioButton4);
            RadioButton RB4 = findViewById(R.id.radioButton5);

            boolean RadioCheck = false;

            if(RB.isChecked()||RB1.isChecked()||RB2.isChecked()|| RB3.isChecked()|| RB4.isChecked()){

                RadioCheck = true;

            }

            else{

                Toast.makeText(this, "ERROR: Missing Category", Toast.LENGTH_SHORT).show();

            }

            if(TextDigit && RadioCheck){

                Palavra word = new Palavra();
                word.setWordDigit(text);
                DB.saveWord(word);

            }

        }

        if(v == btnlist){

        }

    }

    @Override
    public void onCheckedChanged(@NonNull RadioGroup grupo, int checkedId) {

        if(grupo == group){
            RadioButton temporary = findViewById(checkedId);
            Toast.makeText(MainActivityJogo.this, temporary.getText().toString(), Toast.LENGTH_SHORT).show();
        }

    }
}
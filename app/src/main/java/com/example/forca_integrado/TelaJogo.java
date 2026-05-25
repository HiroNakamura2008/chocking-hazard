package com.example.forca_integrado;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class TelaJogo extends AppCompatActivity implements View.OnClickListener {
    private ImageView imagem;
    private ArrayList<Integer> listaImagens, listaIdsButtons;
    private ArrayList<String> listaPalavras;
    private int indiceListaImagens, CountCorrect, CountWrong;
    private TextView texto, textCorrect, textWrong;
    private String palavra;
    private char[] estado;

    private Button b1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_jogo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {

            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });

        imagem = findViewById(R.id.imageView2);
        textCorrect = findViewById(R.id.textView7);
        textWrong = findViewById(R.id.textView8);
        CountCorrect = 0;
        CountWrong = 0;
        indiceListaImagens = -1;
        listaImagens = new ArrayList<Integer>();
        listaImagens.add(R.drawable.forca_1_9);
        listaImagens.add(R.drawable.forca_2_9);
        listaImagens.add(R.drawable.forca_3_9);
        listaImagens.add(R.drawable.forca_4_9);
        listaImagens.add(R.drawable.forca_5_9);
        listaImagens.add(R.drawable.forca_6_9);
        listaImagens.add(R.drawable.forca_7_9);
        listaImagens.add(R.drawable.forca_9_9);
        listaImagens.add(R.drawable.forca_10_9);
        listaImagens.add(R.drawable.forca_11_9);

        listaPalavras =  new ArrayList<String>();
        listaPalavras.add("CAIXA");
        listaPalavras.add("BOLA");
        listaPalavras.add("TOMATE");
        listaPalavras.add("ABACAXI");
        listaPalavras.add("CARRETA");
        listaPalavras.add("ELEFANTE");
        listaPalavras.add("MACACO");
        listaPalavras.add("MELANCIA");
        listaPalavras.add("ASFALTO");
        listaPalavras.add("FORMULA");
        listaPalavras.add("TREMEMBE");
        listaPalavras.add("ESCOLA");
        listaPalavras.add("UNIVERSIDADE");

        texto = findViewById(R.id.textView3);

        listaIdsButtons = new ArrayList<Integer>();
        listaIdsButtons.add(R.id.id1);
        listaIdsButtons.add(R.id.id2);
        listaIdsButtons.add(R.id.id3);
        listaIdsButtons.add(R.id.id4);
        listaIdsButtons.add(R.id.id5);
        listaIdsButtons.add(R.id.id6);
        listaIdsButtons.add(R.id.id7);
        listaIdsButtons.add(R.id.id8);
        listaIdsButtons.add(R.id.id9);
        listaIdsButtons.add(R.id.id10);
        listaIdsButtons.add(R.id.id11);
        listaIdsButtons.add(R.id.id12);
        listaIdsButtons.add(R.id.id13);
        listaIdsButtons.add(R.id.id14);
        listaIdsButtons.add(R.id.id15);
        listaIdsButtons.add(R.id.id16);
        listaIdsButtons.add(R.id.id17);
        listaIdsButtons.add(R.id.id18);
        listaIdsButtons.add(R.id.id19);
        listaIdsButtons.add(R.id.id20);
        listaIdsButtons.add(R.id.id21);
        listaIdsButtons.add(R.id.id22);
        listaIdsButtons.add(R.id.id23);
        listaIdsButtons.add(R.id.id24);
        listaIdsButtons.add(R.id.id25);
        listaIdsButtons.add(R.id.id26);

        for(int j=0; j<listaIdsButtons.size();j++){

            Button b = findViewById(listaIdsButtons.get(j));
            b.setOnClickListener(this);

        }

        inicializaJogo();

    }
    public void inicializaJogo(){

        imagem.setImageResource(R.drawable.forca_0_9);
        indiceListaImagens = 0;
        palavra = sorteiaPalavra();
        estado = new char[palavra.length()];
        for(int i =0; i<estado.length;i++){

            estado[i] = '_';

        }

        CountCorrect = 0;
        CountWrong = 0;
        textCorrect.setText(Integer.toString(CountCorrect));
        textWrong.setText(Integer.toString(CountWrong)+"/"+Integer.toString(listaImagens.size()));
        atualizaTexto();
        for(int j=0; j<listaIdsButtons.size();j++){

            Button b = findViewById(listaIdsButtons.get(j));
            b.setEnabled(true);

        }

    }

    public void verifivaLetra(char c){

        boolean status = false;
        for(int i = 0; i < palavra.length(); i++){

            if(palavra.charAt(i)==c){

                status = true;
                estado[i] = c;

            }

        }

        if(!status){

            atualizaForca();
            CountWrong++;
            textWrong.setText(Integer.toString(CountWrong)+"/"+Integer.toString(listaImagens.size()));
            CheckFinished();

        }
        else {

            atualizaTexto();
            CountCorrect++;
            textCorrect.setText(Integer.toString(CountCorrect));
            CheckFinished();

        }
    }

    public void CheckFinished(){

        Boolean Verify = false;
        for(int i = 0; i < estado.length; i++){

            if(estado[i]=='_'){

                Verify = true;

            }

        }

        if(!Verify){

            AlertDialog.Builder Box = new AlertDialog.Builder(this);
            Box.setTitle("You Win!!");
            Box.setMessage("Deseja jogar Novamente? ");
            Box.setPositiveButton("Play", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {}

            }
            );

            Box.show();

        }

        if(CountWrong >= listaImagens.size()){

            AlertDialog.Builder Box = new AlertDialog.Builder(this);
            Box.setTitle("You Lose!!");
            Box.setMessage("Deseja jogar Novamente? ");
            Box.setPositiveButton("Play", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    inicializaJogo();

                }

            }
            );

            Box.show();

        }

    }

    public void atualizaTexto(){

        String temporaria= new String();
        temporaria="";

        for(int i =0; i<estado.length; i++){

            temporaria+= estado[i] + " ";

        }

        texto.setText(temporaria);

    }
    public String sorteiaPalavra(){

        String retorno = new String();
        Collections.shuffle(listaPalavras);
        retorno = listaPalavras.get(0);
        return retorno;

    }
    public void atualizaForca(){

        imagem.setImageResource(listaImagens.get(indiceListaImagens));
        indiceListaImagens++;

    }

    @Override
    public void onClick(View view) {

       Button b = (Button) view;
       verifivaLetra(b.getText().toString().charAt(0));
       b.setEnabled(false);

    }
}
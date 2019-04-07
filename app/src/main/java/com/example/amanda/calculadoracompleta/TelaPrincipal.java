package com.example.amanda.calculadoracompleta;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaPrincipal extends Activity {
    String texto_tela = "";
    int num_de_sinais = 0;
    int num_de_pontos1 = 0;
    int num_de_pontos2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);
    }

    public void click(View v){
        String tag = v.getTag().toString();
        TextView visor = (TextView) findViewById(R.id.telaCalc);

        if(tag.equals("1") || tag.equals("2") || tag.equals("3") || tag.equals("4")
                || tag.equals("5")|| tag.equals("6") || tag.equals("7") || tag.equals("8")
                || tag.equals("9") || tag.equals("0")) {
            texto_tela = texto_tela + tag;
            visor.setText(texto_tela);
        }

        if(tag.equals("C")){
            texto_tela = "";
            num_de_sinais = 0;
            num_de_pontos1 = 0;
            num_de_pontos2 = 0;
            visor.setText(texto_tela);
        }

        if(tag.equals("add")){
            if(texto_tela.equals("") || num_de_sinais > 0 || texto_tela.charAt(texto_tela.length() - 1) == '.')
                return;
            num_de_sinais++;
            texto_tela = texto_tela + "+";
            visor.setText(texto_tela);
        }

        if(tag.equals("sub")){
            if(texto_tela.equals("") || num_de_sinais > 0 || texto_tela.charAt(texto_tela.length() - 1) == '.')
                return;
            num_de_sinais++;
            texto_tela = texto_tela + "-";
            visor.setText(texto_tela);
        }

        if(tag.equals("div")){
            if(texto_tela.equals("") || num_de_sinais > 0 || texto_tela.charAt(texto_tela.length() - 1) == '.')
                return;
            num_de_sinais++;
            texto_tela = texto_tela + "/";
            visor.setText(texto_tela);
        }

        if(tag.equals("mult")){
            if(texto_tela.equals("") || num_de_sinais > 0 || texto_tela.charAt(texto_tela.length() - 1) == '.')
                return;
            num_de_sinais++;
            texto_tela = texto_tela + "*";
            visor.setText(texto_tela);
        }

        if(tag.equals("p")){
            int tam = texto_tela.length() - 1;
            if (texto_tela.equals("") || texto_tela.indexOf('+') == tam || texto_tela.indexOf('-') == tam
                || texto_tela.indexOf('*') == tam|| texto_tela.indexOf('/') == tam){
                return;
            }
            if(num_de_sinais == 0 && num_de_pontos1 == 0){
                    texto_tela = texto_tela + ".";
                    visor.setText(texto_tela);
                    num_de_pontos1++;
            }
            else if(num_de_sinais == 1 && num_de_pontos2 == 0){
                texto_tela = texto_tela + ".";
                visor.setText(texto_tela);
                num_de_pontos2++;
            }
        }

        if(tag.equals("CD")){
            if (texto_tela.length() > 0) {
                int tam = texto_tela.length() - 1;
                if( texto_tela.indexOf('+') == tam || texto_tela.indexOf('-') == tam
                        || texto_tela.indexOf('*') == tam|| texto_tela.indexOf('/') == tam)
                    num_de_sinais --;
                if (texto_tela.charAt(tam) == '.' && num_de_sinais == 1)
                    num_de_pontos2--;
                else if(texto_tela.charAt(tam) == '.' && num_de_sinais == 0)
                    num_de_pontos1--;
                texto_tela = texto_tela.substring (0, texto_tela.length() - 1);
                visor.setText(texto_tela);

            }
        }

        if(tag.equals("eq")){
            /*char op = '';
            int posOp = 0;
            if(num_de_sinais == 1){
                if(texto_tela.indexOf('+')){

                }
            }*/

        }

    }

}

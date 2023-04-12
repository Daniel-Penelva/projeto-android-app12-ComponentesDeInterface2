package com.formacaoandroidstudio.componentesdeinterface2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    /* Declarando os compononetes - pode nomear com o mesmo nome do id dos componentes */
    private Switch switchSenha;
    private ToggleButton toggleSenha;
    private TextView textResultadoSenha, textResultadoToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Capturando os ids dos componentes */
        switchSenha = findViewById(R.id.switchSenha);
        toggleSenha = findViewById(R.id.toggleSenha);
        textResultadoSenha = findViewById(R.id.textResultadoSwitch);
        textResultadoToggle = findViewById(R.id.textResultadoToggle);

    }
    
    public void enviar(View view){
        if(switchSenha.isChecked()){
            textResultadoSenha.setText("Switch Ligado");
        }else{
            textResultadoSenha.setText("Switch Desligado");
        }

        if(toggleSenha.isChecked()){
            textResultadoToggle.setText("Toggle Ligado");
        }else{
            textResultadoToggle.setText("Toggle Desligado");
        }
    }
}

/**
 * Switch (marcador ativação)
 * Em attributtes:
 * Para melhor visual deixa em 'layou_width' o valor 'match_parent'.
 * Você pode configurar o 'textOn' com o valor 'Ligado' e o 'textOff' com o valor 'Desligado'.
 * (Por padrão fica a opção desligado)
 * É possível capturar esses valores do textOn e do textOff.
 *
 * O atributo 'checked' com o valor 'true' deixa por padrão já marcado o switch.
 *
 * ------------------------------------------------
 * ToogleButton (marcador ativação)
 * Em attributtes:
 * Para melhor visual deixa em 'layou_width' o valor 'wrap_content'.
 *
 * Você pode configurar o 'textOn' com o valor 'Ligado' e o 'textOff' com o valor 'Desligado'.
 * (Por padrão fica a opção desligado)
 * É possível capturar esses valores do textOn e do textOff.
 *
 * O atributo 'checked' com o valor 'true' deixa por padrão já marcado o switch.
 * */
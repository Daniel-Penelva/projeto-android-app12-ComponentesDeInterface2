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


        /* Adicionando listener para os componentes
         * Chamando método listener - o método vai ser executado em tempo de execução, ou seja, é possível reparar que
         * não vai nem precisar clicar no botão enviar para mudar o valor do switch, ele fará essa mudança no momento que
         * você clicar no switch. Equivale o mesmo para o toggleButton.
         * O listener fica monitorando os componentes e se ele mudar o seu estado o método onChecked Changed é chamado.
         * */
        adicionarListenerSwitch();
        adicionarListenerToggle();

    }

    public void adicionarListenerSwitch(){
        switchSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    textResultadoSenha.setText("Switch Ligado");
                }else{
                    textResultadoSenha.setText("Switch Desligado");
                }
            }
        });
    }


    public void adicionarListenerToggle(){
        toggleSenha.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    textResultadoToggle.setText("Toggle Ligado");
                }else{
                    textResultadoToggle.setText("Toggle Desligado");
                }
            }
        });
    }

    /* Comentado

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
    */
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
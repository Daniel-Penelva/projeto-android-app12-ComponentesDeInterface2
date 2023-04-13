package com.formacaoandroidstudio.componentesdeinterface2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
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


    public void abrirToast(View view){

        /* Explicação na anotação */
        Toast.makeText(getApplicationContext(), "Testando Toast", Toast.LENGTH_LONG).show();
    }

    public void abrirToastCustomizado(View view){

        TextView textView = new TextView(getApplicationContext());
        textView.setBackgroundResource(R.color.colorAccent);
        textView.setTextColor(R.color.colorPrimary);
        textView.setText("Testando Toast customizado!");

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);

        /* Pode ser um texto, uma imagem, um layout */
         toast.setView(textView);
        //toast.setView(imageView);

        toast.show();
    }

}

/** Anotações:
 *
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
 *
 * ------------------------------------------------
 * Toast
 * O método makeTest() recebe três parâmetros, são eles:
 * getApplicationContext() ou o this - que permite acessar diversos recursos globais da sua aplicação. Ex: alarme, sensores, notificações, etc...
 * "" - define a mensagem de texto
 * Toast.LENGTH_LONG - Define o tempo MAIOR de atuação do toast OU LENGTH_SHORT (tempo mais curto).
 *
 * Método show() - para mostrar a mensagem.
 *
 * OBS. É possível também customizar o Toast instanciando a classe Toast e chamando seus métodos.
 *
 * */
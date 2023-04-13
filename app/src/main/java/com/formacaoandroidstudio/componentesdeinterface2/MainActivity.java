package com.formacaoandroidstudio.componentesdeinterface2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

    public void abrirAlertDialog(View view){

        // Instanciar AlertDialog
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        // Configurar títulos e mensagens
        dialog.setTitle("ATENÇÃO!!!");
        dialog.setMessage("Testando AlertDialog");

        // Configurar o cancelamento
        dialog.setCancelable(false);

        // Configurar icone
        dialog.setIcon(android.R.drawable.ic_dialog_alert);

        //Configurar ação para SIM ou NÃO
        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Você executou a ação SIM!!!", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "Você executou a ação NÃO!!!", Toast.LENGTH_SHORT).show();
            }
        });

        // Criar e exibir Dialog
        dialog.create();
        dialog.show();
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
 *  ------------------------------------------------
 *  AlertDialog
 *  É do tipo Builder.
 *
 *  setPositiveButton() e setNegativeButton;
 *  Esse método carrega dois métodos, (1) define o texto (2) define a ação executada (listener).
 *
 *  OBS. Configurar o cancelamento:
 *  A janela do alertDialog pode ser cancelada ao clicar em qualquer parte da tela. Portanto, caso você queira que
 *  o usuário não faça isso, é possível programar para que o alertDialog não seja cancelado pelo usuário, que o usuário
 *  tenha a obrigação de clicar em uma das duas ações, seja ela o SIM ou o NÃO.
 *
 *  Para fazer essa obrigação temos que usar o método 'setCancelable(true);'
 *  Repare que recebe como parametro o tipo boolean, caso coloque false, o usuário não consegue mais cancelar o alertDialog.
 *
 * */
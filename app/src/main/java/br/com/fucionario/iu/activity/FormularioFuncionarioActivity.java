package br.com.fucionario.iu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.fucionario.R;

public class FormularioFuncionarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_funcionario);
        Button botaoSalvar = findViewById(R.id.activity_formulario_funcionario_botao_salvar);
        botaoSalvar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(FormularioFuncionarioActivity.this,
                        "Clicaram no botão",
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
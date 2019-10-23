package com.example.datospersonales;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView nombre = (TextView) findViewById(R.id.Nombre);
        final TextView apellidos = (TextView) findViewById(R.id.Apellidos);
        final TextView edad = (TextView) findViewById(R.id.Edad);

        final RadioGroup rq = (RadioGroup) findViewById(R.id.Genero);

        final Spinner estado_civil = (Spinner) findViewById(R.id.SpinerEstado_civil);
        final Switch hijos = (Switch) findViewById(R.id.T_hijos);

        final Button bt = (Button) findViewById(R.id.Limpiar);

        bt.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {


                rq.clearCheck();
                nombre.setText("");
                apellidos.setText("");
                edad.setText("");
                hijos.setChecked(false);
                estado_civil.dispatchSetSelected(false);
            }
        });


        final String[] datos = new String[]{getString(R.string.Otros),getString(R.string.Casado),getString(R.string.Separado),getString(R.string.Viudo)};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        final Spinner cmbOpciones = (Spinner)findViewById(R.id.SpinerEstado_civil);

        cmbOpciones.setAdapter(adaptador);

    }
}

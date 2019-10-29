package com.example.datospersonales;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText nombre = (EditText) findViewById(R.id.Nombre);
        final EditText apellidos = (EditText) findViewById(R.id.Apellidos);
        final EditText edad = (EditText) findViewById(R.id.Edad);
        final TextView textgenerado = (TextView) findViewById(R.id.textGenerado);

        final RadioGroup rq_genero = (RadioGroup) findViewById(R.id.Genero);

        final Spinner estado_civil = (Spinner) findViewById(R.id.SpinerEstado_civil);
        final Switch hijos = (Switch) findViewById(R.id.T_hijos);

        final Button bt_limpiar = (Button) findViewById(R.id.Limpiar);
        final Button bt_Generar = (Button) findViewById(R.id.Generar);

        bt_limpiar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {


                rq_genero.clearCheck();
                apellidos.setText("");
                nombre.setText("");
                edad.setText("");
                hijos.setChecked(false);
                estado_civil.setSelection(0);
                textgenerado.setText("");
                nombre.requestFocus();

            }
        });
        //boton generar texto 2
        bt_Generar.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (nombre.getText().toString().isEmpty()==true){
                    textgenerado.setTextColor(Color.RED);
                    textgenerado.setText("Rellena el campo Nombre");
                    nombre.requestFocus();
                }else{
                    if (apellidos.getText().toString().isEmpty()==true){
                        textgenerado.setText("Rellena el campo Apellidos");
                        apellidos.requestFocus();
                    }else{
                        if (edad.getText().toString().isEmpty()==true){
                            textgenerado.setText("Rellena el campo edad");
                            edad.requestFocus();

                        }else{
                            if (rq_genero.getCheckedRadioButtonId()== -1){
                                textgenerado.setText("Di tu genero");

                            }else{
                                if (estado_civil.getSelectedItemPosition()==0){
                                    textgenerado.setText("Rellena estado civil");

                                }else {

                                    textgenerado.setTextColor(Color.BLACK);
                                    textgenerado.setText(apellidos.getText().toString()+ " "+ nombre.getText().toString());
                                    String string_edad= edad.getText().toString();

                                    // menor o no
                                    int entero_edad = Integer.parseInt(string_edad);

                                    if (entero_edad>=18){
                                        textgenerado.append(","+ " mayor de edad ");

                                    }else {
                                        textgenerado.append(","+ " menor de edad ");
                                    }
                                    //genero
                                    int Generoid = rq_genero.getCheckedRadioButtonId();
                                    View GeneroButtom = rq_genero.findViewById(Generoid);
                                    int indice =  rq_genero.indexOfChild(GeneroButtom);
                                    RadioButton btn = (RadioButton) rq_genero.getChildAt(indice);
                                    String selection = btn.getText().toString().toLowerCase();
                                    textgenerado.append(selection + " ");
                                    //estado_civil
                                    String texto_estado_civil = estado_civil.getSelectedItem().toString().toLowerCase();
                                    textgenerado.append(texto_estado_civil+ " y ");

                                    //comprueba hijos
                                    if (hijos.isChecked()){
                                        textgenerado.append("con hijos");
                                    }else{
                                        textgenerado.append("sin hijos");

                                    }
                                }
                            }
                        }
                    }
                }
            }
        });


        final String[] datos = new String[]{getString(R.string.estado_civil),getString(R.string.Otros),getString(R.string.Casado),getString(R.string.Separado),getString(R.string.Viudo)};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, datos);
        final Spinner cmbOpciones = (Spinner)findViewById(R.id.SpinerEstado_civil);

        cmbOpciones.setAdapter(adaptador);

    }
}

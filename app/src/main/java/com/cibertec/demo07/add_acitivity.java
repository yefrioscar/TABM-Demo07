package com.cibertec.demo07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

public class add_acitivity extends AppCompatActivity {
    EditText EdNombre, EdApellido, EdDni,EdEdad, idpersona;
    Button btnEnviar;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_acitivity);

        EdNombre   = (EditText) findViewById(R.id.EdNombre);
        EdApellido = (EditText) findViewById(R.id.EdApellido);
        EdDni      = (EditText) findViewById(R.id.EdDni);
        EdEdad     = (EditText) findViewById(R.id.EdEdad);
        btnEnviar  = (Button)   findViewById(R.id.BtnEnviar);
        idpersona  = (EditText) findViewById(R.id.idpersona);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null) {

            String nombre = (String) bundle.get("nombre");
            String apellido = (String) bundle.get("apellido");
            String dni = (String) bundle.get("dni");
            String edad = (String) bundle.get("edad");
            position = (Integer) bundle.get("position");

            EdNombre.setText(nombre);
            EdApellido.setText(apellido);
            EdDni.setText(dni);
            EdEdad.setText(edad);

            btnEnviar.setText("Actualizar");


        }




        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("position",position);
                intent.putExtra("nombre", EdNombre.getText().toString());
                intent.putExtra("apellido", EdApellido.getText().toString());
                intent.putExtra("dni", EdDni.getText().toString());
                intent.putExtra("edad", EdEdad.getText().toString());
                setResult(RESULT_OK,intent);
                finish();



            }
        });

    }
}

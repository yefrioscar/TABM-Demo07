package com.cibertec.demo07;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private final int REQUEST_CODE = 1;
    private final int REQUEST_CODE1 = 2;
    private TextView  tvMainItemFullname, tvMainItemDocument, tvMainItemAge, idpersona;

    private final View.OnClickListener btMainOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this,add_acitivity.class);
            startActivityForResult(intent,REQUEST_CODE);
        }
    };

    private final AdapterView.OnItemClickListener lvMainOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this,add_acitivity.class);


            tvMainItemFullname = (TextView) view.findViewById(R.id.tvMainItemFullname);
            tvMainItemDocument = (TextView) view.findViewById(R.id.tvMainItemDocument);
            tvMainItemAge = (TextView) view.findViewById(R.id.tvMainItemAge);
            idpersona = (TextView) view.findViewById(R.id.idpersona);

            String[] nombreCompleto = tvMainItemFullname.getText().toString().split(" ");



            intent.putExtra("position", position);
            intent.putExtra("nombre", nombreCompleto[0]);
            intent.putExtra("apellido", nombreCompleto[1]);
            intent.putExtra("dni", tvMainItemDocument.getText().toString());
            intent.putExtra("edad", tvMainItemAge.getText().toString());




            startActivityForResult(intent, REQUEST_CODE1);
        }
    };


    private ListView lvMain;

    private Button btMain;
    private LVMainAdapter mLVMainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMain = (ListView)findViewById(R.id.lvMain);
        btMain = (Button)findViewById(R.id.btMain);

        btMain.setOnClickListener(btMainOnClickListener);
        lvMain.setOnItemClickListener(lvMainOnItemClickListener);


        mLVMainAdapter = new LVMainAdapter(this);
        lvMain.setAdapter(mLVMainAdapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE1) {
            if (resultCode == RESULT_OK) {

                        for (int i = 0; i < mLVMainAdapter.getCount(); i++) {
                            Log.d("Yo", "Resultado " + mLVMainAdapter.getItem(i).getDocumento() + " jj " + data.getStringExtra("dni"));
                            if (mLVMainAdapter.getItem(i).getDocumento().equals(data.getStringExtra("dni"))) {
                                mLVMainAdapter.getItem(i).setNombre(data.getStringExtra("nombre"));
                                mLVMainAdapter.getItem(i).setApellido(data.getStringExtra("apellido"));
                                mLVMainAdapter.getItem(i).setDocumento(data.getStringExtra("dni"));
                                mLVMainAdapter.getItem(i).setEdad(Integer.parseInt(data.getStringExtra("edad")));
                                mLVMainAdapter.notifyDataSetChanged();
                            }
                        }
                }

            }

        if(requestCode == REQUEST_CODE) {
            if(resultCode == RESULT_OK) {
                Persona persona = new Persona();
                persona.setId(data.getStringExtra("id"));
                persona.setNombre(data.getStringExtra("nombre"));
                persona.setApellido(data.getStringExtra("apellido"));
                persona.setDocumento(data.getStringExtra("dni"));
                persona.setEdad(Integer.parseInt(data.getStringExtra("edad")));
                mLVMainAdapter.add(persona);
            }
        }

    }
}

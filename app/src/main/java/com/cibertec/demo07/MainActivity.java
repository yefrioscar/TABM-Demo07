package com.cibertec.demo07;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final View.OnClickListener btMainOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Persona persona = new Persona();
            persona.setId(java.util.UUID.randomUUID().toString());
            persona.setNombre(java.util.UUID.randomUUID().toString().replace("-","").substring(0,10));
            persona.setApellido(java.util.UUID.randomUUID().toString().replace("-","").substring(0,10));
            persona.setDocumento(java.util.UUID.randomUUID().toString().replace("-","").substring(0,8));
            persona.setEdad(new Random().nextInt(100));

            mLVMainAdapter.add(persona);
        }
    };

    private final AdapterView.OnItemClickListener lvMainOnItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "posición -> " +position,Toast.LENGTH_SHORT).show();
            Persona persona = mLVMainAdapter.getItem(position);
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

        mLVMainAdapter = new LVMainAdapter(MainActivity.this);
        lvMain.setAdapter(mLVMainAdapter);
    }
}

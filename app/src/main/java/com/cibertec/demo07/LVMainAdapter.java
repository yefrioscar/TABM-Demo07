package com.cibertec.demo07;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class LVMainAdapter extends ArrayAdapter<Persona> {

    public LVMainAdapter(Context context) {

        super(context, 0, new ArrayList<Persona>());

    }



    //CREAR LA VISTA QUE SE MOSTRARÁ EN EL LISTVIEW, ES DECIR CADA FILA
    //INFLAMOS LA VISTA MAIN_ITEM Y LE ASIGNAMOS LOS VALORES EN LA POSICIÓN QUE INDICA
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.main_item, parent, false);

        TextView tvMainItemFullname, tvMainItemDocument, tvMainItemAge, idpersona;

        tvMainItemFullname = (TextView) convertView.findViewById(R.id.tvMainItemFullname);
        tvMainItemDocument = (TextView) convertView.findViewById(R.id.tvMainItemDocument);
        tvMainItemAge = (TextView) convertView.findViewById(R.id.tvMainItemAge);
        idpersona = (TextView) convertView.findViewById(R.id.idpersona);

        //OBTENGO LA PERSONA DE MI LISTA EN LA POSICIÓN SOLICITADA
        Persona persona = getItem(position);

        tvMainItemFullname.setText(persona.getNombre()+" "+persona.getApellido());
        tvMainItemDocument.setText(persona.getDocumento());
        tvMainItemAge.setText(String.valueOf(persona.getEdad()));


        return convertView;
    }
}
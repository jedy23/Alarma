package com.cm.zuniga.alarma;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Configuracion extends AppCompatActivity implements View.OnClickListener{

    ImageView btn_tiempo, btn_calendar;
    AlertDialog myDialog;
    DatePicker datePicker;
    TimePicker timePicker;

    TextView txtHora, txtFecha,txtCancion;
    EditText recordatorio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        btn_tiempo = findViewById(R.id.imageView_hora);
        btn_calendar = findViewById(R.id.imageView_fecha);

        txtHora = findViewById(R.id.textView_hora);
        txtFecha = findViewById(R.id.textView_fecha);
        txtCancion = findViewById(R.id.textView_cancion);
        recordatorio = findViewById(R.id.editText_recordatorio);

        btn_tiempo.setOnClickListener(this);
        btn_calendar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {




        switch (v.getId()){

            case R.id.imageView_hora:


                LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
                View alertView = inflater.inflate(R.layout.dialog_timerpicker, null);
                timePicker = alertView.findViewById(R.id.timePicker);

                AlertDialog.Builder builder = new AlertDialog.Builder(Configuracion.this);

                builder.setView(alertView);
                builder.setTitle("Selecciona la hora");

                builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                       //Toast.makeText(Configuracion.this, timePicker.getHour()+" "+timePicker.getMinute(), Toast.LENGTH_SHORT).show();
                        txtHora.setText(timePicker.getHour()+":"+timePicker.getMinute());

                        myDialog.dismiss();


                    }
                });

                builder.setCancelable(false);
                myDialog = builder.create();
                myDialog.show();


                break;

            case R.id.imageView_fecha:

                LayoutInflater inflater2 = LayoutInflater.from(getApplicationContext());
                View alertView2 = inflater2.inflate(R.layout.dialog_calendar, null);
                datePicker = alertView2.findViewById(R.id.datePicker);


                AlertDialog.Builder builder2 = new AlertDialog.Builder(Configuracion.this);

                builder2.setView(alertView2);
                builder2.setTitle("Selecciona la fecha");

                builder2.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        myDialog.dismiss();
                    }
                });

                builder2.setCancelable(false);
                myDialog = builder2.create();
                myDialog.show();

                break;


            default:
                break;
        }


    }
}

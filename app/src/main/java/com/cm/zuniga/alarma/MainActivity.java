package com.cm.zuniga.alarma;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Context context = MainActivity.this;
    ArrayList<Pair<String,String>> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView);
        datos = new ArrayList<>();

        listView.setAdapter(new AdapterListView());


        datos.add(new Pair<String, String>("Recordatorio 1","Viernes 18 Mayo"));
        datos.add(new Pair<String, String>("Recordatorio 2","Viernes 18 Mayo"));
        datos.add(new Pair<String, String>("Recordatorio 3","Viernes 18 Mayo"));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Configuracion.class);
                startActivity(intent);
                //Nueva alarma
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class AdapterListView extends BaseAdapter{

        TextView nombreAlarma;
        TextView diaAlarma;

        @Override
        public int getCount() {
            return datos.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflador = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflador.inflate(R.layout.item_listview,null);

            nombreAlarma = convertView.findViewById(R.id.textView_nombreAlarma);
            diaAlarma = convertView.findViewById(R.id.textView_horaAlarma);

            nombreAlarma.setText(datos.get(position).first);
            diaAlarma.setText(datos.get(position).second);


            return convertView;
        }
    }
}

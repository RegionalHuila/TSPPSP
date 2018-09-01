package com.example.worldskills.tsppsp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TimeLogActivity extends AppCompatActivity {

    EditText etHoraInicio, etHoraFinal, etInterrupcion, etComentarios;
    Button btnInicio, btnFinal, btnRegistrar;
    Spinner spFase;
    TextView tvHoraDelta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);

        etComentarios = (EditText)findViewById(R.id.etComentarios);
        etHoraFinal = (EditText)findViewById(R.id.etHoraFinal);
        etHoraInicio = (EditText)findViewById(R.id.etHoraInicio);
        etInterrupcion = (EditText)findViewById(R.id.etMinutosInterrupcion);
        btnFinal = (Button)findViewById(R.id.btnHoraInicio);
        btnFinal = (Button)findViewById(R.id.btnHoraFinal);
        btnRegistrar = (Button)findViewById(R.id.btnResgistrar);
        spFase = (Spinner)findViewById(R.id.spFase) ;

        ArrayAdapter<CharSequence> adaptador =  ArrayAdapter.createFromResource(this,R.array.Fases, android.R.layout.simple_list_item_1);
        spFase.setAdapter(adaptador);

        btnInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat formato = new SimpleDateFormat();

            }
        });




    }
}

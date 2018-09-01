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
import java.util.Calendar;
import java.util.Date;


public class TimeLogActivity extends AppCompatActivity {

    EditText etHoraInicio, etHoraFinal, etInterrupcion, etComentarios;
    Button btnInicio, btnFinal, btnRegistrar;
    Spinner spFase;
    TextView tvHoraDelta;
    SimpleDateFormat formato = new SimpleDateFormat();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_log);

        etComentarios = (EditText)findViewById(R.id.etComentarios);
        etHoraFinal = (EditText)findViewById(R.id.etHoraFinal);
        etHoraInicio = (EditText)findViewById(R.id.etHoraInicio);
        etInterrupcion = (EditText)findViewById(R.id.etMinutosInterrupcion);
        btnInicio = (Button)findViewById(R.id.btnHoraInicio);
        btnFinal = (Button)findViewById(R.id.btnHoraFinal);
        btnRegistrar = (Button)findViewById(R.id.btnResgistrar);
        spFase = (Spinner)findViewById(R.id.spFase) ;

        ArrayAdapter<CharSequence> adaptador =  ArrayAdapter.createFromResource(this,R.array.Fases, android.R.layout.simple_list_item_1);
        spFase.setAdapter(adaptador);


        btnInicio.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//obtenemos la fecha de inicio y le damos formato
                Calendar fecha = Calendar.getInstance();
                Date hora = fecha.getTime();
                formato = new SimpleDateFormat("h:mm");
                etHoraInicio.setText(""+formato.format(hora));
                etHoraInicio.setEnabled(true);

            }
        });
        btnFinal.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//obenemos la fehca final y le damos formato
                Calendar fecha = Calendar.getInstance();
                Date hora = fecha.getTime();
                formato = new SimpleDateFormat(" h:mm");
                etHoraFinal.setText(""+formato.format(hora));
                etHoraFinal.setEnabled(true);




            }
        });




    }


}

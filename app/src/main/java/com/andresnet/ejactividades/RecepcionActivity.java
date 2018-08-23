package com.andresnet.ejactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RecepcionActivity extends AppCompatActivity {
        private TextView tNombre, tTelefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recepcion);

        tNombre = findViewById(R.id.tNombre);
        tTelefono = findViewById(R.id.tTelefono);

        Bundle args = getIntent().getExtras();
        if(args !=null) {
            tNombre.setText(args.getString("nombre"));
            tTelefono.setText(args.getString("telefono"));
        }
        tNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("Llegaron", "Ok");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}

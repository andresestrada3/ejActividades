package com.andresnet.ejactividades;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eNombre, eTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eNombre = findViewById(R.id.eNombre);
        eTelefono = findViewById(R.id.eTelefono);
    }

    public void EnviarDatos(View view) {
        Intent intent = new Intent(MainActivity.this, RecepcionActivity.class);
        intent.putExtra("nombre",eNombre.getText().toString());
        intent.putExtra("telefono",eTelefono.getText().toString());
        startActivityForResult(intent, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1234 && resultCode == RESULT_OK){
            Toast.makeText(this, data.getExtras().getString("Llegaron"),
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent=null;
        switch (id){
            case R.id.nRecepcion:
                intent =new Intent(MainActivity.this, RecepcionActivity.class);
                break;
            case R.id.mTercerActivity:
            intent =new Intent(MainActivity.this, TercerActivity.class);
            break;

        }
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Estoy en: ", "OnStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Estoy en: ", "OnResume()");
    }
//Activa
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Estoy en: ", "OnPause()");
    }
//visible
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Estoy en: ", "OnStop()");
    }
 //Parada
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Estoy en: ", "OnRestart()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Estoy en: ", "OnDestroy()");
    }
//Destruida
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}

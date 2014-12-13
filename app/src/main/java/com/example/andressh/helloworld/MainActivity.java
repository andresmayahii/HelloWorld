package com.example.andressh.helloworld;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void abrirActividad(View v){
        Intent intent = new Intent(this, EditActivity.class);

        intent.putExtra("mensaje","Este mensaje es de la primera actividad");

        startActivityForResult(intent,31);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == 31) {
            if(resultCode == 200) {
                Toast.makeText(this,"200 todo bien", Toast.LENGTH_SHORT).show();
            } else if( resultCode == 500) {
                Toast.makeText(this,"500 error de servidor", Toast.LENGTH_SHORT).show();
            }
        }

        String mResultado = data.getExtras().getString("resultado");
        ((TextView) findViewById(R.id.textView2)).setText(mResultado);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

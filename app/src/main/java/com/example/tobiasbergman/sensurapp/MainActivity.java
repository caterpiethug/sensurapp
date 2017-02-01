package com.example.tobiasbergman.sensurapp;

import android.content.DialogInterface;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity
implements AdapterView.OnItemSelectedListener {

    private static final String[] karakter={"A","B","C","D","E","F"};

    Spinner karakterSpinner;


    public void onItemSelected(AdapterView<?> parent,
                               View view, int position, long id) {
    }

    public void onNothingSelected(AdapterView<?> parent){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Dialog for å skrive inn eksamenskode før du går videre, eksamenskode må inn så ingen cancel knapp.

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Skriv inn eksamenskode");
        alert.setTitle("Skriv inn eksamenskode");
        //input for dialog
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        alert.setView(input);
        //dialogknapp OK, fjerner boksen
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
               String tv = input.getText().toString();
                dialog.dismiss();
            }
        });

        alert.show();

    /*    Button b1 = (Button) findViewById(R.id.button);

        b1.setOnClickListener(new onClickListener() {
                public void onClick(View view) {
                    new PostData();
                }
        });*/



        karakterSpinner = (Spinner)findViewById(R.id.karakterSpinner);
        karakterSpinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> aa=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, karakter);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        karakterSpinner.setAdapter(aa);

      //  String selectedKarakter = karakterSpinner.getSelectedItem().toString();
        }

    }

   // button.setOnClickListener()
     //        new PostData();








package com.example.senakutlu.designapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class RegisterActivity extends AppCompatActivity {

    public Spinner spn_createsex;
    public Spinner spn_createcity;
    TextView txt_createaccount;
    EditText txt_createaddress;
    EditText txt_createfname;
    EditText txt_createlname;
    EditText txt_createmail;
    EditText txt_createpassword;
    EditText txt_createpasswordagain;
    EditText txt_createphone;
    Button btn_createaccount;
    DatePicker date_createdbate;
    ScrollView scrll_create;
    public ArrayList<String> sextypes ;
    public ArrayList<String> cities;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        txt_createaccount = (TextView) findViewById(R.id.txt_createaccount);
        txt_createaddress = (EditText) findViewById(R.id.txt_createaddress);
        txt_createfname = (EditText) findViewById(R.id.txt_createfname);
        txt_createlname = (EditText) findViewById(R.id.txt_createlname);
        txt_createmail = (EditText) findViewById(R.id.txt_createmail);
        txt_createpassword = (EditText) findViewById(R.id.txt_createpassword);
        txt_createpasswordagain = (EditText) findViewById(R.id.txt_createpasswordagain);
        txt_createphone = (EditText) findViewById(R.id.txt_createphone);
        btn_createaccount = (Button) findViewById(R.id.btn_createaccount);
        date_createdbate = (DatePicker) findViewById(R.id.date_createbdate);
        scrll_create = (ScrollView) findViewById(R.id.scrll_create);
        spn_createsex = (Spinner) findViewById(R.id.spn_createsex);
        spn_createcity = (Spinner) findViewById(R.id.spn_createcity);

       Database db = new Database(getApplicationContext());

       sextypes= db.table_sextype();

/*

        //Database bağlantısı için
        File dbFile=new File(getFilesDir(),"my_app.db");
        SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(String.valueOf(dbFile),null,null);
        Log.i("TEST","DB is open: " + db.isOpen() );
*/

        ArrayAdapter<String>AdapterSex = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sextypes);
        spn_createsex.setAdapter(AdapterSex);

        btn_createaccount.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Database db= new Database(getApplicationContext());
                db.add_user("1234567","Ela", "",spn_createsex.getSelectedItem().toString(),"ela@gmail.com","03.03.1995","İstanbul");
                db.close();

                Intent myintent = new Intent(RegisterActivity.this, ProfileActivity.class);
                RegisterActivity.this.startActivity(myintent);

            }

        });
      /*  spn_createsex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                DbUserProcess db = (DbUserProcess) new Database(getApplicationContext());
                sextypes= db.table_sextype();

                ArrayAdapter<String> spinner_adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item, sextypes);

                spinner_adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);

                spn_createsex.setAdapter(spinner_adapter);
                Toast.makeText(getBaseContext(), ""+spn_createcity.getSelectedItem().toString()+"n"+parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });*/
    }
    }






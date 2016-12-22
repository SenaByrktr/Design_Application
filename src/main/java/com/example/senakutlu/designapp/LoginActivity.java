package com.example.senakutlu.designapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LoginActivity extends AppCompatActivity {

    private String mail;
    private String password;
    private String date;
    String error_message = "";
    private Boolean error = false;
    Button btn_login,btn_register;
    EditText mail_input,password_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mail_input = (EditText) findViewById(R.id.txt_mail);
        password_input = (EditText) findViewById(R.id.txt_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_register= (Button) findViewById(R.id.btn_register);


        btn_login.setOnClickListener(new View.OnClickListener() {//giris butonu tıklandiginnda

            public void onClick(View v) {

                mail = mail_input.getText().toString();//edittext degerini aliyoruz
                password = password_input.getText().toString();//edittext degerini aliyoruz

                //Tarih bilgisini almak icin
                Calendar c = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy");
                date = format.format(c.getTime());

                //Edittextlerden aldigimiz mail ve sifreleri kontrol ediyoruz
                if(mail.matches("")){
                    error_message = "Üye No yada E-Mail Alanı Boş Olamaz\n";
                    error = true;
                }

                if(error){//hata varsa AlertDialog ile kullanciyi bilgilendiriyoruz
                    AlertDialog alertDialog = new AlertDialog.Builder(LoginActivity.this).create();
                    alertDialog.setTitle("Error");
                    alertDialog.setMessage(error_message);
                    alertDialog.setCancelable(false);
                    alertDialog.setButton(RESULT_OK,"OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            password_input.setText("");
                            error_message = "";
                            error = false;
                        }
                    });
                    alertDialog.show();
                }

                else {
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    LoginActivity.this.startActivity(intent);
                }
            }
        });
          btn_register.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View view) {

                  Intent myintent = new Intent(LoginActivity.this, RegisterActivity.class);
                  LoginActivity.this.startActivity(myintent);

              }

    });

    }

}
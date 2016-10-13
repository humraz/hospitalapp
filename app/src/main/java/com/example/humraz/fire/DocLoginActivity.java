package com.example.humraz.fire;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class DocLoginActivity extends AppCompatActivity {

    EditText user,pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_login);

        user = (EditText)findViewById(R.id.user);
        pass = (EditText)findViewById(R.id.pass);

        login= (Button)findViewById(R.id.login);


    }

     public void click(View view)
     {
         InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
         imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
         String passs= pass.getText().toString();
         if(passs.equals("admin"))
         {
             Intent in = new Intent(this, DocActivity.class);
             startActivity(in);
         }
         else
         {
             Snackbar snackbar = Snackbar
                     .make(findViewById(android.R.id.content), "Wrong Password. Please Try Again!", Snackbar.LENGTH_LONG);
             snackbar.show();
         }


     }

}

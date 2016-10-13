package com.example.humraz.fire;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.onesignal.OneSignal;


public class appointmentspage extends ActionBarActivity {
    private Toolbar mToolbar;
    String url;
    private EditText editTextName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointmentspage);
        url="https://testforanything-ebdda.firebaseio.com/appointments";
        Firebase.setAndroidContext(this);
        OneSignal.startInit(this).init();
        editTextName = (EditText) findViewById(R.id.editText);

    }
    public void hello(View view)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        //Creating firebase object
        Firebase ref = new Firebase(url);

        //Getting values to store
        String name = "Doctor Pramesh Babu";
        // String address = editTextAddress.getText().toString().trim();
        String number = editTextName.getText().toString().trim();
        if(number.equals(""))
        {
            Toast.makeText(this, "enter your number first",Toast.LENGTH_LONG).show();
        }
        else {
            //Creating Person object
            Person person = new Person();
            name = name + "      " +number;
            //Adding values
            person.setName(name);
            //  person.setAddress(address);

            //Storing values to firebase
            ref.push().setValue(person);
            //editTextAddress.setText("");

            //Toast.makeText(this, "Successfully Booked With Dr.Pramesh " + number + "    Please Wait for a Call confirming your appointment", Toast.LENGTH_LONG).show();
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), "Successfully Booked Dr.Pramesh " + number + "    Please Wait For a Call Confirming Your Appointment", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }
    public void hello2(View view)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        //Creating firebase object
        Firebase ref = new Firebase(url);

        //Getting values to store
        String name = "Doctor Jaimon Jacob";
        // String address = editTextAddress.getText().toString().trim();
        String number = editTextName.getText().toString().trim();
        if(number.equals(""))
        {
            Toast.makeText(this, "enter your number first",Toast.LENGTH_LONG).show();
        }
        else {
            //Creating Person object
            Person person = new Person();
            name = name + "      " +number;
            //Adding values
            person.setName(name);
            //  person.setAddress(address);

            //Storing values to firebase
            ref.push().setValue(person);
            //editTextAddress.setText("");

            //Toast.makeText(this, "Successfully Booked With Dr.Jaimon " + number + "    Please Wait for a Call confirming your appointment", Toast.LENGTH_LONG).show();
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), "Successfully Booked Dr.Jaimon " + number + "    Please Wait For a Call Confirming Your Appointment", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }
    public void hello3(View view)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        //Creating firebase object
        Firebase ref = new Firebase(url);

        //Getting values to store
        String name = "Doctor Sunny Mathew";
        // String address = editTextAddress.getText().toString().trim();
        String number = editTextName.getText().toString().trim();
        if(number.equals(""))
        {
            Toast.makeText(this, "enter your number first",Toast.LENGTH_LONG).show();
        }
        else {
            //Creating Person object
            Person person = new Person();
            name = name + "      " +number;
            //Adding values
            person.setName(name);
            //  person.setAddress(address);

            //Storing values to firebase
            ref.push().setValue(person);
            //editTextAddress.setText("");

            //Toast.makeText(this, "Successfully Booked With Dr. Sunny " + number + "    Please Wait for a Call confirming your appointment", Toast.LENGTH_LONG).show();
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), "Successfully Booked Dr.Sunny " + number + "    Please Wait For a Call Confirming Your Appointment", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }
    public void hello4(View view)
    {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        //Creating firebase object
        Firebase ref = new Firebase(url);

        //Getting values to store
        String name = "Doctor Lisa Anice";
        // String address = editTextAddress.getText().toString().trim();
        String number = editTextName.getText().toString().trim();
        if(number.equals(""))
        {
            Toast.makeText(this, "Enter Your Number First",Toast.LENGTH_LONG).show();
        }
        else {
            //Creating Person object
            Person person = new Person();
            name = name + "      " +number;
            //Adding values
            person.setName(name);
            //  person.setAddress(address);

            //Storing values to firebase
            ref.push().setValue(person);
            //editTextAddress.setText("");

           // Toast.makeText(this, "Successfully Booked With Dr.Lisa " + number + "    Please Wait For a Call Confirming Your Appointment", Toast.LENGTH_LONG).show();
            Snackbar snackbar = Snackbar
                    .make(findViewById(android.R.id.content), "Successfully Booked Dr.Lisa " + number + "    Please Wait For a Call Confirming Your Appointment", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_appointmentspage, menu);
        return true;
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

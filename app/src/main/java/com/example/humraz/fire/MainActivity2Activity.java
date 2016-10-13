package com.example.humraz.fire;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.onesignal.OneSignal;


public class MainActivity2Activity extends ActionBarActivity {
    String url;
    private EditText editTextName;
    private EditText editTextAddress;
    private TextView textViewPersons;
    private TextView textViewPersons2;
    private Button buttonSave;
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        url="https://testforanything-ebdda.firebaseio.com/";
        Firebase.setAndroidContext(this);
        OneSignal.startInit(this).init();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        buttonSave = (Button) findViewById(R.id.bt);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextAddress = (EditText) findViewById(R.id.editTextAddress);
        textViewPersons = (TextView) findViewById(R.id.textView);
        textViewPersons2 = (TextView) findViewById(R.id.tv3);
    }

    public void read()
    {

        final Firebase ref = new Firebase(url);
        //Value event listener for realtime data update
        final StringBuilder finalTotal=new StringBuilder();
        final StringBuilder finalTotal2=new StringBuilder();
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot usersSnapshot) {

                for (DataSnapshot userSnapshot : usersSnapshot.getChildren()) {
                    Person user = userSnapshot.getValue(Person.class);
                    String a;
                    a= user.getName()+ ' '+ user.getAddress();
                    finalTotal.append(user.getName());
                    finalTotal.append('\n');
                    finalTotal2.append(user.getAddress());
                    finalTotal2.append("%\n");
                    textViewPersons.setText(finalTotal.toString());
                    textViewPersons2.setText(finalTotal2.toString());

                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    }

    public void delete(View view)
    {
       /* final Firebase ref = new Firebase(url);
        ref.removeValue();
        textViewPersons2.setText("");
        textViewPersons.setText("");
        Toast.makeText(this, "Deletion Successfull", Toast.LENGTH_LONG).show();*/
        Intent in = new Intent(this,card.class);
        startActivity(in);

    }
    public void go (View view)
    {
        Intent in = new Intent(this, volleys.class);
        startActivity(in);
    }
    public void sendfirebase(View view)
    {

        //Creating firebase object
        Firebase ref = new Firebase(url);

        //Getting values to store
        String name = editTextName.getText().toString().trim();
        String address = editTextAddress.getText().toString().trim();

        //Creating Person object
        Person person = new Person();

        //Adding values
        person.setName(name);
        person.setAddress(address);

        //Storing values to firebase
        ref.push().setValue(person);
        editTextAddress.setText("");
        editTextName.setText("");
        Toast.makeText(this, "Enter next Record", Toast.LENGTH_LONG).show();
        read();

    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity2, menu);
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

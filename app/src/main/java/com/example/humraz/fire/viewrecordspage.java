package com.example.humraz.fire;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;


public class viewrecordspage extends ActionBarActivity {
String url;
    TextView text;
    TextView text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewrecordspage);
        Firebase.setAndroidContext(this);
        url="https://testforanything-ebdda.firebaseio.com/";
        read();
        text = (TextView) findViewById(R.id.text);

        text2 = (TextView) findViewById(R.id.textView51);
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

                    finalTotal.append(user.getName());
                    finalTotal.append('\n');
                    finalTotal2.append(user.getAddress());
                    finalTotal2.append("%\n");
                    text.setText(finalTotal.toString());
                    text2.setText(finalTotal2.toString());

                }

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_viewrecordspage, menu);
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

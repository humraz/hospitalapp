package com.example.humraz.fire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SharedActivity extends AppCompatActivity {
Preference preference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared);



        Button doc = (Button)findViewById(R.id.b_doc);
        Button pat = (Button)findViewById(R.id.b_pat);

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //preference.setDoc(true);

                startActivity(new Intent(SharedActivity.this,DocLoginActivity.class));

            }
        });


    }
    public  void patient(View view)
    {
        Intent in = new Intent(this,UserActivity.class);
        startActivity(in);
    }

}

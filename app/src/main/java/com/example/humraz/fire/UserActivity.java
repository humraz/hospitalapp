package com.example.humraz.fire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class UserActivity extends AppCompatActivity {

    String[] user_list = {"Appointment","Medicine","Complaints","Records","Notification"};

    int id[] = {R.drawable.ic_appointment,R.drawable.ic_pills,R.drawable.ic_complaint,R.drawable.ic_report,R.drawable.ic_hospital};

    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        grid = (GridView)findViewById(R.id.grid);

        GridAdapter adapter = new GridAdapter(this,user_list,id);

        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(UserActivity.this,appointmentspage.class));
                        break;
                    case 1:
                        startActivity(new Intent(UserActivity.this,appointmentspage.class));
                        break;

                    case 2:
                        startActivity(new Intent(UserActivity.this,complaintpage.class));
                        break;

                    case 3:
                        startActivity(new Intent(UserActivity.this,viewrecordspage.class));
                        break;

                    case 4:
                        startActivity(new Intent(UserActivity.this,patientnotification.class));
                        break;
                }
            }
        });

    }
}

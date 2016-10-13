package com.example.humraz.fire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class DocActivity extends AppCompatActivity {

    String[] doc_items = {"Records","Appointments","Notifications","Extras"};
    int[] id = {R.drawable.ic_report,R.drawable.ic_stethoscope,R.drawable.ic_flag,R.drawable.ic_hospital};

    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc);

        grid = (GridView)findViewById(R.id.grid);

        GridAdapter adapter = new GridAdapter(this,doc_items,id);

        grid.setAdapter(adapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        startActivity(new Intent(DocActivity.this,doctorrecords.class));
                        break;
                    case 1:
                        startActivity(new Intent(DocActivity.this,appointmentspage.class));
                        break;

                    case 2:
                        startActivity(new Intent(DocActivity.this,doctornotifications.class));
                        break;

                    case 3:

                        break;

                }
            }
        });


    }
}

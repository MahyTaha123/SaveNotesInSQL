package com.example.maha.savenotesinsql;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DataBaseHelper mydbHelper;

    EditText edNoteMess;
    Button addNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edNoteMess = (EditText) findViewById(R.id.edNoteMess);
        addNotes = (Button) findViewById(R.id.addNotes);

        mydbHelper = new DataBaseHelper(this);


        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean isInserted = mydbHelper.insertData(edNoteMess.getText().toString());
                if (isInserted)
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "NOtInserted", Toast.LENGTH_LONG).show();

            }
        });


    }
}

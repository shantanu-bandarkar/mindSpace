package com.example.mindspace.Contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mindspace.DB_handler;
import com.example.mindspace.R;

public class Add_contact extends AppCompatActivity {

    DB_handler db_obj;
    EditText name, number;
    Button insert, View_contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        db_obj = new DB_handler(this);

        name= findViewById(R.id.name);
        number= findViewById(R.id.number);
        insert = findViewById(R.id.btn_Insert);
        View_contact =findViewById(R.id.btn_view);

        //OnClick functions;
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String contact = name.getText().toString();
                String mob = number.getText().toString();
                Boolean check = db_obj.insertData(contact, mob);

                if (check == true) {
                    Toast.makeText(Add_contact.this, "Data inserted Successfully!", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    number.setText("");
                } else
                    Toast.makeText(Add_contact.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
            }
        });


        View_contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Make_Call.class);
                startActivity(i);
            }
        });
    }
}
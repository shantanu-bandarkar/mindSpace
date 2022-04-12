package com.example.mindspace.Contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mindspace.DB_handler;
import com.example.mindspace.R;

import java.util.ArrayList;

public class Make_Call extends AppCompatActivity {

    DB_handler dbh;
    private RecyclerView recyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_call);

        Log.d("view", "Inside View Registrations Activity");

        dbh = new DB_handler(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Registration> allRegs = dbh.getAllRegistrations();

        recyclerViewAdapter = new RecyclerViewAdapter(Make_Call.this, allRegs);
        recyclerView.setAdapter(recyclerViewAdapter);

    }
    public void RearrangeItems() {
        dbh = new DB_handler(this);
        ArrayList<Registration> allRegs = dbh.getAllRegistrations();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(Make_Call.this, allRegs);
        recyclerView.setAdapter(adapter);
    }
}
package dxexwxexy.server.Activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import dxexwxexy.server.R;

public class Server extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Server - Categories");
        initFloatingButtons();
    }

    private void initFloatingButtons() {
        FloatingActionButton switchDB = findViewById(R.id.switch_db);
        FloatingActionButton addEntry = findViewById(R.id.add_entry);
        switchDB.setOnClickListener(e -> {
            // TODO: 7/9/2018 switch to other intent
        });
        addEntry.setOnClickListener(e -> {
            // TODO: 7/9/2018 connect database
        });
    }

}

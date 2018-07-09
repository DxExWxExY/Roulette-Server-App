package dxexwxexy.server.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

import dxexwxexy.server.R;

public class CategoriesDisplay extends AppCompatActivity {

    private TextView networkInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories_server);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("DB - Categories");
        initFloatingButtons();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.server_menu, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, R.string.back_disabled, Toast.LENGTH_SHORT).show();
    }

    private void initFloatingButtons() {
        networkInfo = findViewById(R.id.net_info_cat);
        FloatingActionButton switchDB = findViewById(R.id.switch_places);
        FloatingActionButton addEntry = findViewById(R.id.add_category);
        switchDB.setOnClickListener(e -> {
            startActivity(new Intent(CategoriesDisplay.this, PlacesDisplay.class));
            finish();
        });
        addEntry.setOnClickListener(e -> {
            // TODO: 7/9/2018 popup
        });
    }

}
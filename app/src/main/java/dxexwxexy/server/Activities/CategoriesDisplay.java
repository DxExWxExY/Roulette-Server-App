package dxexwxexy.server.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dxexwxexy.server.R;
import dxexwxexy.server.Support.Tools;

public class CategoriesDisplay extends AppCompatActivity {

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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.erase_db:
                // TODO: 7/9/2018 popup to erase current
                break;
            case R.id.erase_dbs:
                // TODO: 7/9/2018 popup to erase all
                break;
            case R.id.show_logs:
                startActivity(new Intent(CategoriesDisplay.this, ServerLog.class));
                break;
            case R.id.kill_app:
                finish();
                break;
            case R.id.kill_service:
                // TODO: 7/9/2018 start or stop service
                break;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, R.string.back_disabled, Toast.LENGTH_SHORT).show();
    }

    private void initFloatingButtons() {
        TextView networkInfo = findViewById(R.id.net_info_cat);
        networkInfo.setText("Server on port: " + Tools.port + " @ " + Tools.ip);
        FloatingActionButton switchDB = findViewById(R.id.switch_places);
        FloatingActionButton addEntry = findViewById(R.id.add_category);
        switchDB.setOnClickListener(e -> {
            startActivity(new Intent(CategoriesDisplay.this, PlacesDisplay.class));
            finish();
        });
        addEntry.setOnClickListener(e -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(CategoriesDisplay.this);
            View view = getLayoutInflater().inflate(R.layout.cat_entry_popup, null);
            final EditText catEntry = findViewById(R.id.cat_entry);
            final Button add = findViewById(R.id.cat_add);
            add.setOnClickListener(a -> {
                if (!catEntry.getText().toString().isEmpty()) {
                    // TODO: 7/9/2018 add to db
                    Tools.updateLog("Entry in Categories added");
                } else {
                    catEntry.setError("A category is required");
                    catEntry.requestFocus();
                }

            });
            builder.setView(view);
            AlertDialog dialog = builder.create();
            dialog.show();
        });
    }

}

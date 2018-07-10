package dxexwxexy.server.Activities;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import dxexwxexy.server.R;
import dxexwxexy.server.Support.Tools;

public class ServerLog extends AppCompatActivity {

    static TextView logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_log);
        setTitle("Server Logs");
        logs = findViewById(R.id.server_logs);
        logs.setText(Tools.logs);
        Handler handler = new Handler();
        handler.postDelayed(() -> logs.setText(Tools.logs), 2000);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

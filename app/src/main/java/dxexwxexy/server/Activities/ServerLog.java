package dxexwxexy.server.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import dxexwxexy.server.R;

public class ServerLog extends AppCompatActivity {

    public static TextView logs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_server_log);
        setTitle("Server Logs");
    }
}

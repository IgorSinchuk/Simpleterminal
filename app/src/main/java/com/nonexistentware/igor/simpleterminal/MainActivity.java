package com.nonexistentware.igor.simpleterminal;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView status;
    private BluetoothAdapter ba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.input);
        status = (TextView) findViewById(R.id.status);

        ba = BluetoothAdapter.getDefaultAdapter();



        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String wnCommands = input.getText().toString(); // wifi & network

                status.setText("Input command");

                switch (wnCommands) {
                    case "wf on":
                        status.setText("Wifi is working");
                        WifiManager wifiOn = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                        wifiOn.setWifiEnabled(true);
                        break;
                    case "wf off":
                        status.setText("Wifi is on offline mode");
                        WifiManager wifiOff = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                        wifiOff.setWifiEnabled(false);
                        break;
                    case "bt on":
                        status.setText("Bluetooth is enabled");
                        if (!ba.isEnabled()) {
                            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivityForResult(turnOn, 0);
                        }
                        break;

                    case "bt off":
                        status.setText("Bluetooth is enabled");
                        if (!ba.disable()) {
                            Intent turnOff = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                            startActivityForResult(turnOff, 0);
                        }
                        break;
                            default:
                                status.setText("Unknown command '" + wnCommands + "'");
                        }
            }

        });

        
        String infoCommands = input.getText().toString(); // phone information

        status.setText("Input command");

        switch (infoCommands) {

        }
    }
}

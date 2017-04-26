package com.nonexistentware.igor.simpleterminal;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.os.Build.BOOTLOADER;

public class MainActivity extends AppCompatActivity {

    private EditText input;
    private TextView status;
    private BluetoothAdapter ba;

    private ActivityManager.MemoryInfo mi = new ActivityManager.MemoryInfo();

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
                        WifiManager wifiOn = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE); // wifi on
                        wifiOn.setWifiEnabled(true);
                        break;

                    case "wf off":
                        status.setText("Wifi is on offline mode");
                        WifiManager wifiOff = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE); // wifi off
                        wifiOff.setWifiEnabled(false);
                        break;

                    case "bt on":
                        status.setText("Bluetooth is enabled");
                        if (!ba.isEnabled()) {
                            Intent turnOn = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE); // bluetooth on
                            startActivityForResult(turnOn, 0);
                        }
                        break;

                    case "bt off":
                        status.setText("Bluetooth is enabled");
                        if (!ba.disable()) {
                            Intent turnOff = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE); // bluetooth on
                            startActivityForResult(turnOff, 0);
                        }
                        break;

                    case "md":
                        status.setText("");
                        Intent wireless = new Intent(Settings.ACTION_WIRELESS_SETTINGS); // Wireless & networks
                        startActivity(wireless);
                        break;

                    case "model":
                        status.setText("MODEL :" + Build.MODEL + "\n"); // phone model
                        break;

                    case "board":
                        status.setText("BOARD :" + Build.BOARD); // board
                        break;

                    case "bootloader":
                        status.setText("BOOTLOADER :" +android.os.Build.BOOTLOADER); // boot loader
                        break;

                    case "cpu -a" :
                        status.setText("CPU ABI: " +android.os.Build.CPU_ABI); // cpu architecture type
                        break;

                    case "cpu -m" :
                        status.setText("HARDWARE :" + android.os.Build.HARDWARE); // cpu manufacturer
                        break;

                    case "display" :
                        status.setText("DISPLAY :" +android.os.Build.DISPLAY); // cpu display
                        break;

                    case "host" :
                        status.setText("HOST: " + Build.HOST); // host
                        break;

                    case "id" :
                        status.setText("ID: " +android.os.Build.ID); // id
                        break;

                    case "product" :
                        status.setText("PRODUCT : " + android.os.Build.PRODUCT); // product
                        break;

                    case "radio" :
                        status.setText("RADIO : " + Build.RADIO); // radio
                        break;

                    case "serial" :
                        status.setText("SERIAL : " + Build.SERIAL); // serial
                        break;

                    case "tags" :
                        status.setText("TAGS : " + Build.TAGS); // tags
                        break;

                    case "time" :
                        status.setText("TIME : " + Build.TIME); // time
                        break;

                    case "type" :
                        status.setText("TYPE : " + Build.TYPE); // type
                        break;

                    case "user" :
                        status.setText("USER : " + Build.USER); // user
                        break;

                    case "v -name" :
                        status.setText("PRODUCT : " + Build.VERSION.CODENAME); // version codename
                        break;

                    case "v -incr" :
                        status.setText("INCREMENTAL : " + android.os.Build.VERSION.INCREMENTAL); // version incremental
                        break;

                    case "v -rls" :
                        status.setText("RELEASE : " + android.os.Build.VERSION.RELEASE); // version release
                        break;

                    case "v -sdk" :
                        status.setText("SDK : " + Build.VERSION.SDK); // version sdk
                        break;

                    case "v -int" :
                        status.setText("SDK_INT : " + Build.VERSION.SDK_INT); // version sdk int
                        break;

                    case "os -arch" :
                        status.setText("OS.ARCH : " + System.getProperty("os.arch")); // arch
                        break;

                    case "os -name" :
                        status.setText("OS.NAME : " + System.getProperty("os.name")); // name
                        break;

                    case "os -ver" :
                        status.setText("OS.VERSION : " + System.getProperty("os.version")); // version
                        break;


                    default:
                        status.setText("I don`t know command '" + wnCommands + "'"); // unknown commands
                        break;
                }
            }

        });

    }
    }


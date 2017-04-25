package com.nonexistentware.igor.simpleterminal;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by igor on 4/25/17.
 */

public class BT extends AppCompatActivity{

    public static boolean setBluetooth(boolean enable) {
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        boolean isEnabled = bluetoothAdapter.isEnabled();

        return isEnabled;
    }
}
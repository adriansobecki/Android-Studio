package com.example.ap2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.view.View;

import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private static Context context;
    public static TextView devices_text;
    BluetoothAdapter bluetoothAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 5);
        }

        MainActivity.context = getApplicationContext();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        devices_text=findViewById(R.id.textView);
        enableBluetooth();

    }

    public static Context getAppContext() {
        return MainActivity.context;
    }

    private void enableBluetooth(){
        if (!bluetoothAdapter.isEnabled())
        {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 6);
        }
        else
        {
            Connection.initialization();
            Connection.startScanLeDevice();
            devices_text.setText("Scanning...");
        }
    }

    public void btn_connect(View view)
    {
        //BluetoothManager ble_manager=(BluetoothManager)getSystemService(BLUETOOTH_SERVICE);
        for(BluetoothDevice i:Connection.devices)
        {
            if(i.getName()!=null) {
                if (i.getName().equals("BT05")) {
                    Connection.bluetoothGatt = i.connectGatt(MainActivity.getAppContext(), false, bluetoothGattCallback);
                    break;
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 6) {
            Connection.initialization();
            Connection.startScanLeDevice();
            devices_text.setText("Scanning...");
        }

    }

    public final BluetoothGattCallback bluetoothGattCallback = new BluetoothGattCallback() {
        @Override
        public void onServicesDiscovered(BluetoothGatt gatt, int status)
        {
            if(status==0)
            {
                Connection.getServicesWithCharacteristics();
                Intent test = new Intent (MainActivity.this,
                        MainActivity2.class);
                startActivity(test);
            }

        }
        @Override
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int status, int newState) {
            if (newState == BluetoothProfile.STATE_CONNECTED) {
                Connection.bluetoothGatt.discoverServices();

            } else if (newState == BluetoothProfile.STATE_DISCONNECTED) {

            }

        }
    };

}
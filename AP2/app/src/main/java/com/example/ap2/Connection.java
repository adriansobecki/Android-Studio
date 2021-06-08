package com.example.ap2;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class Connection {

    public static BluetoothAdapter bluetoothAdapter;
    public static BluetoothLeScanner bluetoothLeScanner;
    public static ArrayList<BluetoothDevice> devices;
    public static BluetoothGatt bluetoothGatt;
    public static BluetoothGattCharacteristic bluetoothGattCharacteristic;

    public static void initialization() {
        devices = new ArrayList<BluetoothDevice>();
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        bluetoothLeScanner = bluetoothAdapter.getBluetoothLeScanner();

    }


    public static void getServicesWithCharacteristics() {
        java.util.UUID uuidYouCanUse = null;
        java.util.List<android.bluetooth.BluetoothGattService> services = bluetoothGatt.getServices();
        BluetoothGattService test2 = services.get(3);

        uuidYouCanUse = test2.getUuid();
        java.util.List<android.bluetooth.BluetoothGattCharacteristic> chara = test2.getCharacteristics();

        BluetoothGattCharacteristic characteristic = chara.get(0);
        bluetoothGattCharacteristic = characteristic;
        //Log.i("UUID", characteristic.getUuid().toString());
    }

    public static void startScanLeDevice() {
        bluetoothLeScanner.startScan(leScanCallback);
    }

    public static void stopScanLeDevice() {
        bluetoothLeScanner.stopScan(leScanCallback);
    }


    public static ScanCallback leScanCallback =
            new ScanCallback() {
                @Override
                public void onScanResult(int callbackType, ScanResult result) {
                    super.onScanResult(callbackType, result);
                    BluetoothDevice device = result.getDevice();
                    if (device != null) {
                        if (devices != null) {
                            if (!devices.contains(device)) {
                                devices.add(device);
                            }
                            if (device.getName() != null) {
                                if (device.getName().equals("BT05")) {
                                    Connection.stopScanLeDevice();
                                    MainActivity.devices_text.setText(MainActivity.devices_text.getText() + "\nFound BT05");
                                    MainActivity.devices_text.setText(MainActivity.devices_text.getText() + "\nStop scanning\nPress btn connect");
                                }
                            }

                        }
                    }
                }
            };

}

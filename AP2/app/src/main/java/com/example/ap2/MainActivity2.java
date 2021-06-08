package com.example.ap2;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity2 extends Activity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ImageButton btnForward=findViewById(R.id.btnForward);
        ImageButton btnBackward=findViewById(R.id.btnBackward);
        ImageButton btnLeftF=findViewById(R.id.btnLeftF);
        ImageButton btnLeftB=findViewById(R.id.btnLeftB);
        ImageButton btnRightF=findViewById(R.id.btnRightF);
        ImageButton btnRightB=findViewById(R.id.btnRightB);


        btnForward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Connection.bluetoothGattCharacteristic.setValue("0");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);

                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_DOWN){

                    Connection.bluetoothGattCharacteristic.setValue("1");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);
                    return true;
                }
                return false;
            }
        });



        btnBackward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Connection.bluetoothGattCharacteristic.setValue("0");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);

                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_DOWN){

                    Connection.bluetoothGattCharacteristic.setValue("2");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);
                    return true;
                }
                return false;
            }
        });


        btnLeftF.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Connection.bluetoothGattCharacteristic.setValue("0");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);

                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_DOWN){

                    Connection.bluetoothGattCharacteristic.setValue("3");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);
                    return true;
                }
                return false;
            }
        });



        btnLeftB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Connection.bluetoothGattCharacteristic.setValue("0");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);

                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_DOWN){

                    Connection.bluetoothGattCharacteristic.setValue("4");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);
                    return true;
                }
                return false;
            }
        });



        btnRightF.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Connection.bluetoothGattCharacteristic.setValue("0");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);

                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_DOWN){

                    Connection.bluetoothGattCharacteristic.setValue("5");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);
                    return true;
                }
                return false;
            }
        });



        btnRightB.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_UP){
                    Connection.bluetoothGattCharacteristic.setValue("0");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);

                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_DOWN){

                    Connection.bluetoothGattCharacteristic.setValue("6");
                    Connection.bluetoothGattCharacteristic.setWriteType(BluetoothGattCharacteristic.WRITE_TYPE_NO_RESPONSE);
                    Connection.bluetoothGatt.writeCharacteristic(Connection.bluetoothGattCharacteristic);
                    return true;
                }
                return false;
            }
        });

    }
}
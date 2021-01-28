package com.iagodkin.ble_client;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import java.util.UUID;

public class BluetoothLEService extends Service {
    private final static String TAG = BluetoothLEService.class.getSimpleName();

    private BluetoothManager btManager;
    private BluetoothAdapter btAdapter;
    private String btDeviceAddress;
    private BluetoothGatt btGatt;
    private int connectState = STATE_DISCONNECTED;

    public static final int STATE_DISCONNECTED = 0;
    public static final int STATE_CONNECTING = 1;
    public static final int STATE_CONNECTED = 2;

    public static final String ACTION_GATT_CONNECTED = "com.iagodkin.ble_client.ACTION_GATT_CONNECTED";
    public static final String ACTION_GATT_DISCONNECTED = "com.iagodkin.ble_client.ACTION_GATT_DISCONNECTED";
    public static final String ACTION_GATT_SERVICES_DISCOVERED = "com.iagodkin.ble_client.ACTION_GATT_SERVICES_DISCOVERED";
    public static final String ACTION_DATA_AVAILABLE = "com.iagodkin.ble_client.ACTION_DATA_AVAILABLE";
    public static final String ACTION_EXTRA_DATA = "com.iagodkin.ble_client.ACTION_EXTRA_DATA";

    public final static UUID UUID_CHAR = UUID.fromString()


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

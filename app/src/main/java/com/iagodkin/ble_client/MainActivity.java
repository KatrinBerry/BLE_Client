package com.iagodkin.ble_client;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothManager;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private BluetoothManager btManager;
    private BluetoothAdapter btAdapter;
    public static final int REQUEST_ENABLE_BT = 1;
    private BluetoothLeScanner bLeScanner;
    private BluetoothDevice btDevice;
    private boolean isScanning;

    private BluetoothGattCharacteristic mNotifyCharacteristic;
    private boolean isConnected = false;

    private BluetoothLEService bLEService;

    TextView deviceName, deviceAddress, textDeviceState, deviceState,serviceName;
    AppCompatButton startScanBtn, connectDeviceBtn, connectServiceBtn;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        deviceName = findViewById(R.id.deviceName);
        deviceAddress = findViewById(R.id.deviceAddress);
        textDeviceState = findViewById(R.id.textDeviceState);
        deviceState = findViewById(R.id.deviceState);
        serviceName = findViewById(R.id.serviceName);

        startScanBtn = findViewById(R.id.startScanBtn);
        connectDeviceBtn = findViewById(R.id.connectDeviceBtn);
        connectServiceBtn = findViewById(R.id.connectServiceBtn);

        progressBar = findViewById(R.id.progressBar);

        btStartScan();

    }

    private void btStartScan() {
        btManager = (BluetoothManager) getSystemService(BLUETOOTH_SERVICE);
        btAdapter = btManager.getAdapter();

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            bLeScanner = btAdapter.getBluetoothLeScanner();

            ScanSettings scanSettings = new ScanSettings.Builder()
                    .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
                    .build();

            ScanCallback callback = new ScanCallback() {
                @Override
                public void onScanFailed(int errorCode) {
                    Log.i(TAG, "onScanFailed error: " + errorCode);
                }

                @Override
                public void onScanResult(int callbackType, ScanResult result) {
                    BluetoothDevice device = result.getDevice();
                }
            };

            bLeScanner.startScan(scanFilters, scanSettings, callback);

        } else {
            return;
        }
    }
}
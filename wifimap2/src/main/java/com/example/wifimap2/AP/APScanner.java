package com.example.wifimap2.AP;

import android.app.Activity;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wifimap2.MainActivity;

import java.util.List;

public class APScanner extends Activity {

    public APScanner()
    {
    }


    public TextView mainTextView;

    public List<ScanResult> scRes;

}

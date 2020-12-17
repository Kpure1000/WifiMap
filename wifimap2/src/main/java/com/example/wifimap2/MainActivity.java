package com.example.wifimap2;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wifimap2.AP.APScanner;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        scannerView = findViewById(R.id.textView6);

        APScanner apScanner = new APScanner();

        Button startButton = findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnB1Cloick();
            }
        });
    }


    private WifiManager wifiManager;

    public void OnB1Cloick()
    {
        wifiManager =(WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        String reStr="大大大大大大大大SAD";
        final boolean b = wifiManager.startScan();
        if(b) {
            final List<ScanResult> res = wifiManager.getScanResults();
            reStr+="ID: ";
            for (ScanResult item :
                    res) {
                reStr+=item.BSSID+"\n";
//              System.out.println(item.BSSID);
            }
        }
        else {
            reStr += "Scanner错误.";
        }
        scannerView.setText(reStr);
    }

    public TextView scannerView;

}

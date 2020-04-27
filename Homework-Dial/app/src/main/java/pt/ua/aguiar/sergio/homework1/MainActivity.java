package pt.ua.aguiar.sergio.homework1;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String numberString = "";

    private TextView numberShowing;
    private ImageView deleteNumber;

    private Button dial0;
    private Button dial1;
    private Button dial2;
    private Button dial3;
    private Button dial4;
    private Button dial5;
    private Button dial6;
    private Button dial7;
    private Button dial8;
    private Button dial9;
    private Button dialAsterisk;
    private Button dialCardinal;
    private Button call;

    Intent callIntent = new Intent(Intent.ACTION_CALL);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, 101);
        }

        numberShowing = findViewById(R.id.phoneNumberText);
        deleteNumber = findViewById(R.id.phoneNumberDeleteButton);

        dial0 = findViewById(R.id.dial0);
        dial1 = findViewById(R.id.dial1);
        dial2 = findViewById(R.id.dial2);
        dial3 = findViewById(R.id.dial3);
        dial4 = findViewById(R.id.dial4);
        dial5 = findViewById(R.id.dial5);
        dial6 = findViewById(R.id.dial6);
        dial7 = findViewById(R.id.dial7);
        dial8 = findViewById(R.id.dial8);
        dial9 = findViewById(R.id.dial9);
        dialAsterisk = findViewById(R.id.dialAsterisk);
        dialCardinal = findViewById(R.id.dialCardinal);
        call = findViewById(R.id.callButton);

        deleteNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeDigit();
            }
        });

        dial0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("0");
            }
        });

        dial1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("1");
            }
        });

        dial2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("2");
            }
        });

        dial3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("3");
            }
        });

        dial4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("4");
            }
        });

        dial5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("5");
            }
        });

        dial6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("6");
            }
        });

        dial7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("7");
            }
        });

        dial8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("8");
            }
        });

        dial9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("9");
            }
        });

        dialAsterisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("*");
            }
        });

        dialAsterisk.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                callNumber("112");
                return true;
            }
        });

        dialCardinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDigit("#");
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNumber(numberString);
            }
        });
    }

    private void addDigit(String digit) {
        if(numberString.length() == 12) return;
        numberString += digit;
        numberShowing.setText(numberString);
    }

    private void removeDigit() {
        if(numberString.length() == 0) return;
        numberString = numberString.substring(0, numberString.length() - 1);
        numberShowing.setText(numberString);
    }

    private void callNumber(String numberString) {
        String numberURI = "tel:" + numberString;
        callIntent.setData(Uri.parse(numberURI));
        // callIntent.setPackage("com.android.phone");

        if(ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) return;

        startActivity(callIntent);
    }
}

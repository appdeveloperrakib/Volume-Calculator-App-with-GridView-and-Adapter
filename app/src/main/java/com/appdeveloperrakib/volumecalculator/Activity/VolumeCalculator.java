package com.appdeveloperrakib.volumecalculator.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.appdeveloperrakib.volumecalculator.R;

public class VolumeCalculator extends AppCompatActivity {

    EditText redius,height;
    TextView title,result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumecalculator);

        redius = findViewById(R.id.editText);
        height = findViewById(R.id.editText2);
        title = findViewById(R.id.textview2);
        result = findViewById(R.id.result);
        btn = findViewById(R.id.bt1);

        Intent intent = getIntent();
        String toptitle = intent.getStringExtra("title");
        title.setText(toptitle+" Volume");

        if(toptitle.contains("Cylinder")){
            height.setVisibility(View.VISIBLE);
        } else if (toptitle.contains("Cube")) {
            redius.setVisibility(View.GONE);
            height.setVisibility(View.VISIBLE);
        }else if(toptitle.contains("Prism")){

            redius.setVisibility(View.VISIBLE);
            height.setVisibility(View.VISIBLE);
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(redius.getText().toString().isEmpty() || height.getText().toString().isEmpty()) {

                    Toast.makeText(VolumeCalculator.this, "Please Enter a Number", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (toptitle.contains("Sphere")) {
                        String radius = redius.getText().toString();
                        Double r = Double.parseDouble(radius);

                        CalculateSphereVolume(r);

                    } else if (toptitle.contains("Cylinder")) {

                        String radius = redius.getText().toString();
                        String heigh = height.getText().toString();
                        Double r = Double.parseDouble(radius);
                        Double h = Double.parseDouble(heigh);

                        CalculateCylinderVolume(r, h);

                    } else if (toptitle.contains("Cube")) {
                        String lengt = height.getText().toString();
                        Double length = Double.parseDouble(lengt);

                        CalculateCubeVolume(length);

                    } else {

                        String widt = redius.getText().toString();
                        String heigh = height.getText().toString();
                        Double width = Double.parseDouble(widt);
                        Double length = Double.parseDouble(heigh);

                        CalculatePrismVolume(width, length);
                    }

                }


                //Volume of Cylinder = pi * r^2 * h




            }
        });
    }
    // onCreate End ---------

    public void CalculateSphereVolume(Double r){
        double volume = (4/3) * 3.1416 *r*r*r;
        result.setText("V = "+volume+"m^3");
    }
    public void CalculateCylinderVolume (Double r, Double h){
        double volume = 3.1416 * r * r * h;
        result.setText("V = "+volume+"m^3");
    }

    public void  CalculateCubeVolume(Double l){

        Double volume = l *  l * l;
        result.setText("V = "+volume+"m^3");

    }

    public  void  CalculatePrismVolume(Double width, Double height){

        Double volume = width * height ;
        result.setText("V = "+volume+"m^3");


    }

}
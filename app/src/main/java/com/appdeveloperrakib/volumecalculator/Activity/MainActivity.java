package com.appdeveloperrakib.volumecalculator.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import com.appdeveloperrakib.volumecalculator.Adapter.MyCustomAdapter;
import com.appdeveloperrakib.volumecalculator.Model.Shape;
import com.appdeveloperrakib.volumecalculator.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // 1- AdapterView : GridView
    GridView gridView;

    // 2- Data Source: ArrayList<Shape>
    ArrayList<Shape> shapeArrayList;

    // 3- Adapter: MyCustomAdapter

    MyCustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);

        shapeArrayList = new ArrayList<>();

        Shape s1 = new Shape(R.drawable.sphere,"Sphere");
        Shape s2 = new Shape(R.drawable.cylinder,"Cylinder");
        Shape s3 = new Shape(R.drawable.cube,"Cube");
        Shape s4 = new Shape(R.drawable.prism,"Prism");

        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);

        adapter = new MyCustomAdapter(shapeArrayList,getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                int position = i;

                if(position == 0){
                    IntentMethod("Sphere");
                } else if (position == 1) {
                    IntentMethod("Cylinder");
                }else if (position == 2) {
                    IntentMethod("Cube");
                }else if (position == 3) {
                    IntentMethod("Prism");

                }


            }
        });


    }
    //--- OnCreate End -------------

    public void IntentMethod(String Massage){
        Intent intent = new Intent(getApplicationContext(), VolumeCalculator.class);
        intent.putExtra("title",Massage);
        startActivity(intent);
    }


}
package com.example.lab5dapm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private ListView lv_list_cars;
    CarAdapter carAdapter;
    private EditText ed_new_car;
    private Button b_add_car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_list_cars = findViewById(R.id.lv_list_cars);
        carAdapter = new CarAdapter(MainActivity.this);
        lv_list_cars.setAdapter(carAdapter);

        carAdapter.addCar("Audi", R.drawable.lab5_car_icon);
        carAdapter.addCar("BMW", R.drawable.lab5_car_icon);
        carAdapter.addCar("Tesla", R.drawable.lab5_car_icon);
        carAdapter.addCar("Mercedes", R.drawable.lab5_car_icon);

        ed_new_car = findViewById(R.id.ed_new_car);
        b_add_car = findViewById(R.id.b_add_car);


        b_add_car.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name = ed_new_car.getText().toString();
                int imagine = R.drawable.lab5_car_icon;

                carAdapter.addCar(name, imagine);
                ed_new_car.setText("");
            }
        });



    }
}

class Car{
    String name;
    int imageResource;
}

class TagCar{
    TextView name;
    ImageView image;
}


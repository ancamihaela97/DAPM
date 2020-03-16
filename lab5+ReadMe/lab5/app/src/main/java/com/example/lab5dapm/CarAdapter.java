package com.example.lab5dapm;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CarAdapter extends BaseAdapter {
    Activity context;
    ArrayList<Car> cars;

    public CarAdapter (Activity context) {
        this.context=context;
        cars= new ArrayList<>();
    }

    public void addCar(String nameCar, int resource){
        Car car = new Car();
        car.name = nameCar;
        car.imageResource = resource;
        cars.add(car);
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {

        return cars.size();
    }

    @Override
    public Object getItem(int position) {

        return cars.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View element;
        if(view == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            element = layoutInflater.inflate(R.layout.list_item, null);

            TagCar car = new TagCar();

            car.name = element.findViewById(R.id.tv_name_element);
            car.image = element.findViewById(R.id.iv_image_element);

            element.setTag(car);
        }
        else element = view;

        TagCar tag = (TagCar) element.getTag();

        tag.name.setText(cars.get(i).name);
        tag.image.setImageResource(cars.get(i).imageResource);

        return element;
    }
}

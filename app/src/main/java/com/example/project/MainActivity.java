package com.example.project;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    private static final List<Food> dishes = new ArrayList<Food>();

    static {
        dishes.add(new Food("Жареная ворона", "150$"));
        dishes.add(new Food("Крабсбургер", "999$"));
        dishes.add(new Food("Чай Улун", "15$"));
        dishes.add(new Food("Борщ Русский", "85$"));
        dishes.add(new Food("Котлета по Киевски", "125$"));
        dishes.add(new Food("Паста Песто", "275$"));
        dishes.add(new Food("Пельмени жаренные", "155$"));
        dishes.add(new Food("Уха из щуки", "185$"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<Food> adapter = new CatAdapter(this);
        setListAdapter(adapter);
    }

    private static class Food {
        public final String name;
        public final String cost;

        public Food(String name, String cost) {
            this.name = name;
            this.cost = cost;
        }
    }

    private class CatAdapter extends ArrayAdapter<Food> {

        public CatAdapter(Context context) {
            super(context, android.R.layout.simple_list_item_2, dishes);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Food dish = getItem(position);

            if (convertView == null) {
                convertView = LayoutInflater.from(getContext())
                        .inflate(android.R.layout.simple_list_item_2, null);
            }
            ((TextView) convertView.findViewById(android.R.id.text1))
                    .setText(dish.name);
            ((TextView) convertView.findViewById(android.R.id.text2))
                    .setText(dish.cost);
            return convertView;
        }
    }
}
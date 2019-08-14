package com.example.fariz.myintentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MoveWithObjectActivity extends AppCompatActivity {
    public static String EXTRA_PERSON = "extra_person";
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);
        tvObject = findViewById(R.id.tv_object_received);
        Person mperson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + mperson.getName() + "Age : " + mperson.getAge() + "Email : " + mperson.getEmail() + "Location : " + mperson.getCity();
        tvObject.setText(text);
    }
}

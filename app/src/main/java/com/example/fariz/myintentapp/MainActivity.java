package com.example.fariz.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMoveActivity;
    private Button btnMoveWithDataActivity;
    private Button btnMoveWithObjectActivity;
    private Button btnDialPhone;
    private Button btnMoveResult;
    private TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMoveActivity =  findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);
        btnMoveWithDataActivity =  findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(this);
        btnMoveWithObjectActivity =  findViewById(R.id.btn_move_activity_object);
        btnMoveWithObjectActivity.setOnClickListener(this);
        btnDialPhone =  findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(this);
        btnMoveResult =  findViewById(R.id.btn_move_for_result);
        btnMoveResult.setOnClickListener(this);
        tvResult = findViewById(R.id.tv_result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this , MoveActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_move_activity_data:
                Intent moveWithDataIntent = new Intent(MainActivity.this , MoveWithDataActivity.class);
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME,"Fariz");
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE,16);
                startActivity(moveWithDataIntent);
                break;
            case R.id.btn_move_activity_object:
                Person mperson = new Person();
                mperson.setName("Muhammad Fariz Fakhruddin");
                mperson.setAge(16);
                mperson.setEmail("mfakhruddin2237@gmail.com");
                mperson.setCity("Bandung");
                Intent moveWithObjectIntent = new Intent(MainActivity.this , MoveWithObjectActivity.class);
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mperson);
                startActivity(moveWithObjectIntent);
                break;

            case R.id.btn_dial_number:
                String phoneNumber = "082218095004";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_move_for_result:
                Intent moveForResult = new Intent(this , MoveForResultActivity.class);
                startActivityForResult(moveForResult, REQUEST_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode , int resultCode , Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0 );
                tvResult.setText("Hasil : "+selectedValue);
            }
        }
    }
}

package com.yc.avoidclicks;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.yc.controlclick.ControlClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.test).setOnClickListener(this);
    }

    @Override
    @ControlClick()
    public void onClick(View view) {
        Toast.makeText(this, "响应点击事件", Toast.LENGTH_SHORT).show();
    }
}
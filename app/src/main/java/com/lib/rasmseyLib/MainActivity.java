package com.lib.rasmseyLib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rasmsey.library.CornerLabelButton;

public class MainActivity extends AppCompatActivity {

    CornerLabelButton cornerLabelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cornerLabelButton = findViewById(R.id.ssssssss);
        cornerLabelButton.setTv_title("莫斯科没有眼泪");
        cornerLabelButton.setTv_numbeer("99");


    }
}

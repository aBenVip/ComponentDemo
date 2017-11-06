package com.dgcredit.customcomponent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customcomponent_activity_custom);
    }

    public void horizontalClick(View view) {
        startActivity(new Intent(this,HorizontalActivity.class));
    }
}

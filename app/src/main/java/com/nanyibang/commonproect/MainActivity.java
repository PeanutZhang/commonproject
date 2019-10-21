package com.nanyibang.commonproect;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.nanyibang.commonview.XBanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       XBanner banner =  new XBanner(getBaseContext());
       banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
           @Override
           public void onItemClick(XBanner banner, Object model, View view, int position) {

           }
       });
       findViewById(R.id.jump).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(MainActivity.this,SecondeActivity.class));
           }
       });
        findViewById(R.id.jumpTo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CoundownListActivity.class));
            }
        });
    }
}

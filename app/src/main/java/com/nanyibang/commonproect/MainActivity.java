package com.nanyibang.commonproect;

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
    }
}

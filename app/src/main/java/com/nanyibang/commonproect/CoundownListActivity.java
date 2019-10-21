package com.nanyibang.commonproect;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nanyibang.commonview.recyclerviews.CountdownAdapter;

public class CoundownListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coundown_list);
        RecyclerView recyclerView = findViewById(R.id.recycountdown);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CountdownAdapter adapter = new CountdownAdapter(null);
        recyclerView.setAdapter(adapter);
    }
}

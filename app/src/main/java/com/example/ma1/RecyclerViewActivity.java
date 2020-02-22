package com.example.ma1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerView ;

    String s_name [], s_description[];
    int im []= {R.drawable.basketbl,R.drawable.football,
            R.drawable.red,R.drawable.yellow,R.drawable.basketbl,
            R.drawable.red,R.drawable.basketbl,R.drawable.football,
            R.drawable.yello,R.drawable.basketbl,};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = (RecyclerView)findViewById(R.id.Recycler_id) ;

        s_name = getResources().getStringArray(R.array.programing_languages);
        s_description = getResources().getStringArray(R.array.description);

        RecyclerAdaptor myAdaptor = new RecyclerAdaptor(this,s_name,s_description,im);
        recyclerView.setAdapter(myAdaptor);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

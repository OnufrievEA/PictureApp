package com.example.pictureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SocialDataSource sourceData = new SocSourceBuilder()
                .setResources(getResources())
                .build();
        initRecyclerView(sourceData);


    }

    private void initRecyclerView(SocialDataSource sourceData) {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Эта установка служит для повышения производительности системы
        recyclerView.setHasFixedSize(true);

        // Будем работать со встроенным менеджером
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Установим адаптер
        SocnetAdapter adapter = new SocnetAdapter(sourceData);
        recyclerView.setAdapter(adapter);

        // Установим слушателя
        adapter.SetOnItemClickListener(new SocnetAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this, String.format("Позиция - %d", position), Toast.LENGTH_SHORT).show();

            }
        });

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        itemDecoration.setDrawable(getDrawable(R.drawable.separator));
        recyclerView.addItemDecoration(itemDecoration);

    }
}
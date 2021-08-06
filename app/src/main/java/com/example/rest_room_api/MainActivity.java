package com.example.rest_room_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.rest_room_api.adapter.ExampleAdapter;
import com.example.rest_room_api.ui.ExampleViewModel;

public class MainActivity extends AppCompatActivity {

    private ExampleViewModel viewModel;
    private ExampleAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ExampleViewModel.class);

        setupViewPager();

        viewModel.loadCategory();
        viewModel.getLiveData().observe(this, categories -> {
            if (categories != null){
                adapter.addItems(categories);
            }
        });
    }

    private void setupViewPager() {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ExampleAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

//    private void setTheme(int themeId, int prefsMode){
//        AppCompatDelegate.setDefaultNightMode(themeId);
//    }
}
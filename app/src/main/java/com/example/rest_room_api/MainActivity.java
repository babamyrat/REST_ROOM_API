package com.example.rest_room_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.rest_room_api.adapter.CategoryAdapter;
import com.example.rest_room_api.ui.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private CategoryAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);

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
        adapter = new CategoryAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

//    private void setTheme(int themeId, int prefsMode){
//        AppCompatDelegate.setDefaultNightMode(themeId);
//    }
}
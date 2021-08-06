package com.example.rest_room_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.rest_room_api.adapter.CategoryAdapter;
import com.example.rest_room_api.ui.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel viewModel;
    private CategoryAdapter adapter;
    private Button lightButton;
    private Button darkButton;
    private final static int THEME_LIGHT = 0;
    private final static int THEME_DARK = 1;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainViewModel.class);

        /*
        progressBar = findViewById(R.id.progress_bar);
        lightButton = findViewById(R.id.light);
        lightButton.setOnClickListener( view -> {
            setTheme(AppCompatDelegate.MODE_NIGHT_NO, THEME_LIGHT);
        });
        darkButton = findViewById(R.id.dark);
        darkButton.setOnClickListener(view -> {
            setTheme(AppCompatDelegate.MODE_NIGHT_YES, THEME_DARK);
        });
         */

        setupViewPager();

        viewModel.loadCategory();
        viewModel.getLiveData().observe(this, categories -> {
            if (categories != null){
                adapter.addItems(categories);
            }
        });
    }

    private void setupViewPager() {
        ViewPager2 viewPager2 = findViewById(R.id.view_pager_2);
        adapter = new CategoryAdapter(this);
        viewPager2.setAdapter(adapter);

    }

    private void setTheme(int themeId, int prefsMode){
        AppCompatDelegate.setDefaultNightMode(themeId);
    }
}
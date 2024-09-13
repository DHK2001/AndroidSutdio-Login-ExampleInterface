package com.example.login.ui.home;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.example.login.ui.appBarMenuBottom.AppBarClickListener;

public class HomeActivity extends AppCompatActivity {

    TextView textHome;
    ImageView iconHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        init();

        textHome.setTextColor(getResources().getColor(R.color.selected));
        iconHome.setColorFilter(getResources().getColor(R.color.selected));
    }

    private void init(){
        textHome = findViewById(R.id.textHome);
        iconHome = findViewById(R.id.iconHome);

        AppBarClickListener listener = new AppBarClickListener(this, getResources().getString(R.string.home));
        findViewById(R.id.bottom_menu_item_1).setOnClickListener(listener);
        findViewById(R.id.bottom_menu_item_2).setOnClickListener(listener);
        findViewById(R.id.bottom_menu_item_3).setOnClickListener(listener);
    }
}

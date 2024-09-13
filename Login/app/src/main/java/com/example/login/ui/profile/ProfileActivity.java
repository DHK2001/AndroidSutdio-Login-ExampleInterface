package com.example.login.ui.profile;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.example.login.ui.appBarMenuBottom.AppBarClickListener;

public class ProfileActivity extends AppCompatActivity {
    TextView textProfile;
    ImageView iconProfile;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        init();

        textProfile.setTextColor(getResources().getColor(R.color.selected));
        iconProfile.setColorFilter(getResources().getColor(R.color.selected));
    }

    private void init(){
        textProfile = findViewById(R.id.textProfile);
        iconProfile = findViewById(R.id.iconProfile);

        AppBarClickListener listener = new AppBarClickListener(this, getResources().getString(R.string.profile));
        findViewById(R.id.bottom_menu_item_1).setOnClickListener(listener);
        findViewById(R.id.bottom_menu_item_2).setOnClickListener(listener);
        findViewById(R.id.bottom_menu_item_3).setOnClickListener(listener);
    }
}

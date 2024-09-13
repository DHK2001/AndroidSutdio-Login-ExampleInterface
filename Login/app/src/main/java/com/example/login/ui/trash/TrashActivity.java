package com.example.login.ui.trash;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.login.R;
import com.example.login.ui.appBarMenuBottom.AppBarClickListener;

public class TrashActivity extends AppCompatActivity {
    TextView textTrash;
    ImageView iconTrash;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trash_activity);

        init();

        textTrash.setTextColor(getResources().getColor(R.color.selected));
        iconTrash.setColorFilter(getResources().getColor(R.color.selected));
    }

    private void init(){
        textTrash = findViewById(R.id.textTrash);
        iconTrash = findViewById(R.id.iconTrash);

        AppBarClickListener listener = new AppBarClickListener(this, getResources().getString(R.string.trash));
        findViewById(R.id.bottom_menu_item_1).setOnClickListener(listener);
        findViewById(R.id.bottom_menu_item_2).setOnClickListener(listener);
        findViewById(R.id.bottom_menu_item_3).setOnClickListener(listener);
    }
}

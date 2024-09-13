package com.example.login.ui.appBarMenuBottom;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.example.login.R;

public class AppBarClickListener implements View.OnClickListener {
    private Context context;
    private String location;

    public AppBarClickListener(Context context, String location) {
        this.context = context;
        this.location = location;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.bottom_menu_item_1 && !location.equals(context.getResources().getString(R.string.home))) {
            NavigationUtils.navigateToHome(context);
        } else if (view.getId() == R.id.bottom_menu_item_2 && !location.equals(context.getResources().getString(R.string.profile))) {
            NavigationUtils.navigateToProfile(context);
        } else if (view.getId() == R.id.bottom_menu_item_3 && !location.equals(context.getResources().getString(R.string.trash))) {
            NavigationUtils.navigateToTrash(context);
        }
    }

}

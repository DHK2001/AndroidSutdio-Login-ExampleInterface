package com.example.login.ui.appBarMenuBottom;

import android.content.Context;
import android.content.Intent;

import com.example.login.ui.home.HomeActivity;
import com.example.login.ui.profile.ProfileActivity;
import com.example.login.ui.trash.TrashActivity;

public class NavigationUtils {
    public static void navigateToHome(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    public static void navigateToProfile(Context context) {
        Intent intent = new Intent(context, ProfileActivity.class);
        context.startActivity(intent);
    }

    public static void navigateToTrash(Context context) {
        Intent intent = new Intent(context, TrashActivity.class);
        context.startActivity(intent);
    }
}

package com.example.login.ui.components;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.login.R;

public class alertActivity {
    private Context context;
    private View layout;
    private Toast toast;
    TextView text;
    ImageView image;

    public alertActivity(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layout = inflater.inflate(R.layout.alert_activity, null, false);
        toast = new Toast(context);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP | Gravity.START, 0, 0);
        toast.setView(layout);

        text = layout.findViewById(R.id.toast_text);
        image = layout.findViewById(R.id.toast_icon);
    }

    public void showError(String message) {
        TextView text = layout.findViewById(R.id.toast_text);
        ImageView image = layout.findViewById(R.id.toast_icon);
        text.setText(message);
        image.setImageResource(R.drawable.baseline_error_outline_24);
        toast.show();
    }

    public void showSuccess(String message) {
        TextView text = layout.findViewById(R.id.toast_text);
        ImageView image = layout.findViewById(R.id.toast_icon);
        text.setText(message);
        image.setImageResource(R.drawable.baseline_check_circle_outline_24);
        toast.show();
    }
}

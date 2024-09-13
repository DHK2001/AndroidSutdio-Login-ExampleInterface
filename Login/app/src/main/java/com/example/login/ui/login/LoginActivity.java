package com.example.login.ui.login;

import static com.example.login.R.*;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.login.SharedPreferences.DataPreferences;

import com.example.login.ui.components.alertActivity;
import com.example.login.ui.home.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    DataPreferences preferences = new DataPreferences(this);
    alertActivity alert;
    private Button loginButton;
    private EditText usernameText;
    private EditText passwordText;
    private TextView errorEmailLabel;
    private TextView errorPasswordLabel;
    private CheckBox rememberMe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.login_activity);
        alert = new alertActivity(this);
        initData();
    }

    private void onLoginButtonClicked(View view) {
        boolean error = false;
        if(usernameText.getText().toString().isEmpty()){
            usernameText.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            errorEmailLabel.setVisibility(View.VISIBLE);
            error = true;
        }else{
            errorEmailLabel.setVisibility(View.GONE);
            usernameText.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
        }

        if (passwordText.getText().toString().isEmpty()){
            passwordText.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
            errorPasswordLabel.setVisibility(View.VISIBLE);
            error = true;
        }else{
            errorPasswordLabel.setVisibility(View.GONE);
            passwordText.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
        }

        if (!error){
            if (rememberMe.isChecked())
                saveData();

            boolean login = true;
            if(validAccount(usernameText.getText().toString(), passwordText.getText().toString())){
                alert.showSuccess("Login Success");
                Intent intent = new Intent(this, HomeActivity.class);
                startActivity(intent);
            }else{
                alert.showError("Login Failed");
            }

        }
    }

    private boolean validAccount(String username, String password){
        if (username.equals("test") && password.equals("test")){
            return true;
        }else{
            return false;
        }
    }

    private void passwordIcon(){
        Drawable drawableEndShow = ContextCompat.getDrawable(getApplicationContext(), drawable.show);
        Drawable drawableEndHide = ContextCompat.getDrawable(getApplicationContext(), drawable.hide);
        int height = passwordText.getLineHeight();
        drawableEndShow.setBounds(0, 0, height, height);
        drawableEndHide.setBounds(0, 0, height, height);
        passwordText.setCompoundDrawables(null, null, drawableEndShow, null);
        passwordText.setCompoundDrawables(null, null, drawableEndHide, null);
        passwordText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (event.getRawX() >= (passwordText.getRight() - passwordText.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {
                        if (passwordText.getInputType() == (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD)) {
                            passwordText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                            passwordText.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable.hide, 0);
                            passwordText.setCompoundDrawables(null, null, drawableEndHide, null);
                        } else {
                            passwordText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                            passwordText.setCompoundDrawablesWithIntrinsicBounds(0, 0, drawable.show, 0);
                            passwordText.setCompoundDrawables(null, null, drawableEndShow, null);
                        }
                        passwordText.setSelection(passwordText.getText().length());
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void saveData(){
        Log.d("RememberMe", "Save User Data");
        preferences.saveUsername(usernameText.getText().toString());
        preferences.savePassword(passwordText.getText().toString());
        preferences.saveRememberMe(rememberMe.isChecked());
    }
    private void deleteData(){
        rememberMe.setOnCheckedChangeListener((ren, isChecked) -> {
            if (!isChecked){
                Log.d("RememberMe", "Delete User Data");
                preferences.deleteUsername();
                preferences.deletePassword();
                preferences.saveRememberMe(false);
            }
        });
    }

    private void initData(){

        loginButton = findViewById(id.buttonLogin);
        loginButton.setOnClickListener(this::onLoginButtonClicked);

        usernameText = findViewById(id.usernameText);

        passwordText = findViewById(id.passwordText);
        passwordIcon();

        errorEmailLabel = findViewById(id.usernameError_Label);
        errorPasswordLabel = findViewById(id.passwordError_Label);

        rememberMe = findViewById(id.rememberMeCheck);
        deleteData();

        if (preferences.getRememberMe()){
            Log.d("DataLoaded", "Get User Data");
            usernameText.setText(preferences.getUsername());
            passwordText.setText(preferences.getPassword());
            rememberMe.setChecked(true);
        }
    }

}
package com.cs175.cs175_apa;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Activity_Login extends Activity {

    EditText user, pass;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_login);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void loginClick(View v){

//        Editable username = user.getText();
//        Editable password = pass.getText();
//		Toast.makeText(this, username, Toast.LENGTH_SHORT);
//        if(username.toString().equals("asdf"))
//        {
        Intent intent = new Intent(Activity_Login.this,Activity_Main.class);
        startActivity(intent);
//        }else
//        {
//            Toast t = Toast.makeText(this, "Incorrect username/password!", Toast.LENGTH_SHORT);
//            t.show();
//        }
    }

    public void registerClick(View v){
        Intent intent = new Intent(Activity_Login.this,Activity_Register.class);
        startActivity(intent);
    }
}

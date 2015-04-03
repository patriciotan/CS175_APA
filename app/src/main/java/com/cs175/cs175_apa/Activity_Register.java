package com.cs175.cs175_apa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class Activity_Register extends Activity {

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_register);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void cancelClick(View v){
        Intent intent = new Intent(Activity_Register.this,Activity_Login.class);
        startActivity(intent);
    }

    public void submitClick(View v){

        new AlertDialog.Builder(this)
                .setTitle("Confirm")
                .setMessage("Confirm Registration?")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        Toast.makeText(Activity_Register.this, "Successfully registered!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Activity_Register.this,Activity_Login.class);
                        finish();
                        startActivity(intent);
                    }})
                .setNegativeButton(android.R.string.no, null).show();

    }
}

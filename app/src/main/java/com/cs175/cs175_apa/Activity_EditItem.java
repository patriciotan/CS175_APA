package com.cs175.cs175_apa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Sean Patrick T. Tan on 3/23/2015.
 */
public class Activity_EditItem extends Activity{
    ActionBar actionBar;
    private Button date;

    private int year;
    private int month;
    private int day;
    EditText raw;
    EditText total;

    static final int DATE_DIALOG_ID = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getActionBar();
        actionBar.setTitle((Html.fromHtml("<font color=\"#000000\">Edit Item</font>")));
        setContentView(R.layout.activity_edit_item);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setCurrentDateOnView();

        Bundle extras = getIntent().getExtras();
        String color = extras.getString("color");
        String letter = extras.getString("letter");
        String name = extras.getString("name");

        final RelativeLayout colors = (RelativeLayout) findViewById(R.id.subjColor);
        final TextView letters = (TextView) findViewById(R.id.subjLetter);
        final TextView names = (TextView) findViewById(R.id.subjTitle);

        raw = (EditText) findViewById(R.id.rawScore);
        total = (EditText) findViewById(R.id.totalScore);

        colors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        letters.setText(letter);
        names.setText(name);

        date = (Button) findViewById(R.id.dateScore);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID);
//                DialogFragment newFragment = new SelectDateFragment();
//                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_save, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Handle action bar actions click
            case R.id.action_save:
                if(raw.getText().toString().equals("") || total.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Input Raw Score and Total Score!", Toast.LENGTH_LONG).show();
                else {
                    final int rawScore = Integer.valueOf(raw.getText().toString());
                    final int totalScore = Integer.valueOf(total.getText().toString());
                    if (totalScore >= rawScore) {
                        new AlertDialog.Builder(Activity_EditItem.this)
                                .setTitle("Confirm")
                                .setMessage("Are you sure you want to save changes to this item?")
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        Toast.makeText(Activity_EditItem.this, "Successfully saved changes!", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                })
                                .setNegativeButton(android.R.string.no, null).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Raw Score must not exceed Total Score!", Toast.LENGTH_LONG).show();
                    }
                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_save).setVisible(true);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListener,
                        year, month,day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener
            = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            // set selected date into button
            date.setText(new StringBuilder().append(month + 1)
                    .append("-").append(day).append("-").append(year)
                    .append(" "));
        }
    };

    // display current date
    public void setCurrentDateOnView() {

        date = (Button) findViewById(R.id.dateScore);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        // set current date into button
        date.setText(new StringBuilder()
                // Month is 0 based, just add 1
                .append(month + 1).append("-").append(day).append("-")
                .append(year).append(" "));
    }
}

package com.cs175.cs175_apa;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Frag_GradingSystem extends Fragment {
    View rootView;
    ActionBar actionBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_grading_system, container, false);

        final String color = getArguments().getString("color");
        final String letter = getArguments().getString("letter");
        final String title = getArguments().getString("title");

        actionBar = getActivity().getActionBar();
        actionBar.setTitle((Html.fromHtml("<font color=\"#000000\">" + title + " Grading System</font>")));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));
        getActivity().invalidateOptionsMenu();

        final RelativeLayout colors = (RelativeLayout) rootView.findViewById(R.id.subjColor);
        final RelativeLayout lcolors = (RelativeLayout) rootView.findViewById(R.id.lineColor);
        final TextView letters = (TextView) rootView.findViewById(R.id.subjLetter);
        TextView titles = (TextView) rootView.findViewById(R.id.subjTitle);

        lcolors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        colors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        letters.setText(letter);
        titles.setText(title);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_update, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Handle action bar actions click
            case R.id.action_update:
                Frag_UpdateGS updategs = new Frag_UpdateGS();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, updategs);
                ft.addToBackStack(null);
                ft.commit();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_update).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }
}
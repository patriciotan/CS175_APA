package com.cs175.cs175_apa;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
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

public class Frag_ItemView extends Fragment{
    View rootView;
    ActionBar actionBar;

    String color, letter, name;
    RelativeLayout colors, lcolors;
    TextView letters, names;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_item_view,container,false);

        color = getArguments().getString("color");
        letter = getArguments().getString("letter");
        name = getArguments().getString("name");

        actionBar = getActivity().getActionBar();
        actionBar.setTitle((Html.fromHtml("<font color=\"#000000\">" + name + "</font>")));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));
        getActivity().invalidateOptionsMenu();

        colors = (RelativeLayout) rootView.findViewById(R.id.color);
        lcolors = (RelativeLayout) rootView.findViewById(R.id.lineColor);
        letters = (TextView) rootView.findViewById(R.id.letter);
        names = (TextView) rootView.findViewById(R.id.name);

        lcolors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        colors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        letters.setText(letter);
        names.setText(name);

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_edit, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Handle action bar actions click
            case R.id.action_edit:
                Bundle b = new Bundle();
                b.putString("color", color);
                b.putString("letter",letter);
                b.putString("name", name);

                Intent i = new Intent(getActivity(),Activity_EditItem.class);
                i.putExtras(b);
                startActivity(i);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_edit).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }

}

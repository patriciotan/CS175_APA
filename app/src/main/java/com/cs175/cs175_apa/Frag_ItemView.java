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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Frag_ItemView extends Fragment{
    View rootView;
    ActionBar actionBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_item_view,container,false);

        final String color = getArguments().getString("color");
        final String letter = getArguments().getString("letter");
        final String name = getArguments().getString("name");

        actionBar = getActivity().getActionBar();
        actionBar.setTitle((Html.fromHtml("<font color=\"#000000\">" + name + "</font>")));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));

        final RelativeLayout colors = (RelativeLayout) rootView.findViewById(R.id.color);
        final TextView letters = (TextView) rootView.findViewById(R.id.letter);
        final TextView names = (TextView) rootView.findViewById(R.id.name);

        colors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        letters.setText(letter);
        names.setText(name);

        Button edit = (Button) rootView.findViewById(R.id.edit);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("color", color);
                b.putString("letter",letter);
                b.putString("name", name);

                Intent i = new Intent(getActivity(),Activity_EditItem.class);
                i.putExtras(b);
                startActivity(i);
            }
        });

        return rootView;
    };


}

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Frag_GradingSystem extends Fragment {
    View rootView;
    ActionBar actionBar;

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

        final RelativeLayout colors = (RelativeLayout) rootView.findViewById(R.id.subjColor);
        final TextView letters = (TextView) rootView.findViewById(R.id.subjLetter);
        TextView titles = (TextView) rootView.findViewById(R.id.subjTitle);

        colors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        letters.setText(letter);
        titles.setText(title);

        Button update = (Button) rootView.findViewById(R.id.upd);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getActivity(),"Update Clicked!",Toast.LENGTH_SHORT).show();
                Frag_UpdateGS item = new Frag_UpdateGS();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, item);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return rootView;
    }
}
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

public class Frag_SubjectView extends Fragment{
    View rootView;
    ActionBar actionBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_subject_view,container,false);

        final String color = getArguments().getString("color");
        final String letter = getArguments().getString("letter");
        final String title = getArguments().getString("title");
        final String desc = getArguments().getString("desc");

        actionBar = getActivity().getActionBar();
        actionBar.setTitle((Html.fromHtml("<font color=\"#000000\">" + title + "</font>")));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));

        final RelativeLayout colors = (RelativeLayout) rootView.findViewById(R.id.subjColor);
        final RelativeLayout lcolors = (RelativeLayout) rootView.findViewById(R.id.lineColor);
        final TextView letters = (TextView) rootView.findViewById(R.id.subjLetter);
        final TextView titles = (TextView) rootView.findViewById(R.id.subjTitle);
        final TextView descs = (TextView) rootView.findViewById(R.id.subjDesc);

        colors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        lcolors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        letters.setText(letter);
        titles.setText(title);
        descs.setText(desc);

        Button gradingSystem = (Button) rootView.findViewById(R.id.Grading);
        Button items = (Button) rootView.findViewById(R.id.Items);

        gradingSystem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("color",color);
                b.putString("letter",letter);
                b.putString("title", title);

                Frag_GradingSystem grade = new Frag_GradingSystem();
                grade.setArguments(b);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, grade);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        items.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString("color",color);
                b.putString("letter",letter);
                b.putString("title", title);

                Frag_SubjectItems item = new Frag_SubjectItems();
                item.setArguments(b);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, item);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return rootView;
    };


}

package com.cs175.cs175_apa;

import android.app.ActionBar;
import android.app.Fragment;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Frag_AnnouncementItem extends Fragment{
    View rootView;
    ActionBar actionBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_announcement_view,container,false);

        final String color = getArguments().getString("color");
        final String title = getArguments().getString("title");
        final String date = getArguments().getString("date");
        final String desc = getArguments().getString("desc");

        actionBar = getActivity().getActionBar();
        actionBar.setTitle(title);
        actionBar.setTitle((Html.fromHtml("<font color=\"#000000\">" + title + "</font>")));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));

        final RelativeLayout colors = (RelativeLayout) rootView.findViewById(R.id.subjColor);
        final TextView titles = (TextView) rootView.findViewById(R.id.subjTitle);
        final TextView dates = (TextView) rootView.findViewById(R.id.subjDate);
        final TextView descs = (TextView) rootView.findViewById(R.id.subjDesc);

        colors.getBackground().setColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
        titles.setText(title);
        dates.setText(date);
        descs.setText(desc);

        return rootView;
    };


}

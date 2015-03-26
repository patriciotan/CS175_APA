package com.cs175.cs175_apa;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Sean Patrick T. Tan on 3/17/2015.
 */
public class Frag_About extends Fragment {
    View rootView;
    ActionBar actionBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about, container, false);
        actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));

        TextView irvin = (TextView) rootView.findViewById(R.id.irvinpic);
        TextView sean = (TextView) rootView.findViewById(R.id.seanpic);
        ImageView irvPic = (ImageView) rootView.findViewById(R.id.irvin);
        ImageView seanPic = (ImageView) rootView.findViewById(R.id.sean);

        irvin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] mailList = {"iabellanosa@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, mailList);
                emailIntent.setType("plain/text");


                startActivity(emailIntent);
            }
        });

        sean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] mailList = {"iabellanosa@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, mailList);
                emailIntent.setType("plain/text");


                startActivity(emailIntent);
            }
        });

        irvPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] mailList = {"iabellanosa@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, mailList);
                emailIntent.setType("plain/text");


                startActivity(emailIntent);
            }
        });

        seanPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] mailList = {"iabellanosa@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.putExtra(Intent.EXTRA_EMAIL, mailList);
                emailIntent.setType("plain/text");


                startActivity(emailIntent);
            }
        });

        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}

package com.cs175.cs175_apa;


import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Frag_NewSubject extends Fragment{
    View rootView;
    ActionBar actionBar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_new_subject, container, false);
        actionBar = getActivity().getActionBar();
        actionBar.setTitle((Html.fromHtml("<font color=\"#000000\">New Subject</font>")));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));

        Button save = (Button) rootView.findViewById(R.id.saveSubj);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(getActivity())
                        .setTitle("Confirm")
                        .setMessage("Are you sure you want to add this subject?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(getActivity(), "Successfully added subject!", Toast.LENGTH_SHORT).show();
                                getFragmentManager().popBackStackImmediate();
                            }})
                        .setNegativeButton(android.R.string.no, null).show();
                //FragmentManager fm = getFragmentManager();
                //FragmentTransaction ft = fm.beginTransaction();
                //ft.replace(R.id.container, new Frag_Subject());
                //ft.addToBackStack(null);
                //ft.commit();
            }
        });

        return rootView;
    }

}



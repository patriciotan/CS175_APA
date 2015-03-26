package com.cs175.cs175_apa;


import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class Frag_SubjectItems extends Fragment{
    ActionBar actionBar;
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_subject_items, container, false);
        actionBar = getActivity().getActionBar();
        actionBar.setTitle((Html.fromHtml("<font color=\"#000000\">Items</font>")));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));

        Resources res = getResources();
        final String[] colors = {
                "#9933FF",
                "#FF9933",
                "#0066CC",
                "#FF3030",
                "#6699FF",
                "#339933",
                "#9933FF",
                "#FF9933",
                "#0066CC",
                "#FF3030",
                "#6699FF",
                "#339933"
        };
        final String[] letters = {
                "Q",
                "S",
                "A",
                "Q",
                "S",
                "A",
                "Q",
                "S",
                "A",
                "Q",
                "S",
                "A"
        };
        final String[] names = {
                "Quiz 1",
                "Seatwork 1",
                "Assignment 1",
                "Quiz 2",
                "Seatwork 2",
                "Assignment 2",
                "Quiz 1",
                "Seatwork 3",
                "Assignment 3",
                "Quiz 4",
                "Seatwork 4",
                "Assignment 4"
        };
        ListView listView = (ListView) rootview.findViewById(R.id.itemList);

        ItemAdapter adapter = new ItemAdapter(getActivity(),colors,letters,names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                b.putString("color", colors[position].toString());
                b.putString("letter", letters[position].toString());
                b.putString("name", names[position].toString());

                Frag_ItemView itemView = new Frag_ItemView();
                itemView.setArguments(b);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, itemView);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        Button addItem = (Button) rootview.findViewById(R.id.addItem);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(),Activity_NewItem.class);
                startActivity(i);
            }
        });

        return rootview;
    }
}

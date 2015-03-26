package com.cs175.cs175_apa;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class Frag_Subject extends Fragment {
    ActionBar actionBar;
    View rootview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_subjects, container, false);
        actionBar = getActivity().getActionBar();
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
        final String[] letters = getResources().getStringArray(R.array.letter);
        final String[] names = res.getStringArray(R.array.name);
        final String[] descs = res.getStringArray(R.array.desc);
        ListView listView = (ListView) rootview.findViewById(R.id.subjList);

        SubjectAdapter adapter = new SubjectAdapter(getActivity(),colors,letters,names,descs);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                b.putString("color",colors[position].toString());
                b.putString("letter",letters[position].toString());
                b.putString("title",names[position].toString());
                b.putString("desc",descs[position].toString());

                Frag_SubjectView subjView = new Frag_SubjectView();
                subjView.setArguments(b);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, subjView);
                ft.addToBackStack(null);
                ft.commit();
            }
        });

        return rootview;
    }
}

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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

public class Frag_Subject extends Fragment {
    ActionBar actionBar;
    View rootview;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_subjects, container, false);
        actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));
        getActivity().invalidateOptionsMenu();

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
        GridView gridView = (GridView) rootview.findViewById(R.id.gridView1);

        SubjectAdapter adapter = new SubjectAdapter(getActivity(),colors,letters,names,descs);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        getActivity().getMenuInflater().inflate(R.menu.menu_add, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Handle action bar actions click
            case R.id.action_add:
                Frag_NewSubject newsubj = new Frag_NewSubject();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, newsubj);
                ft.addToBackStack(null);
                ft.commit();

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_add).setVisible(true);
        super.onPrepareOptionsMenu(menu);
    }
}

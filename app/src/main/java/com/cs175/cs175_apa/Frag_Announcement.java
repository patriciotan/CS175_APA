package com.cs175.cs175_apa;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * Created by Sean Patrick T. Tan on 3/17/2015.
 */
public class Frag_Announcement extends Fragment {
    View rootView;
    ActionBar actionBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_announcement, container, false);
        actionBar = getActivity().getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.rgb(190, 235, 193)));

        ListView list = (ListView)rootView.findViewById(R.id.announcement_list);
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
                "A",
                "D",
                "D",
                "F",
                "I",
                "C",
                "C",
                "C",
                "C",
                "P",
                "P",
                "C"
        };
        final String[] titles = getResources().getStringArray(R.array.title);
        final String[] desc = getResources().getStringArray(R.array.announceDesc);
        final String date = getResources().getString(R.string.date);
        AnnouncementAdapter adapter = new AnnouncementAdapter(getActivity(),colors,letters,titles,desc,date);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b = new Bundle();
                b.putString("color",colors[position].toString());
                b.putString("letter",letters[position].toString());
                b.putString("title",titles[position].toString());
                b.putString("desc",desc[position].toString());
                b.putString("date",date.toString());

                Frag_AnnouncementItem subjView = new Frag_AnnouncementItem();
                subjView.setArguments(b);
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frame_container, subjView);
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        return rootView;
    }
}

package com.cs175.cs175_apa;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AnnouncementAdapter  extends ArrayAdapter<String> {
    Context context;
    String[] colors;
    String[] titles;
    String[] descs;
    String dates;
    public AnnouncementAdapter(Context context,String[] colors,String[] titles,String[] descs,String dates){
        super(context,R.layout.announcement_layout,R.id.announcementTitle,titles);
        this.context=context;
        this.colors=colors;
        this.titles=titles;
        this.descs=descs;
        this.dates=dates;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from announcement_layout.xml
            gridView = inflater.inflate(R.layout.announcement_layout, null);

            // set color into layout
            LinearLayout color = (LinearLayout) gridView
                    .findViewById(R.id.announcementColor);
            color.getBackground()
                    .setColorFilter(Color.parseColor(colors[position]), PorterDuff.Mode.SRC_ATOP);

            // set title into textview
            TextView title = (TextView) gridView
                    .findViewById(R.id.announcementTitle);
            title.setText(titles[position]);

            // set date into textview
            TextView date = (TextView) gridView
                    .findViewById(R.id.announcementDate);
            date.setText(dates);

            // set desc into textview
            TextView desc = (TextView) gridView
                    .findViewById(R.id.announcementDesc);
            desc.setText(descs[position]);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

}

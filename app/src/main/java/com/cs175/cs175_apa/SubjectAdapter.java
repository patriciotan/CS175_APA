package com.cs175.cs175_apa;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class SubjectAdapter extends BaseAdapter{
    Context context;
    String[] colors;
    String [] letters;
    String [] titles;
    String [] descs;
    public SubjectAdapter(Context con, String[] colors,String[] letters,String[] name,String[] descs){
//        super(con,R.layout.subject_layout,R.id.name,name);
        this.context = con;
        this.colors=colors;
        this.letters=letters;
        this.titles = name;
        this.descs = descs;
    }

    public class MyViewHolder{
        RelativeLayout color;
        TextView letter;
        TextView title;
//        TextView desc;
        public MyViewHolder(View v){
            color = (RelativeLayout) v.findViewById(R.id.color);
            letter = (TextView) v.findViewById(R.id.letter);
            title = (TextView) v.findViewById(R.id.name);
//            desc = (TextView) v.findViewById(R.id.desc);
        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from subject_layout.xml
            gridView = inflater.inflate(R.layout.subject_layout, null);

            // set color into layout
            RelativeLayout color = (RelativeLayout) gridView
                    .findViewById(R.id.color);
            color.getBackground()
                    .setColorFilter(Color.parseColor(colors[position]), PorterDuff.Mode.SRC_ATOP);

            // set letter into textview
            TextView date = (TextView) gridView
                    .findViewById(R.id.letter);
            date.setText(letters[position]);

            // set title into textview
            TextView title = (TextView) gridView
                    .findViewById(R.id.title);
            title.setText(titles[position]);

//            // set desc into textview
//            TextView detail = (TextView) gridView
//                    .findViewById(R.id.desc);
//            detail.setText(descs[position]);

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}

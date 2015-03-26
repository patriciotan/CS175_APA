package com.cs175.cs175_apa;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AnnouncementAdapter  extends ArrayAdapter<String> {
    Context context;
    String[] colors;
    String[] letters;
    String[] titles;
    String[] descs;
    String date;
    public AnnouncementAdapter(Context context,String[] colors,String[] letters,String[] titles,String[] descs,String date){
        super(context,R.layout.announcement_layout,R.id.announcementTitle,titles);
        this.context=context;
        this.colors=colors;
        this.letters=letters;
        this.titles=titles;
        this.descs=descs;
        this.date=date;
    }

    public class MyViewHolder {
        RelativeLayout color;
        TextView letter;
        TextView title;
        TextView desc;
        TextView date;

        public MyViewHolder(View v) {
            color = (RelativeLayout) v.findViewById(R.id.announcementColor);
            letter = (TextView) v.findViewById(R.id.announcementLetter);
            title = (TextView) v.findViewById(R.id.announcementTitle);
            desc = (TextView) v.findViewById(R.id.announcementDesc);
            date = (TextView) v.findViewById(R.id.announcementDate);
        }
    }

        @Override
        public View getView(int position, View convertView , ViewGroup parent){
            View row = convertView;
            MyViewHolder hold = null;
            if(row==null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(R.layout.announcement_layout, parent, false);
                hold = new MyViewHolder(row);
                row.setTag(hold);
            }
            else{
                hold = (MyViewHolder) row.getTag();
            }

            hold.color.getBackground().setColorFilter(Color.parseColor(colors[position]), PorterDuff.Mode.DARKEN);
            hold.letter.setText(letters[position]);
            hold.title.setText(titles[position]);
            hold.desc.setText(descs[position]);
            hold.date.setText(date);

            return row;
        }

}

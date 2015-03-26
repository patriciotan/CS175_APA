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


public class ItemAdapter extends ArrayAdapter<String>{
    Context context;
    String[] colors;
    String [] letters;
    String [] titles;
    public ItemAdapter(Context con, String[] colors,String[] letters,String[] name){
        super(con,R.layout.subject_layout,R.id.name,name);
        this.context = con;
        this.colors=colors;
        this.letters=letters;
        this.titles = name;
    }

    public class MyViewHolder{
        RelativeLayout color;
        TextView letter;
        TextView title;
        public MyViewHolder(View v){
            color = (RelativeLayout) v.findViewById(R.id.color);
            letter = (TextView) v.findViewById(R.id.letter);
            title = (TextView) v.findViewById(R.id.name);
        }
    }

    @Override
    public View getView(int position, View convertView , ViewGroup parent){
        View row = convertView;
        MyViewHolder hold = null;
        if(row==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_layout, parent, false);
            hold = new MyViewHolder(row);
            row.setTag(hold);
        }
        else{
            hold = (MyViewHolder) row.getTag();
        }

        hold.color.getBackground().setColorFilter(Color.parseColor(colors[position]), PorterDuff.Mode.SRC_ATOP);
        hold.letter.setText(letters[position]);
        hold.title.setText(titles[position]);

        return row;
    }
}

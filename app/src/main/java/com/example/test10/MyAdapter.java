package com.example.test10;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Data> data;

    public MyAdapter(Context context, ArrayList<Data> data, int layout) {
        this.context = context;
        this.data = data;
        this.layout = layout;
    }

    int layout;

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, parent, false);
        }
        final Data mData=data.get(position);
        TextView name=convertView.findViewById(R.id.item_name);
        name.setText(mData.getName());
        ImageView iv1=convertView.findViewById(R.id.item_iv);

        if(mData.getIfPic().equals("yes")){
            Log.e("yes","yes");
            iv1.setImageResource(R.drawable.hong);
        }
        else if(mData.getIfPic().equals("no")){
            Log.e("no","no");
            iv1.setImageResource(R.drawable.ic_person);
        }
        TextView day=convertView.findViewById(R.id.item_p);
        day.setText(mData.getDay());

        ImageView iv=convertView.findViewById(R.id.item_callBtn);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:"+mData.getNumber()));
                context.startActivity(intent);
            }
        });


        return convertView;
    }
}

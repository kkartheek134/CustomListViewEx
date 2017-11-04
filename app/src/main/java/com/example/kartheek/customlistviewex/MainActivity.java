package com.example.kartheek.customlistviewex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    TextView textView,textView1;
    ImageView imageView;
    int images[]={R.drawable.andro,R.drawable.ches,R.drawable.gear,R.drawable.shuffle,R.drawable.square};
    String names[]={"android","Chess","Gear","Shuffle","Squeare"};
    String explain[]={"android figure","Chess figure","Gear figure","Shuffle figure","Squeare figure"};
    int colors[]={Color.RED,Color.BLUE,Color.GREEN,Color.GRAY,Color.CYAN,Color.MAGENTA};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=(ListView)findViewById(R.id.list);

        CustomAdapter customAdapter=new CustomAdapter();
        listView.setAdapter(customAdapter);
        for(int i=0;i<images.length;i++)
        {
            listView.setBackgroundColor(colors[i]);
        }
    }
    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView= getLayoutInflater().inflate(R.layout.customlistview,null);
            imageView=(ImageView)convertView.findViewById(R.id.imageView);
            textView=(TextView)convertView.findViewById(R.id.textView);
            textView1=(TextView)convertView.findViewById(R.id.textView2);
            imageView.setImageResource(images[position]);
            textView.setText(names[position]);
            textView1.setText(explain[position]);

            return convertView;
        }
    }
}

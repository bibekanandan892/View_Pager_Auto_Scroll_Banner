package com.isu.viewpaget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class CustomAdapter extends PagerAdapter {

    private Activity activity;
    private Integer[] imagesArray;
    private String[] namesArray;

    public CustomAdapter(Activity activity,Integer[] imagesArray,String[] namesArray){

        this.activity = activity;
        this.imagesArray = imagesArray;
        this.namesArray = namesArray;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = ((Activity)activity).getLayoutInflater();

        View viewItem = inflater.inflate(R.layout.test_item, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) ImageView imageView = (ImageView) viewItem.findViewById(R.id.imageView);
        imageView.setImageResource(imagesArray[position]);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textView1 = (TextView) viewItem.findViewById(R.id.textview);
        textView1.setText(namesArray[position]);
        ((ViewPager)container).addView(viewItem);

        return viewItem;
    }

    @Override
    public int getCount() {
        return imagesArray.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View)object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ((ViewPager) container).removeView((View) object);
    }
}
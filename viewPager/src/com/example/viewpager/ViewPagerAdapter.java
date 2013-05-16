package com.example.viewpager;

import java.util.List;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

public class ViewPagerAdapter extends PagerAdapter{  
    
    private List<View> views;  
    Context context;  
    int mCount;  
    public ViewPagerAdapter(Context context,List<View> views){  
        this.views=views;  
        this.context=context;  
        mCount = views.size() +1;  
    }  
    @Override  
    public void destroyItem(View collection, int position, Object arg2) {  
         if (position >= views.size()-1) {  
                int newPosition = position%views.size();  
                position = newPosition;  
            ((ViewPager) collection).removeView(views.get(position));  
         }  
    }  
  
    @Override  
    public void finishUpdate(View arg0) {  
          
    }  
  
    @Override  
    public int getCount() {  
        return mCount;  
    }  
  
    @Override  
    public Object instantiateItem(View collection, int position) {  
          
         if (position >= views.size()-1) {  
                int newPosition = position%views.size();  
                  
                position = newPosition;  
                mCount++;  
            }  
  
        try {  
            ((ViewPager) collection).addView(views.get(position),0);  
        } catch (Exception e) {  
        }  
        return views.get(position);  
    }  
  
    @Override  
    public boolean isViewFromObject(View view, Object object) {  
        return view==(object);  
    }  
  
    @Override  
    public void restoreState(Parcelable arg0, ClassLoader arg1) {  
          
    }  
  
    @Override  
    public Parcelable saveState() {  
        return null;  
    }  
  
    @Override  
    public void startUpdate(View arg0) {  
          
    }  
      
   }  
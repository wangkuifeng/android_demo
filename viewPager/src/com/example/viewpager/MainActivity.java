package com.example.viewpager;

import java.util.ArrayList;  
import java.util.List;  
import android.os.Bundle;  
import android.app.Activity;  
import android.app.ActivityGroup;
import android.content.Context;  
import android.content.Intent;  
import android.support.v4.view.PagerAdapter;  
import android.support.v4.view.PagerTabStrip;  
import android.support.v4.view.PagerTitleStrip;  
import android.support.v4.view.ViewPager;  
import android.util.AttributeSet;  
import android.view.LayoutInflater;  
import android.view.Menu;  
import android.view.View;  
import android.view.View.OnClickListener;  
import android.view.ViewGroup;  
import android.widget.Button;  
  
public class MainActivity extends ActivityGroup {  
  
    private View view1, view2, view3;//需要滑动的页卡  
    private ViewPager viewPager;//viewpager  
    private PagerTitleStrip pagerTitleStrip;//viewpager的标题  
    private PagerTabStrip pagerTabStrip;//一个viewpager的指示器，效果就是一个横的粗的下划线  
    private List<View> viewList;//把需要滑动的页卡添加到这个list中  
    private List<String> titleList;//viewpager的标题  
    private Button weibo_button;//button对象，一会用来进入第二个Viewpager的示例  
   private Intent intent;  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  
        initView();  
    }  
  
    private void initView() { 
        viewPager = (ViewPager) findViewById(R.id.viewpager); 
        //pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pagertitle); 
        pagerTabStrip=(PagerTabStrip) findViewById(R.id.pagertab); 
        pagerTabStrip.setTabIndicatorColor(getResources().getColor(R.color.black));  
        pagerTabStrip.setDrawFullUnderline(false); 
        pagerTabStrip.setBackgroundColor(getResources().getColor(R.color.bg_gray)); 
        pagerTabStrip.setTextSpacing(50); 
      
          
       /* view1 = findViewById(R.layout.layout1);  
        view2 = findViewById(R.layout.layout2);  
        view3 = findViewById(R.layout.layout3);  */
  
       /* LayoutInflater lf = getLayoutInflater().from(this);  
        view1 = lf.inflate(R.layout.layout1, null);  
        view2 = lf.inflate(R.layout.layout2, null);  
        view3 = lf.inflate(R.layout.layout3, null);  */
        view1 = getLocalActivityManager().startActivity("activity01",
                new Intent(this, LayoutActivity1.class)).getDecorView();
        view2 = getLocalActivityManager().startActivity("activity02",
                new Intent(this, LayoutActivity2.class)).getDecorView();
        view3 = getLocalActivityManager().startActivity("activity03",
                new Intent(this, LayoutActivity3.class)).getDecorView();
        
        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中  
        viewList.add(view1);  
        viewList.add(view2);  
        viewList.add(view3);  
  
        titleList = new ArrayList<String>();// 每个页面的Title数据  
        titleList.add("wp");  
        titleList.add("jy");  
        titleList.add("jh");  
  
        PagerAdapter pagerAdapter = new PagerAdapter() {  
  
            @Override  
            public boolean isViewFromObject(View arg0, Object arg1) {  
  
                return arg0 == arg1;  
            }  
  
            @Override  
            public int getCount() {  
  
                return viewList.size();  
            }  
  
            @Override  
            public void destroyItem(ViewGroup container, int position,  
                    Object object) {  
                container.removeView(viewList.get(position));  
  
            }  
  
            @Override  
            public int getItemPosition(Object object) {  
  
                return super.getItemPosition(object);  
            }  
  
            @Override  
            public CharSequence getPageTitle(int position) {  
  
                return titleList.get(position);//直接用适配器来完成标题的显示，所以从上面可以看到，我们没有使用PagerTitleStrip。当然你可以使用。  
  
            }  
  
          /*  @Override  
            public Object instantiateItem(ViewGroup container, int position) {  
                container.addView(viewList.get(position));  
                weibo_button=(Button) findViewById(R.id.button1);//这个需要注意，我们是在重写adapter里面实例化button组件的，如果你在onCreate()方法里这样做会报错的。  
                weibo_button.setOnClickListener(new OnClickListener() {  
                      
                    public void onClick(View v) {  
                        intent=new Intent(MainActivity.this,WeiBoActivity.class);  
                        startActivity(intent);  
                    }  
                });  
                return viewList.get(position);  
            }  */
            /***
             * 获取每一个item， 类于listview中的getview
             */
            @Override
            public Object instantiateItem(View arg0, int arg1) {
                    ((ViewPager) arg0).addView(viewList.get(arg1));
                    return viewList.get(arg1);
            }
  
        };  
        viewPager.setAdapter(pagerAdapter);  
        
        viewPager.setCurrentItem(2);
    }  
  
    @Override  
    public boolean onCreateOptionsMenu(Menu menu) {  
        getMenuInflater().inflate(R.menu.main, menu);  
        return true;  
    }  
  
}  
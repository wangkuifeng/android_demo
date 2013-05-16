package com.example.viewpager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LayoutActivity1 extends Activity {

	private Button weibo_button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout1);
		
		 weibo_button=(Button) findViewById(R.id.button1);//这个需要注意，我们是在重写adapter里面实例化button组件的，如果你在onCreate()方法里这样做会报错的。  
         weibo_button.setOnClickListener(new OnClickListener() {  
               
             public void onClick(View v) {  
            	 Intent   intent=new Intent(LayoutActivity1.this,WeiBoActivity.class);  
                 startActivity(intent);  
             }  
         });  
	}
}

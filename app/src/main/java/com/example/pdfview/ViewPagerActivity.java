package com.example.pdfview;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pdfview.adapter.ViewPageAdapter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.viewpager2.widget.ViewPager2;
import me.relex.circleindicator.CircleIndicator;
import me.relex.circleindicator.CircleIndicator3;

public class ViewPagerActivity extends AppCompatActivity {
   private ViewPager2 viewPager2;
   private  ViewPageAdapter viewPageAdapter;
   List<String> list = new ArrayList<>();
   private Timer timer;
   private int page = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager2);

        viewPager2 = findViewById(R.id.view_pager2);


      //  List<String> list  = new ArrayList<>();

        list.add("First Screen");
        list.add("Second Screen");
        list.add("Third Screen");
        list.add("Fourth Screen");
      //  list.add("Fifth Screen");


        // only one direction support at a time in viewpager2
        //viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        viewPageAdapter = new ViewPageAdapter(this,list);
        viewPager2.setAdapter(viewPageAdapter);

      //  viewPager2.setAdapter(new ViewPageAdapter(this,list,viewPager2));

        CircleIndicator3 indicator = (CircleIndicator3) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager2);
        indicator.setBackgroundColor(getResources().getColor(R.color.black));


        pagerSwich(4);

    }

    private void pagerSwich(int second) {


        timer = new Timer();
        timer.scheduleAtFixedRate(new RemindTask(),0,second*1000);

    }

   private class RemindTask extends TimerTask
    {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //if (page>)

                    if (page> list.size()){
                        page = 0;
                        viewPager2.setCurrentItem(page,true);
                    }else {
                        viewPager2.setCurrentItem(page++,true);
                    }
                }
            });
        }
    }

}

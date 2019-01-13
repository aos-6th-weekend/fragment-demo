package com.example.rathana.fragmentdemo;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rathana.fragmentdemo.adaper.ViewPagerAdapter;
import com.example.rathana.fragmentdemo.fragment.FavouriteFragment;
import com.example.rathana.fragmentdemo.fragment.Home2Fragment;
import com.example.rathana.fragmentdemo.fragment.Search2Fragment;

import java.util.ArrayList;
import java.util.List;

public class TabDemoActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    List<Fragment> fragments=new ArrayList<>();
    String [] tabTitles={"Home","Favourite","Search"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_demo);

        tabLayout=findViewById(R.id.tabLayout);
        viewPager=findViewById(R.id.viewPager);


        //create view pager adapter

        fragments.add(new Home2Fragment());
        fragments.add(new FavouriteFragment());
        fragments.add(new Search2Fragment());
        viewPagerAdapter=new ViewPagerAdapter(
                getSupportFragmentManager(),
                fragments,
                tabTitles
        );
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);


        //set Table icon
        for(int i=0 ; i < tabLayout.getTabCount();i++){
            TabLayout.Tab tab =tabLayout.getTabAt(i);
            if(i==0)
                tab.setIcon(R.drawable.ic_search_black_24dp);
            else if(i==1)
                tab.setIcon(R.drawable.ic_search_black_24dp);
            else
                tab.setIcon(R.drawable.ic_search_black_24dp);

        }

    }
}

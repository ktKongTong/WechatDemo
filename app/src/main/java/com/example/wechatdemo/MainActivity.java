package com.example.wechatdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.wechatdemo.adapter.MyFragmentPagerAdapter;
import com.example.wechatdemo.fragment.ConnFragment;
import com.example.wechatdemo.fragment.FindFragment;
import com.example.wechatdemo.fragment.HomeFragment;
import com.example.wechatdemo.fragment.MeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private BottomNavigationView bottomNavigationView;
//    public List<Conn> connList=new ArrayList<>();
    private Fragment[] fragments={
        new HomeFragment(),
        new ConnFragment(),
        new FindFragment(),
        new MeFragment()
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(),fragments);
        viewPager = (ViewPager) findViewById(R.id.tab_pager);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(myFragmentPagerAdapter);
        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        };
        BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_navigation_home:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.bottom_navigation_conn:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.bottom_navigation_find:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.bottom_navigation_me:
                    viewPager.setCurrentItem(3);
                    break;
                default:
                    break;
            }
            return false;
            }
        };
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(onPageChangeListener);
    }








}
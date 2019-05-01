package com.example.dell.endterm;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);


        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.AddFragment(new Fragment_profile(), "Profile");
        adapter.AddFragment(new Tab(), "Donner List");
        adapter.AddFragment(new Fragment_aboutus(), "About us");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
// tabLayout.getTabAt(0).setIcon(R.drawable.ic_person_black_24dp);

        //   String Name = getIntent().getStringExtra("name");
        //   String Email = getIntent().getStringExtra("email");
        //   String Mbno = getIntent().getStringExtra("Mobno");
        //    String Blood = getIntent().getStringExtra("Blood");

        //   t1.setText(Name);
        //   t2.setText(Email);
        //   t3.setText(Mbno);
        //  t4.setText(Blood);
    }
}

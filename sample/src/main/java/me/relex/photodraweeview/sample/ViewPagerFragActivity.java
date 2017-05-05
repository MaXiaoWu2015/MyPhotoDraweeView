package me.relex.photodraweeview.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewPagerFragActivity extends AppCompatActivity {
    private MultiTouchViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_frag);
        mViewPager= (MultiTouchViewPager) findViewById(R.id.vp_frags);
        mViewPager.setAdapter(new ViewPagerAdpater(getSupportFragmentManager()));
    }


    class ViewPagerAdpater extends FragmentPagerAdapter {
        ArrayList<ForViewpagerFragment> frags=new ArrayList<>();
        public ViewPagerAdpater(FragmentManager fm) {
            super(fm);
            frags.add(ForViewpagerFragment.newInstance());
            frags.add(ForViewpagerFragment.newInstance());
            frags.add(ForViewpagerFragment.newInstance());
            frags.add(ForViewpagerFragment.newInstance());
            frags.add(ForViewpagerFragment.newInstance());
        }

        @Override
        public Fragment getItem(int position) {
            return frags.get(position);
        }

        @Override
        public int getCount() {
            return frags.size();
        }
    }
}

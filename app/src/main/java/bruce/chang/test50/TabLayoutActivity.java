package bruce.chang.test50;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import bruce.chang.test50.fragment.TabFragment;

/**
 * Created by: BruceChang
 * Date on : 2016/11/25.
 * Time on: 18:33
 * Progect_Name:Test5.0
 * Source Github：
 * Description:
 */

public class TabLayoutActivity extends AppCompatActivity {

    TabLayout tab;
    ViewPager vpContent;
    List<Fragment> fragmentList;
    List<String> mTitles;
    TabFragmentAdapter mTabFragmentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        tab = (TabLayout) findViewById(R.id.tab);

        vpContent = (ViewPager) findViewById(R.id.vpContent);
        fragmentList = new ArrayList<>();
        mTitles = new ArrayList<>();

        mTitles.add("one");
        mTitles.add("two");
        mTitles.add("three");
        mTitles.add("four");
        mTitles.add("five");
        mTitles.add("six");
        mTitles.add("severn");
        mTitles.add("eight");
        mTitles.add("night");
        mTitles.add("ten");

        tab.addTab(tab.newTab().setText(mTitles.get(0)));
        tab.addTab(tab.newTab().setText(mTitles.get(1)));
        tab.addTab(tab.newTab().setText(mTitles.get(2)));
        tab.addTab(tab.newTab().setText(mTitles.get(3)));
        tab.addTab(tab.newTab().setText(mTitles.get(4)));
        tab.addTab(tab.newTab().setText(mTitles.get(5)));
        tab.addTab(tab.newTab().setText(mTitles.get(6)));
        tab.addTab(tab.newTab().setText(mTitles.get(7)));
        tab.addTab(tab.newTab().setText(mTitles.get(8)));
        tab.addTab(tab.newTab().setText(mTitles.get(9)));
        for (int i = 0; i < mTitles.size(); i++) {
            fragmentList.add(TabFragment.newInstance("hello " + mTitles.get(i)));
        }
        mTabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, mTitles);
        vpContent.setAdapter(mTabFragmentAdapter);
        tab.setupWithViewPager(vpContent);
    }
}

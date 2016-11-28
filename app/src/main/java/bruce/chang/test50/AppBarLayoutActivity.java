package bruce.chang.test50;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import bruce.chang.test50.fragment.AppBarFragment;

/**
 * Created by: BruceChang
 * Date on : 2016/11/25.
 * Time on: 18:34
 * Progect_Name:Test5.0
 * Source Github：
 * Description:
 */

public class AppBarLayoutActivity extends AppCompatActivity {

    private CoordinatorLayout coor_main;
    private AppBarLayout appbar;
    private Toolbar toolbar;
    private TabLayout tab;
    private ViewPager vpContent;
    List<Fragment> fragmentList;
    List<String> mTitles;
    TabFragmentAdapter mTabFragmentAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar);
        coor_main = (CoordinatorLayout) findViewById(R.id.coor_main);
        appbar = ((AppBarLayout) findViewById(R.id.appbar));
        toolbar = ((Toolbar) findViewById(R.id.toolbar));
        tab = ((TabLayout) findViewById(R.id.tabs));
        vpContent = ((ViewPager) findViewById(R.id.vpContent));
        initToolBar();
        initTab();
    }

    private void initToolBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("风清扬");
        toolbar.setLogo(R.mipmap.ic_launcher);
    }

    private void initTab() {
        fragmentList = new ArrayList<>();
        mTitles = new ArrayList<>();

        mTitles.add("one");
        mTitles.add("two");
        mTitles.add("three");
        mTitles.add("four");

        tab.addTab(tab.newTab().setText(mTitles.get(0)));
        tab.addTab(tab.newTab().setText(mTitles.get(1)));
        tab.addTab(tab.newTab().setText(mTitles.get(2)));
        tab.addTab(tab.newTab().setText(mTitles.get(3)));
        for (int i = 0; i < mTitles.size(); i++) {
            fragmentList.add(AppBarFragment.newInstance(""+i));
        }
        mTabFragmentAdapter = new TabFragmentAdapter(getSupportFragmentManager(), fragmentList, mTitles);
        vpContent.setAdapter(mTabFragmentAdapter);
        tab.setupWithViewPager(vpContent);
    }
}

package bruce.chang.test50;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout);
        tab = (TabLayout) findViewById(R.id.tab);
        vpContent = (ViewPager) findViewById(R.id.vpContent);
    }
}

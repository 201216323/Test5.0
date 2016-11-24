package bruce.chang.test50;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by: BruceChang
 * Date on : 2016/11/24.
 * Time on: 16:53
 * Progect_Name:Test5.0
 * Source Github：
 * Description:
 */

public class SwipeRefreshActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    SwipeRefreshLayout swipeContainer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiprefresh);
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        //设置下拉刷新监听事件
        swipeContainer.setOnRefreshListener(this);
        //设置进度条的颜色
        swipeContainer.setColorSchemeColors(Color.RED, Color.BLUE, Color.GREEN);
        //设置圆形进度条大小
        swipeContainer.setSize(SwipeRefreshLayout.DEFAULT);
        //设置进度条背景颜色
//        swipeContainer.setProgressBackgroundColorSchemeColor(Color.DKGRAY);
        //设置下拉多少距离之后开始刷新数据
//        swipeContainer.setDistanceToTriggerSync(50);

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Snackbar.make(swipeContainer, "刷新结束", Snackbar.LENGTH_SHORT).show();
                swipeContainer.setRefreshing(false);
            }
        }, 2000);
    }
}

package bruce.chang.test50;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by: BruceChang
 * Date on : 2016/11/24.
 * Time on: 17:27
 * Progect_Name:Test5.0
 * Source Github：
 * Description:
 */

public class ListPopupWindowActivity extends AppCompatActivity {
    LinearLayout lineContainer;
    Button buttonShow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listpopwindow);
        lineContainer = (LinearLayout) findViewById(R.id.lineContainer);
        buttonShow = (Button) findViewById(R.id.buttonShow);
        buttonShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showListPopup(buttonShow);
            }
        });

    }


    public void showListPopup(View view) {
        String items[] = {"item1", "item2", "item3", "item4", "item5"};
        final ListPopupWindow listPopupWindow = new ListPopupWindow(this);

        //设置ListView类型的适配器
        listPopupWindow.setAdapter(new ArrayAdapter<String>(ListPopupWindowActivity.this, android.R.layout.simple_list_item_1, items));

        //给每个item设置监听事件
        listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(lineContainer, "the position is" + position, Snackbar.LENGTH_SHORT)
                        .setCallback(new Snackbar.Callback() {
                            @Override
                            public void onDismissed(Snackbar snackbar, int event) {
                                super.onDismissed(snackbar, event);
                                new android.os.Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        listPopupWindow.dismiss();
                                    }
                                }, 500);
                            }
                        })
                        .show();

            }
        });

        //设置ListPopupWindow的锚点,也就是弹出框的位置是相对当前参数View的位置来显示，
        listPopupWindow.setAnchorView(view);

        //ListPopupWindow 距锚点的距离，也就是相对锚点View的位置
        listPopupWindow.setHorizontalOffset(100);
        listPopupWindow.setVerticalOffset(100);

        //设置对话框的宽高
        listPopupWindow.setWidth(lineContainer.getLayoutParams().width);
        listPopupWindow.setHeight(600);
        listPopupWindow.setModal(false);
        //设置点击外边区域不可取消
        listPopupWindow.setForceIgnoreOutsideTouch(true);

        listPopupWindow.show();

    }
}

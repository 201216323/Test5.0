package bruce.chang.test50;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;


/**
 * Created by: BruceChang
 * Date on : 2016/11/24.
 * Time on: 17:54
 * Progect_Name:Test5.0
 * Source Github：
 * Description:
 */

public class PopupMenuActivity extends AppCompatActivity {

    LinearLayout line1Container;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupmenu);
        line1Container = (LinearLayout) findViewById(R.id.line1Container);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(button);
            }
        });
    }

    public void showPopupMenu(View view) {
        //参数View 是设置当前菜单显示的相对于View组件位置，具体位置系统会处理
        PopupMenu popupMenu = new PopupMenu(this, view);
        //加载menu布局
        popupMenu.getMenuInflater().inflate(R.menu.menu_popmenu, popupMenu.getMenu());

        //设置menu中的item点击事件
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.share:
                        Snackbar.make(line1Container, "share", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.setting:
                        Snackbar.make(line1Container, "setting", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.cancle:
                        Snackbar.make(line1Container, "cancle", Snackbar.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
        //设置popupWindow消失的点击事件
//        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
//            @Override
//            public void onDismiss(PopupMenu menu) {
//                Snackbar.make(line1Container, "消失", Snackbar.LENGTH_SHORT).show();
//            }
//        });

        popupMenu.show();
    }
}

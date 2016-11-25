package bruce.chang.test50;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

/**
 * Created by Administrator
 * Date:2016/11/24
 * Time:21:08
 * Author:BruceChang
 * Function:
 */

public class ToolbarActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {
    Toolbar toolbar;
    Button button;
    SwitchCompat switchCompatBoy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titlebar);
        button = (Button) findViewById(R.id.button);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        switchCompatBoy = (SwitchCompat) findViewById(R.id.switchCompatBoy);
        setSupportActionBar(toolbar);
//        上面代码用来隐藏系统默认的Title。
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("主标题");
        toolbar.setSubtitle("副标题");
        toolbar.setSubtitleTextColor(getResources().getColor(R.color.colorAccent));
        toolbar.setLogo(R.mipmap.mine_login_account);
        toolbar.setNavigationIcon(android.R.drawable.ic_notification_clear_all);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        toolbar.setOnMenuItemClickListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ToolbarActivity.this, "aaa", Toast.LENGTH_SHORT).show();
            }
        });

        switchCompatBoy.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Toast.makeText(ToolbarActivity.this, "checked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ToolbarActivity.this, "no checked", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_titlebar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Toast.makeText(ToolbarActivity.this, "查找按钮", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_share:
                Toast.makeText(ToolbarActivity.this, "分享按钮", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}

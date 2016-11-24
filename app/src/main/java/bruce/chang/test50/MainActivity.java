package bruce.chang.test50;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView tvGoTextInputLayoutAct;
    TextView tvShowDialog;
    TextView tvGoSwipeRefreshActivity;
    TextView tvGoLinearLayoutCompatActivity;
    TextView tvGoListPopWindowActivity;
    TextView tvGoPopMenuActivity;
    TextView tvGoTitleBarActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvGoTextInputLayoutAct = (TextView) findViewById(R.id.tvGoTextInputLayoutAct);
        tvGoTextInputLayoutAct.setOnClickListener(this);
        tvShowDialog = (TextView) findViewById(R.id.tvShowDialog);
        tvShowDialog.setOnClickListener(this);
        tvGoSwipeRefreshActivity = (TextView) findViewById(R.id.tvGoSwipeRefreshActivity);
        tvGoSwipeRefreshActivity.setOnClickListener(this);
        tvGoLinearLayoutCompatActivity = (TextView) findViewById(R.id.tvGoLinearLayoutCompatActivity);
        tvGoLinearLayoutCompatActivity.setOnClickListener(this);
        tvGoListPopWindowActivity = (TextView) findViewById(R.id.tvGoListPopWindowActivity);
        tvGoListPopWindowActivity.setOnClickListener(this);
        tvGoPopMenuActivity = (TextView) findViewById(R.id.tvGoPopMenuActivity);
        tvGoPopMenuActivity.setOnClickListener(this);
        tvGoTitleBarActivity = (TextView) findViewById(R.id.tvGoTitleBarActivity);
        tvGoTitleBarActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvGoTextInputLayoutAct:
                go(TextInputLayoutActivity.class);
                break;
            case R.id.tvShowDialog:
                showDialog1();
                break;
            case R.id.tvGoSwipeRefreshActivity:
                go(SwipeRefreshActivity.class);
                break;
            case R.id.tvGoLinearLayoutCompatActivity:
                go(LinearLayoutCompatActivity.class);
                break;
            case R.id.tvGoListPopWindowActivity:
                go(ListPopupWindowActivity.class);
                break;
            case R.id.tvGoPopMenuActivity:
                go(PopupMenuActivity.class);
                break;
            case R.id.tvGoTitleBarActivity:
                go(TitleBarActivity.class);
                break;
        }

    }

    private void go(Class c) {
        startActivity(new Intent(this, c));
    }

    private void showDialog1() {
        android.support.v7.app.AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("我爱你 爱着你就像老鼠爱大米")
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", null)
                .setTitle("Material Design Dialog")
                .show();
    }
}

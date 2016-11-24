package bruce.chang.test50;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;


public class TextInputLayoutActivity extends AppCompatActivity implements View.OnClickListener {

    TextInputLayout usernameWrapper;
    TextInputLayout passwordWrapper;
    TextView tvLogin;
    LinearLayout activity_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinputlayout);
        usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);
        activity_main = (LinearLayout) findViewById(R.id.activity_main);
        activity_main.setOnClickListener(this);
        usernameWrapper.setHint("用户名");
        passwordWrapper.setHint("密码");

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvLogin:
                hideKeyboard();
                String username = usernameWrapper.getEditText().getText().toString();
                String password = passwordWrapper.getEditText().getText().toString();

                if (!validatePassword(username)) {
                    usernameWrapper.setError("Not a valid email address!");
                    usernameWrapper.getEditText().getText().clear();
                } else if (!validatePassword(password)) {
                    passwordWrapper.setError("Not a valid password!");//可以通过setError()显示输入错误提示，
                    passwordWrapper.getEditText().getText().clear();//输入错误的时候，清空此EditText
                } else {
                    usernameWrapper.setErrorEnabled(false);//setErrorEnabled(fasle)清除错误提示
                    passwordWrapper.setErrorEnabled(false);
                    doLogin();
                    break;

                }
            case R.id.activity_main:

                hideKeyboard();
                break;
        }
    }

    public void doLogin() {
        Snackbar snackbar = Snackbar.make(usernameWrapper, "OK! I'm performing login.", Snackbar.LENGTH_LONG);
        snackbar.setAction("取消", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        snackbar.setActionTextColor(getResources().getColor(R.color.colorAccent));
        setSnackbarMessageTextColor(snackbar, getResources().getColor(R.color.colorAccent));
        snackbar.show();

    }

    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }


    public void setSnackbarMessageTextColor(Snackbar snackbar, int color) {
        View view = snackbar.getView();
        view.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        ((TextView) view.findViewById(R.id.snackbar_text)).setTextColor(color);
    }
}

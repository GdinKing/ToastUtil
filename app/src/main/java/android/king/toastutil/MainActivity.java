package android.king.toastutil;

import androidx.appcompat.app.AppCompatActivity;

import android.king.toast.ToastUtil;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void warningClick(View view) {
        ToastUtil.show(this, "普通提示", ToastUtil.TYPE_WARNING);
    }

    public void successClick(View view) {
        ToastUtil.show(this, "成功提示", ToastUtil.TYPE_SUCCESS);
    }

    public void errorClick(View view) {
        ToastUtil.show(this, "错误提示", ToastUtil.TYPE_ERROR);
    }

    public void iconClick(View view) {
        ToastUtil.showWithIcon(this, "自定义图标", ToastUtil.STYLE_TWO,R.drawable.icon_tips);
    }

    public void gravityClick(View view) {
        ToastUtil.show(this, "自定义显示位置", ToastUtil.TYPE_WARNING, Gravity.BOTTOM);

    }
    public void styleClick(View view) {
        ToastUtil.showWithStyle(this, "错误提示", ToastUtil.TYPE_ERROR, ToastUtil.STYLE_TWO);
    }

}

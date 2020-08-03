package android.king.toast;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author king
 * @date 2020-08-03 09:47
 */
public class ToastUtil {

    public static final int TYPE_SUCCESS = 0;
    public static final int TYPE_WARNING = 1;
    public static final int TYPE_ERROR = 2;
    public static final int TYPE_CUSTOM = 3;


    public static final int STYLE_ONE = 1;
    public static final int STYLE_TWO = 2;

    /**
     * 显示长时间Toast
     */
    public static void showLongToast(Context context, String content) {
        show(context, content, Toast.LENGTH_LONG, TYPE_SUCCESS, Gravity.CENTER, STYLE_ONE, -1);
    }
    /**
     * 自定义提示类型
     */
    public static void show(Context context, String content, int type) {
        show(context, content, Toast.LENGTH_SHORT, type, Gravity.CENTER, STYLE_ONE, -1);
    }

    /**
     * 不同样式
     */
    public static void showWithStyle(Context context, String content, int type, int style) {
        show(context, content, Toast.LENGTH_SHORT, type, Gravity.CENTER, style, -1);
    }
    /**
     * 自定义图标
     */
    public static void showWithIcon(Context context, String content, int style, int icon) {
        show(context, content, Toast.LENGTH_SHORT, TYPE_CUSTOM, Gravity.CENTER, style, icon);
    }
    /**
     * 自定义显示位置
     */
    public static void show(Context context, String content, int type, int gravity) {
        show(context, content, Toast.LENGTH_SHORT, type, gravity, STYLE_ONE, -1);
    }
    /**
     * 默认
     */
    public static void show(Context context, String content) {
        show(context, content, Toast.LENGTH_SHORT, TYPE_WARNING, Gravity.CENTER, STYLE_ONE, -1);
    }

    /**
     * 显示Toast
     *
     * @param content  显示内容
     * @param duration Toast持续时间
     * @param type     显示图标类型:0 显示消息(默认)，1 显示信息, 2显示错误
     * @param gravity  显示位置
     * @param style    显示样式
     */
    public static void show(Context context, String content, int duration, int type, int gravity, int style, int icon) {
        if (!TextUtils.isEmpty(content)) {
            int layoutId = R.layout.layout_toast;
            if (style == STYLE_TWO) {
                layoutId = R.layout.layout_toast_second;
            }
            View view = LayoutInflater.from(context).inflate(layoutId, null);
            ImageView ivToast = view.findViewById(R.id.iv_toast);
            TextView tvToast = view.findViewById(R.id.tv_toast_text);
            Toast toast = new Toast(context);
            toast.setView(view);

            tvToast.setText(content);

            switch (type) {
                case TYPE_SUCCESS:
                    ivToast.setImageResource(R.drawable.icon_toast_success);
                    break;
                case TYPE_ERROR:
                    ivToast.setImageResource(R.drawable.icon_toast_error);
                    break;
                case TYPE_WARNING:
                    ivToast.setImageResource(R.drawable.icon_toast_warn);
                    break;
                case TYPE_CUSTOM:
                    ivToast.setImageResource(icon);
                    break;
                default:
                    ivToast.setImageResource(R.drawable.icon_toast_warn);
                    break;

            }
            toast.setDuration(duration);
            toast.setGravity(gravity, 0, 100);
            toast.show();
        }
    }

}

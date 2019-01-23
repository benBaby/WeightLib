package com.rasmsey.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 *  自定义角标按钮
 */
public class CornerLabelButton extends CoordinatorLayout {
    private static final String TAG = CornerLabelButton.class.getSimpleName();

    private ImageView icon;
    private TextView tv_title, tv_numbeer;

    public CornerLabelButton(@NonNull Context context) {
        super(context);
    }

    public CornerLabelButton(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CornerLabelButton(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CornerLabelButton);
        int count = typedArray.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = typedArray.getIndex(i);
            if (attr == R.styleable.CornerLabelButton_icon) {
                 try {
                     int ResId = typedArray.getResourceId(attr, 0);
                     icon.setImageResource(ResId);
                 } catch (Exception ex) {
                     Log.i(TAG, "加载ResId资源失败");
                     ex.printStackTrace();
                 }
            } else if (attr == R.styleable.CornerLabelButton_number) {
                String numberStr = typedArray.getString(attr);
                tv_numbeer.setText(!TextUtils.isEmpty(numberStr) ? numberStr : "字段空缺！");
            } else if (attr == R.styleable.CornerLabelButton_title) {
                String titleStr = typedArray.getString(attr);
                tv_title.setText(!TextUtils.isEmpty(titleStr) ? titleStr : "字段空缺!");
            }
        }
        typedArray.recycle();
    }

    private void init(Context mContext) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_cornerlabelbutton, null);
        icon = view.findViewById(R.id.iv_icon);
        tv_title = view.findViewById(R.id.tv_title);
        tv_numbeer = view.findViewById(R.id.tv_number);
    }

    public String getTv_title() {
        return tv_title.getText().toString();
    }

    public void setTv_title(String titleStr) {
        this.tv_title.setText(titleStr);
    }

    public int getNumbeer() {
        int number = 0;
        try {
            number = TextUtils.isEmpty(tv_numbeer.getText().toString()) ? 0 : Integer.valueOf(tv_numbeer.getText().toString());
        } catch (Exception ex) {
            Log.i(TAG, "获取消息数量失败");
            ex.printStackTrace();
        }
        return number;
    }

    public void setTv_numbeer(String numberStr) {
        this.tv_numbeer.setText(numberStr);
    }
}

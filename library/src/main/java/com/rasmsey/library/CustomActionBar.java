package com.rasmsey.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * 自定义 标题栏
 */
public class CustomActionBar extends RelativeLayout {
    private ImageView btn_back;
    private TextView tv_title;
    private TextView tv_submit;
    private OnBackListener listener;
    private OnSubmitListener submitListener;

    public CustomActionBar(Context context) {
        super(context);
    }

    public CustomActionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_custom_actionbar, this, true);
        btn_back = view.findViewById(R.id.btn_back);
        tv_title = view.findViewById(R.id.tv_title);
        tv_submit = view.findViewById(R.id.tv_submit);

        btn_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //返回按钮
                if (null != listener) {
                    listener.onBack();
                }
            }
        });

        tv_submit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    submitListener.onSubmit();
                }
            }
        });

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomActionBar);
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int attr = typedArray.getIndex(i);
                if (attr == R.styleable.CustomActionBar_cabTitleName) {
                    String titleName = typedArray.getString(attr);
                    if (TextUtils.isEmpty(titleName)) {
                        tv_title.setVisibility(View.GONE);
                    } else {
                        tv_title.setVisibility(View.VISIBLE);
                        tv_title.setText(titleName);
                    }
                } else if (attr == R.styleable.CustomActionBar_cabTitleColor) {
                    int colorRes = typedArray.getColor(attr, getResources().getColor(R.color.text_color_black2));
                    tv_title.setTextColor(colorRes);
                } else if (attr == R.styleable.CustomActionBar_cabTitleSize) {
                    int textSize = typedArray.getDimensionPixelSize(attr, 11);
                    tv_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
                } else if (attr == R.styleable.CustomActionBar_cabRightTextName) {
                    String rightName = typedArray.getString(attr);
                    if (TextUtils.isEmpty(rightName)) {
                        tv_submit.setVisibility(View.GONE);
                    } else {
                        tv_submit.setVisibility(View.VISIBLE);
                        tv_submit.setText(rightName);
                    }
                } else if (attr == R.styleable.CustomActionBar_cabRightTextColor) {
                    int colorRes1 = typedArray.getColor(attr, getResources().getColor(R.color.text_color_black2));
                    tv_submit.setTextColor(colorRes1);
                } else if (attr == R.styleable.CustomActionBar_cabRightTextSize) {
                    int textSize1= typedArray.getDimensionPixelSize(attr, 11);
                    tv_submit.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize1);
                } else if (attr == R.styleable.CustomActionBar_cabRightTextShow) {
                    boolean isShow = typedArray.getBoolean(attr, true);
                    if (isShow) {
                        tv_submit.setVisibility(View.VISIBLE);
                    } else {
                        tv_submit.setVisibility(View.GONE);
                    }
                }
        }
        typedArray.recycle();
    }


    public CustomActionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String getTv_title() {
        return tv_title.getText().toString();
    }

    public void setTv_title(String tv_title) {
        this.tv_title.setText(tv_title);
    }

    /**
     *  右边 text 是否显示
     * @param isShow true/false
     */
    public void rightShow(boolean isShow) {
        tv_submit.setVisibility(isShow ? View.VISIBLE : View.GONE);
    }

    public interface OnBackListener {
        void onBack();    //左边的按钮
    }

    public interface  OnSubmitListener{
        void onSubmit();  //右边的按钮
    }

    public void setOnBackListener(OnBackListener listener) {
        this.listener = listener;
    }

    public void setCustomActionBarRightListener(OnSubmitListener listener) {
        this.submitListener = listener;
    }
}

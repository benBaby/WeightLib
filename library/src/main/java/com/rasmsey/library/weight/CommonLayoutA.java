package com.rasmsey.library.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.rasmsey.library.R;

/**
 * 通用列表展示布局
 * -----------------------------------------------
 * 图标  文字                            文字 图标
 * ----------------------------------------------
 */
public class CommonLayoutA extends ConstraintLayout {

    // 左边标题
    private TextView tv_left_title;
    // 右边图标
    private ImageView iv_right_icon;
    // 左边图标
    private ImageView iv_left_icon;
    //右边的文字
    private TextView tv_right_title;
    //下划线
    private View divider;
    //右边  EditText
    private EditText et_right_value;

    public CommonLayoutA(Context context) {
        super(context);
    }

    public CommonLayoutA(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_common_layout_a, this, true);
        tv_left_title = view.findViewById(R.id.tv_layout_common_a_title);
        tv_right_title = view.findViewById(R.id.textView);
        iv_right_icon = view.findViewById(R.id.iv_layout_common_icon);
        iv_left_icon = view.findViewById(R.id.iv_left_icon);
        et_right_value = view.findViewById(R.id.editText);
        divider = view.findViewById(R.id.divider);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonLayoutA);
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int attr = typedArray.getIndex(i);
            if (attr == R.styleable.CommonLayoutA_CLAText) {
                tv_left_title.setText(TextUtils.isEmpty(typedArray.getString(attr)) ? "" : typedArray.getString(attr));
            } else if (attr == R.styleable.CommonLayoutA_CLATextColor) {
                tv_left_title.setTextColor(typedArray.getColor(attr, Color.BLACK));
            } else if (attr == R.styleable.CommonLayoutA_CLATextSize) {
                tv_left_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(attr, 14));
            } else if (attr == R.styleable.CommonLayoutA_CLAImageViewSrc) {
                iv_right_icon.setImageResource(typedArray.getResourceId(attr, Color.TRANSPARENT));
            } else if (attr == R.styleable.CommonLayoutA_CLATextDrawableStart) {
                Drawable drawable = typedArray.getDrawable(attr);
                assert drawable != null;
                drawable.setBounds(0, 0, 0, 0);
                tv_left_title.setCompoundDrawables(drawable, null, null, null);
            } else if (attr == R.styleable.CommonLayoutA_CLALeftViewSrc) {
                iv_left_icon.setImageResource(typedArray.getResourceId(attr, Color.TRANSPARENT));
            } else if (attr == R.styleable.CommonLayoutA_CLALeftViewShow) {
                iv_left_icon.setVisibility(typedArray.getBoolean(attr, false) ? View.VISIBLE : View.GONE);
            } else if (attr == R.styleable.CommonLayoutA_CLARightViewShow) {
                iv_right_icon.setVisibility(typedArray.getBoolean(attr, false) ? View.VISIBLE : View.GONE);
            } else if (attr == R.styleable.CommonLayoutA_CLARightText) {
                tv_right_title.setText(TextUtils.isEmpty(typedArray.getString(attr)) ? "" : typedArray.getString(attr));
            } else if (attr == R.styleable.CommonLayoutA_CLARightTextSize) {
                tv_right_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(attr, 14));
            } else if (attr == R.styleable.CommonLayoutA_CLARightTextColor) {
                tv_right_title.setTextColor(typedArray.getColor(attr, Color.BLACK));
            } else if (attr == R.styleable.CommonLayoutA_CLADividerColor) {
                divider.setBackgroundColor(typedArray.getColor(attr, Color.TRANSPARENT));
            } else if (attr == R.styleable.CommonLayoutA_CLARightEditTextHint) {
                et_right_value.setText(TextUtils.isEmpty(typedArray.getString(attr)) ? "" : typedArray.getString(attr));
            } else if (attr == R.styleable.CommonLayoutA_CLARightEditTextValue) {
                et_right_value.setText(TextUtils.isEmpty(typedArray.getString(attr)) ? "" : typedArray.getString(attr));
            } else if (attr == R.styleable.CommonLayoutA_CLARightEditTextValueSize) {
                et_right_value.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(attr, 14));
            } else if (attr == R.styleable.CommonLayoutA_CLARightEditTextValueColor) {
                et_right_value.setTextColor(typedArray.getColor(attr, Color.BLACK));
            } else if (attr == R.styleable.CommonLayoutA_CLARightEditTextEnable) {
                et_right_value.setEnabled(typedArray.getBoolean(attr, true));
            } else if (attr == R.styleable.CommonLayoutA_CLARightEditTextViewShow) {
                et_right_value.setVisibility(typedArray.getBoolean(attr, false) ? View.VISIBLE : View.GONE);
                tv_right_title.setVisibility(typedArray.getBoolean(attr, false) ? View.GONE : View.VISIBLE);
            }
        }
        typedArray.recycle();
    }

    public CommonLayoutA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String getTv_right_title() {
        return tv_right_title.getText().toString();
    }

    public void setTv_right_title(String tv_right_title) {
        this.tv_right_title.setText(tv_right_title);
    }

    /**
     * 隐藏 TextView
     * 显示 EditText
     */
    public void setEditTextShow() {
        tv_right_title.setVisibility(View.GONE);
        et_right_value.setVisibility(View.VISIBLE);
    }

    /**
     * 设置右边 EditText 的值
     */
    public void setEDRightValue(String message) {
        if (!TextUtils.isEmpty(message.trim())) {
            et_right_value.setText(message);
        }
    }

    /**
     *  获取右边 EditText 的值
     * @return
     */
    public String getEditTextValue() {
        if (TextUtils.isEmpty(et_right_value.getText().toString())) {
            return "";
        } else {
            return et_right_value.getText().toString();
        }
    }

    /**
     *  设置 editText 是否可编辑
     * @param flag  true/false
     */
    public void setRightEditTextEnable(boolean flag) {
        et_right_value.setEnabled(flag);
    }
}

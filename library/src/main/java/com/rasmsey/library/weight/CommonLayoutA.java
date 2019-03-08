package com.rasmsey.library.weight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.rasmsey.library.R;

public class CommonLayoutA extends ConstraintLayout {

    private TextView tv_title;
    private ImageView icon, iv_left_icon;

    public CommonLayoutA(Context context) {
        super(context);
    }

    public CommonLayoutA(Context context, AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.layout_common_layout_a, this, true);
         tv_title = view.findViewById(R.id.tv_layout_common_a_title);
         icon = view.findViewById(R.id.iv_layout_common_icon);
        iv_left_icon = findViewById(R.id.iv_left_icon);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CommonLayoutA);
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i <indexCount; i++) {
            int attr = typedArray.getIndex(i);
            if (attr == R.styleable.CommonLayoutA_CLAText) {
                tv_title.setText(TextUtils.isEmpty(typedArray.getString(attr)) ? "" : typedArray.getString(attr));
            } else if (attr == R.styleable.CommonLayoutA_CLATextColor) {
                tv_title.setTextColor(typedArray.getColor(attr, Color.BLACK));
            } else if (attr == R.styleable.CommonLayoutA_CLATextSize) {
                tv_title.setTextSize(TypedValue.COMPLEX_UNIT_PX, typedArray.getDimensionPixelSize(attr, 14));
            } else if (attr == R.styleable.CommonLayoutA_CLAImageViewSrc) {
                icon.setImageResource(typedArray.getResourceId(attr,Color.TRANSPARENT));
            } else if (attr == R.styleable.CommonLayoutA_CLATextDrawableStart) {
                Drawable drawable = typedArray.getDrawable(attr);
                drawable.setBounds(0, 0, 0, 0);
                tv_title.setCompoundDrawables(drawable, null, null, null);
            } else if (attr == R.styleable.CommonLayoutA_CLALeftViewSrc) {
                iv_left_icon.setImageResource(typedArray.getResourceId(attr, Color.TRANSPARENT));
            }
        }
        typedArray.recycle();


    }

    public CommonLayoutA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}

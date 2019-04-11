package com.xinshen.dynamtheme;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

/**
 * 描述:
 * @create 2018-08-25 13:05
 */
public class SkinItem {
    private String TAG = getClass().getSimpleName();
    private View view;

    private List<SkinAttr> attrs;


    public SkinItem(View view, List<SkinAttr> attrs) {
        this.view = view;
        this.attrs = attrs;
    }

    public void  apply() {
        Log.e(TAG,"apply");
        if (view == null || attrs == null)
            return;
        for (SkinAttr attr : attrs) {
            String attrName = attr.getAttrName();
            String attrType = attr.getAttrType();
            String resName = attr.getResName();
            int resId = attr.getResId();
            Log.e("SkinItem","attrName ="+attrName +"::"+"resName"+resName);
            if ("background".equals(attrName)) {
                if ("color".equals(attrType)) {
                    view.setBackgroundColor(SkinManager.getInstance().getColor(resName,resId));
                } else if ("drawable".equals(attrType)) {
                    view.setBackground(SkinManager.getInstance().getDrawable(resName,resId));
                }
            } else if ("textColor".equals(attrName)) {
                if (view instanceof TextView && "color".equals(attrType)) {
                    ((TextView) view).setTextColor(SkinManager.getInstance().getColor(resName,resId));
                }
            }
        }
    }

}

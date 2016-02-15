package com.yiw.circledemo.spannable;

import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import com.yiw.circledemo.R;

/**
 * @author yiw
 * @Description:
 * @date 16/1/2 16:32
 */
public class NameClickable extends ClickableSpan implements View.OnClickListener {
    private final ISpanClick mListener;
    private int mPosition;
    private Resources resources;

    public NameClickable(ISpanClick l, int position, Resources resources) {
        mListener = l;
        mPosition = position;
        this.resources = resources;
    }

    @Override
    public void onClick(View widget) {
        mListener.onClick(mPosition);
    }

    @Override
    public void updateDrawState(TextPaint ds) {
        super.updateDrawState(ds);
        int colorValue = resources.getColor(R.color.color_8290AF);
        ds.setColor(colorValue);
        ds.setUnderlineText(false);
        ds.clearShadowLayer();
    }
}

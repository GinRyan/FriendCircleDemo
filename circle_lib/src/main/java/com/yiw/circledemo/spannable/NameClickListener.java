package com.yiw.circledemo.spannable;

import android.text.SpannableString;


/**
 * @author yiw
 * @ClassName: NameClickListener
 * @Description: 点赞和评论中人名的点击事件
 * @date 2015-01-02 下午3:42:21
 */
public abstract class NameClickListener implements ISpanClick {
    private SpannableString userName;
    private String userId;

    public NameClickListener(SpannableString name, String userid) {
        this.userName = name;
        this.userId = userid;
    }

    @Override
    public void onClick(int position) {
        //
        onSpanClick(position);
    }

    public abstract void onSpanClick(int position);
}

package com.yiw.circledemo.adapter;

import android.support.annotation.NonNull;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

import com.yiw.circledemo.R;
import com.yiw.circledemo.bean.FavoriteItem;
import com.yiw.circledemo.spannable.CircleMovementMethod;
import com.yiw.circledemo.spannable.NameClickable;
import com.yiw.circledemo.widgets.FavoriteListView;

import java.util.List;

/**
 * @author yiw
 * @Description:
 * @date 16/1/2 18:51
 */
public class FavoriteListAdapter {

    private FavoriteListView mListView;
    private List<FavoriteItem> datas;

    public List<FavoriteItem> getDatas() {
        return datas;
    }

    public void setDatas(List<FavoriteItem> datas) {
        this.datas = datas;
    }

    @NonNull
    public void bindListView(FavoriteListView listview) {
        mListView = listview;
    }


    public int getCount() {
        if (datas != null && datas.size() > 0) {
            return datas.size();
        }
        return 0;
    }

    public Object getItem(int position) {
        if (datas != null && datas.size() > position) {
            return datas.get(position);
        }
        return null;
    }

    public long getItemId(int position) {
        return position;
    }

    public void notifyDataSetChanged() {
        SpannableStringBuilder builder = new SpannableStringBuilder();
        if (datas != null && datas.size() > 0) {
            //添加点赞图标
            builder.append(setImageSpan());
            //builder.append("  ");
            FavoriteItem item = null;
            for (int i = 0; i < datas.size(); i++) {
                item = datas.get(i);
                if (item != null) {
                    builder.append(setClickableSpan(item.getUser().getName(), i));
                    if (i != datas.size() - 1) {
                        builder.append(", ");
                    }
                }
            }

        }
        mListView.setText(builder);
        CircleMovementMethod cmm = new CircleMovementMethod(R.color.name_selector_color);
        cmm.setContext(mListView.getContext());
        mListView.setMovementMethod(cmm);
    }

    @NonNull
    private SpannableString setClickableSpan(String textStr, int position) {
        SpannableString subjectSpanText = new SpannableString(textStr);
        subjectSpanText.setSpan(new NameClickable(mListView.getSpanClickListener(), position, mListView.getResources()), 0, subjectSpanText.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return subjectSpanText;
    }

    private SpannableString setImageSpan() {
        String text = "  ";
        SpannableString imgSpanText = new SpannableString(text);
        imgSpanText.setSpan(new ImageSpan(mListView.getContext(), R.drawable.im_ic_dig_tips, DynamicDrawableSpan.ALIGN_BASELINE),
                0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return imgSpanText;
    }
}

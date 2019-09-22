package com.nanyibang.commonview.labelsview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nanyibang.commonview.R;

import java.util.List;

/**
 * @Package: com.donkingliang.labelsviewdemo
 * @Description:
 * @Author: zyh
 * @CreateDate: 2019-09-2019/9/22
 * @company: 上海若美科技有限公司
 */
public class SkuItemView<T> extends LinearLayout {

    private Context mContext;
    private LinearLayout mContanier;

    public SkuItemView(Context context) {
        this(context,null);
    }

    public SkuItemView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SkuItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init(context);
    }

    private void init(Context context) {
        mContanier = (LinearLayout) LayoutInflater.from(context).inflate(R.layout.sku_item_container,this);
    }

//    public void setOnLabelClickListener()
    public void setLabels(List<T> labels){
          mContanier.removeAllViews();
        for (int i = 0; i < 1; i++) {
            View skuItem = LayoutInflater.from(mContext).inflate(R.layout.sku_item_layout,mContanier,false);
            LabelsView   labelsView = skuItem.findViewById(R.id.labels);
            List<String> lb = (List<String>) labels;
            labelsView.setOnLabelClickListener(new LabelsView.OnLabelClickListener() {
                @Override
                public void onLabelClick(TextView label, Object data, int position) {

                }
            });
            labelsView.setLabels(lb);
            mContanier.addView(skuItem);
        }

    }
    public void setLabels(List<String> labels,onSkuItemClickListener listener){
        mContanier.removeAllViews();
        for (int i = 0; i < 1; i++) {
            View skuItem = LayoutInflater.from(mContext).inflate(R.layout.sku_item_layout,mContanier,false);
            LabelsView   labelsView = skuItem.findViewById(R.id.labels);
            labelsView.setLabels(labels);
            mContanier.addView(skuItem);
        }

    }
    public interface onSkuItemClickListener{
        void skuItemClick(int goodIndex,int skuIndx,String value);
    }

}

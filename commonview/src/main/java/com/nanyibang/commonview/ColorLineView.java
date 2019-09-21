package com.nanyibang.commonview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.nanyibang.commonview.common.ZUtils;

/**
 * @Package: com.nanyibang.commonview
 * @Description: 彩色的分割线
 * @Author: zyh
 * @CreateDate: 2019-09-2019/9/19
 * @company: 上海若美科技有限公司
 */
public class ColorLineView extends View {

    private float mItemLength;
    private float mSpaceingLength;
    private float mLineHeight;
    private int mFirstColor;
    private int mSecondColor;
    private float mLeanDegree;
    private Paint mPaint;

    public ColorLineView(Context context) {
        this(context,null);
    }

    public ColorLineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ColorLineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context,AttributeSet attrs) {

        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.ColorLineView);
        mItemLength = typedArray.getDimension(R.styleable.ColorLineView_itemLength, ZUtils.dp2px(context,13));
        mLineHeight = typedArray.getDimension(R.styleable.ColorLineView_lineHeiht,ZUtils.dp2px(context,3));
        mSpaceingLength = typedArray.getDimension(R.styleable.ColorLineView_itemSpaceing,ZUtils.dp2px(context,4f));
        mLeanDegree = typedArray.getFloat(R.styleable.ColorLineView_leanDegree,65f);
        mFirstColor = typedArray.getColor(R.styleable.ColorLineView_firstColor,Color.parseColor("#FF9D6F"));
        mSecondColor = typedArray.getColor(R.styleable.ColorLineView_firstColor,Color.parseColor("#7373B9"));

       mPaint = new Paint();
       mPaint.setAntiAlias(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        int lineWidth = getWidth();
        int lineHeight = getHeight();
        int count = (mItemLength+mSpaceingLength == 0)? 1 : (int) (lineWidth / (mItemLength + mSpaceingLength)+1);

        for (int i = 0; i < count; i++) {
            path.reset();
            canvas.save();
            float itemOffset= (float) (lineHeight/ Math.tan(mLeanDegree* Math.PI/180));
            float itemLengthSpace = mItemLength+mSpaceingLength;
            path.moveTo(itemLengthSpace*i+itemOffset,0);
            path.lineTo(itemLengthSpace*i+mItemLength,0);
            path.lineTo(itemLengthSpace*i+mItemLength-itemOffset,lineHeight);
            path.lineTo(itemLengthSpace*i,lineHeight);
            path.close();
            canvas.clipPath(path);
            if(i % 2 == 0){
                canvas.drawColor(mFirstColor);
            }else {
                canvas.drawColor(mSecondColor);
            }
            canvas.restore();
        }

    }
}

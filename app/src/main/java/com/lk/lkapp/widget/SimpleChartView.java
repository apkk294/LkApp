package com.lk.lkapp.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Package：com.lk.lkapp.widget
 * Created by user005 on 2016/12/30.
 * Description：a custom simple chart view.
 */

public class SimpleChartView extends View {

    private static final String TAG = "SimpleChartView";

    private final int DEFAULT_PADDING               = 20;
    //默认XY轴轴线颜色
    private final int DEFAULT_XY_POINT_COLOR        = 0xFF323232;
    //默认刻度线颜色
    private final int DEFAULT_TICK_MARK_COLOR       = 0xFF323232;
    //默认X轴文字颜色
    private final int DEFAULT_X_TEXT_COLOR          = 0xFF323232;
    //默认X轴文字大小
    private final int DEFAULT_X_TEXT_SIZE           = 12;
    //默认Y轴文字颜色
    private final int DEFAULT_Y_TEXT_COLOR          = 0xFF323232;
    //默认Y轴文字大小
    private final int DEFAULT_Y_TEXT_SIZE           = 12;
    //默认折线颜色
    private final int DEFAULT_LINE_VALUE_TEXT_COLOR = 0xFF323232;
    //默认圆圈颜色
    private final int DEFAULT_VALUE_CIRCLE_COLOR    = 0xFFFF4081;

    //默认Y轴刻度数
    private final int DEFAULT_Y_INTERVAL = 5;

    private Rect mChartRect;

    //XY轴
    private Paint mXYPaint;
    private int mXyColor = DEFAULT_XY_POINT_COLOR;

    //Y轴长度
    private int   mYLength;
    private Point mZeroPoint;

    //刻度
    private Paint mTickMarkPaint;
    private int mTickMarkColor = DEFAULT_TICK_MARK_COLOR;

    //y轴刻度的个数
    private int mYInterval = DEFAULT_Y_INTERVAL;

    //x轴文字
    private Paint mXTextPaint;
    private int mXTextColor = DEFAULT_X_TEXT_COLOR;
    private int mXTextSize  = DEFAULT_X_TEXT_SIZE;
    //y轴文字
    private Paint mYTextPaint;
    private int mYTextColor = DEFAULT_Y_TEXT_COLOR;
    private int mYTextSize  = DEFAULT_Y_TEXT_SIZE;

    //折线
    private Paint mLineValuePaint;
    private int mLineValueColor = DEFAULT_LINE_VALUE_TEXT_COLOR;

    private Paint mValueCirclePaint;
    private int mValueCircleColor = DEFAULT_VALUE_CIRCLE_COLOR;

    //x、y轴标题数组
    private String[] mXTitles  = new String[]{"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
    private String[] mYTitles  = new String[]{"15", "40", "41", "79", "100", "0", "1"};
    //最大值
    private float    mMaxValue = 100;

    public SimpleChartView(Context context) {
        super(context);
        init();
    }

    public SimpleChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mXYPaint = new Paint();
        mXYPaint.setColor(mXyColor);
        mXYPaint.setStyle(Paint.Style.FILL);
        mXYPaint.setAntiAlias(true);

        mTickMarkPaint = new Paint();
        mTickMarkPaint.setColor(mTickMarkColor);
        mTickMarkPaint.setStyle(Paint.Style.FILL);
        mTickMarkPaint.setAntiAlias(true);

        mXTextPaint = new Paint();
        mXTextPaint.setColor(mXTextColor);
        mXTextPaint.setStyle(Paint.Style.FILL);
        mXTextPaint.setAntiAlias(true);
        mXTextPaint.setTextSize(sp2px(getContext(), mXTextSize));

        mYTextPaint = new Paint();
        mYTextPaint.setColor(mYTextColor);
        mYTextPaint.setStyle(Paint.Style.FILL);
        mYTextPaint.setAntiAlias(true);
        mYTextPaint.setTextSize(sp2px(getContext(), mYTextSize));

        mLineValuePaint = new Paint();
        mLineValuePaint.setColor(mLineValueColor);
        //注意,如果Style设置成FILL的话Path是画不出来的
        mLineValuePaint.setStyle(Paint.Style.STROKE);
        mLineValuePaint.setAntiAlias(true);

        mValueCirclePaint = new Paint();
        mValueCirclePaint.setColor(mValueCircleColor);
        mValueCirclePaint.setStyle(Paint.Style.FILL);
        mValueCirclePaint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mChartRect = new Rect(getLeft(), getTop(), getRight(), getBottom());

        mYLength = mChartRect.height() - getPaddingTop() - getPaddingBottom() -
                dip2px(getContext(), 2 * DEFAULT_PADDING + 10);

        mZeroPoint = new Point(mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMeasureMode  = MeasureSpec.getMode(widthMeasureSpec);
        int widthMeasureSize  = MeasureSpec.getSize(widthMeasureSpec);
        int heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec);

        if (heightMeasureMode != MeasureSpec.EXACTLY) {
            setMeasuredDimension(widthMeasureSize, dip2px(getContext(), 400));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawXY(canvas);
        drawTickMark(canvas);
        drawValues(canvas);
        drawValueCircle(canvas);
    }

    private void drawXY(Canvas canvas) {
        //X轴
        canvas.drawLine(mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.right - getPaddingRight() - dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING),
                mXYPaint);
        //X轴箭头上半部分
        canvas.drawLine(mChartRect.right - getPaddingRight() - dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.right - getPaddingRight() - dip2px(getContext(), DEFAULT_PADDING + 5),
                mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING + 5),
                mXYPaint);
        //X轴箭头下半部分
        canvas.drawLine(mChartRect.right - getPaddingRight() - dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.right - getPaddingRight() - dip2px(getContext(), DEFAULT_PADDING + 5),
                mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING - 5),
                mXYPaint);
        //Y轴
        canvas.drawLine(mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.top + getPaddingTop() + dip2px(getContext(), DEFAULT_PADDING),
                mXYPaint);
        //Y轴箭头左半部分
        canvas.drawLine(mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.top + getPaddingTop() + dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING - 5),
                mChartRect.top + getPaddingTop() + dip2px(getContext(), DEFAULT_PADDING + 5),
                mXYPaint);
        //Y轴箭头右半部份
        canvas.drawLine(mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.top + getPaddingTop() + dip2px(getContext(), DEFAULT_PADDING),
                mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING + 5),
                mChartRect.top + getPaddingTop() + dip2px(getContext(), DEFAULT_PADDING + 5),
                mXYPaint);
    }

    private void drawTickMark(Canvas canvas) {
        if (mXTitles.length == 0) {
            return;
        }
        //计算x轴每个刻度之间的间隔
        int xTickSpacing = getXTickSpacing();
        for (int i = 0; i < mXTitles.length; i++) {
            canvas.drawLine(mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING) + xTickSpacing * (i + 1),
                    mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING),
                    mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING) + xTickSpacing * (i + 1),
                    mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING + 5),
                    mTickMarkPaint);
        }
        //X轴文字
        Rect xTextRect = new Rect();
        for (int i = 0; i < mXTitles.length; i++) {
            mXTextPaint.getTextBounds(mXTitles[i], 0, mXTitles[i].length(), xTextRect);
            canvas.drawText(mXTitles[i], mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING) + xTickSpacing * (i + 1) - xTextRect.width() / 2,
                    mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING) + xTextRect.height(), mXTextPaint);
        }

        //计算y轴每个刻度之间的间隔
        int yTickSpacing = mYLength / mYInterval;
        for (int i = 0; i < mYInterval; i++) {
            canvas.drawLine(mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING),
                    mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING) - yTickSpacing * (i + 1),
                    mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING + 5),
                    mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING) - yTickSpacing * (i + 1),
                    mTickMarkPaint);
        }
        //Y轴文字
        Rect  yTextRect  = new Rect();
        float yTickValue = mMaxValue / mYInterval;
        for (int i = 0; i < mYInterval; i++) {
            String yValue = String.valueOf(Math.ceil(yTickValue * (i + 1)));
            mYTextPaint.getTextBounds(yValue, 0, yValue.length(), yTextRect);
            canvas.drawText(yValue, mChartRect.left + getPaddingLeft() + dip2px(getContext(), DEFAULT_PADDING) - yTextRect.width() - 5,
                    mChartRect.bottom - getPaddingBottom() - dip2px(getContext(), DEFAULT_PADDING) - yTickSpacing * (i + 1) + yTextRect.height() / 3, mYTextPaint);
        }

    }

    /**
     * 画折线
     *
     * @param canvas 画布
     */
    private void drawValues(Canvas canvas) {
        int xTickSpacing = getXTickSpacing();

        Path valuePath = new Path();

        //移动到零点
        valuePath.moveTo(mZeroPoint.x, mZeroPoint.y);
        //移动到每个值所应该在的点
        for (int i = 0; i < mYTitles.length; i++) {
            valuePath.lineTo(mZeroPoint.x + (i + 1) * xTickSpacing,
                    mZeroPoint.y - calculateYValuePoint(i));
        }

        canvas.drawPath(valuePath, mLineValuePaint);
    }

    /**
     * 画点
     *
     * @param canvas 画布
     */
    private void drawValueCircle(Canvas canvas) {
        int xTickSpacing = getXTickSpacing();
        //半径
        int r = dip2px(getContext(), 5);
        //移动到每个值所应该在的点
        for (int i = 0; i < mYTitles.length; i++) {
            canvas.drawCircle(mZeroPoint.x + (i + 1) * xTickSpacing,
                    mZeroPoint.y - calculateYValuePoint(i), r, mValueCirclePaint);
        }
    }

    /**
     * 计算X轴每个刻度之间的间隔
     *
     * @return 每个刻度之间的间隔
     */
    private int getXTickSpacing() {
        return (mChartRect.width() - getPaddingLeft() - getPaddingRight() -
                dip2px(getContext(), 2 * DEFAULT_PADDING + 10)) / mXTitles.length;
    }

    /**
     * 计算y轴上的偏移量
     *
     * @param position 第几个值
     */
    private float calculateYValuePoint(int position) {
        //y值占总y轴的比例
        float valueRatio = Float.parseFloat(mYTitles[position]) / mMaxValue;
        return valueRatio * mYLength;
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * 设置最大值
     *
     * @param maxValue Y轴最大值
     */
    public void setMaxValue(float maxValue) {
        mMaxValue = maxValue;
    }

    /**
     * 设置X轴文字
     *
     * @param XTitles X轴文字
     */
    public void setXTitles(String[] XTitles) {
        mXTitles = XTitles;
    }

    /**
     * 设置Y值
     *
     * @param values y轴上要展示的值
     */
    public void setValues(String[] values) {
        mYTitles = values;
    }

}

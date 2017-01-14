package com.lk.lkapp.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

import com.lk.lkapp.R;
import com.lk.lkapp.base.BaseActivity;

/**
 * Package：com.lk.lkapp.ui.activity
 * Created by user005 on 2016/12/30.
 * Description：.
 */

public class ChartViewActivity extends BaseActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_chart_view;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void initView(Bundle savedInstanceState) {
        /*DatePickerDialog           datePickerDialog = new DatePickerDialog(this);
        WindowManager.LayoutParams lp = datePickerDialog.getWindow().getAttributes();
        lp.x = x坐标想在哪写哪;
        lp.y = y坐标想在哪写哪;
        datePickerDialog.getWindow().setAttributes(lp);

        View view = new View(this);
        int[] poiOnScreen = new int[2];
        view.getLocationOnScreen(poiOnScreen);
        //poiOnScreen[0]是x轴位置
        //poiOnScreen[1]是y轴位置*/
    }
}

package com.lk.lkapp.custom.behavior.helper;

/**
 * 创建者： user005
 * 时间：2017/2/13
 * Description：.
 */

public class MathUtils {
    static int constrain(int amount, int low, int high) {
        return amount < low ? low : (amount > high ? high : amount);
    }

    static float constrain(float amount, float low, float high) {
        return amount < low ? low : (amount > high ? high : amount);
    }
}

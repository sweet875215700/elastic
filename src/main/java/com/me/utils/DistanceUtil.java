package com.me.utils;

/**
 * Created by hotbody on 17/3/8.
 */
public class DistanceUtil {

    public static double distanceSimplify(double lat1, double lng1, double lat2, double lng2) {
        double dx = lng1 - lng2; // 经度差值
        double dy = lat1 - lat2; // 纬度差值
        double b = (lat1 + lat2) / 2.0; // 平均纬度
        double Lx = Math.toRadians(dx) * 6367000.0* Math.cos(Math.toRadians(b)); // 东西距离
        double Ly = 6367000.0 * Math.toRadians(dy); // 南北距离
        return Math.sqrt(Lx * Lx + Ly * Ly);  // 用平面的矩形对角距离公式计算总距离
    }

}

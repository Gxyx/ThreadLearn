package com.san.enumtest;

/**
 * @Auther: Gxyx
 * @Date: 2021/03/23/9:03
 */
public class EnumDemo {
    public static void main(String[] args) {
        Weekday day = Weekday.SUN;
        if (day == Weekday.SAT || day == Weekday.SUN) {
            System.out.println("Work at home!");
        } else {
            System.out.println("Work at office!");
        }
    }
}
enum Weekday {
    SUN, MON, TUE, WED, THU, FRI, SAT;
}
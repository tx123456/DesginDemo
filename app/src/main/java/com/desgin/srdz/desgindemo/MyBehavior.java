package com.desgin.srdz.desgindemo;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by SRDZ on 2016/7/8.
 */
public class MyBehavior extends CoordinatorLayout.Behavior {

    //布局指定的话必须实现这个构造方法，Java代码可以不用
    public MyBehavior(Context context, AttributeSet attr){
        super(context,attr);
    }

    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child, View directTargetChild, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed);
        if (dy < 0) {
            //向上滚动
            ViewCompat.animate(child).scaleX(1).scaleY(1).start();
        } else {
            //向下滚动
            ViewCompat.animate(child).scaleX(0).scaleY(0).start();
        }
    }
}

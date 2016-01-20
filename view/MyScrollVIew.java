package com.shenshenff.app6.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by Felix on 2016/1/19.
 */
public class MyScrollVIew extends ScrollView {

    public MyScrollVIew(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //return super.onInterceptTouchEvent(ev);
        return true;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
      //  super.onScrollChanged(l, t, oldl, oldt);
      //  Log.i("test","l"+l+"t"+t+"oldl"+oldl+"oldt"+oldt);
        scrollYListener.onScrollY(t);
    }

    //暴露方法
    public void setScrollYListener( ScrollYListener listener){
        this.scrollYListener = listener;
    };

    //借口成员变量
    private ScrollYListener scrollYListener;

    public interface ScrollYListener{
        void onScrollY(int t);
    }

}

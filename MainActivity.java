package com.shenshenff.app6;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.shenshenff.app6.view.MyScrollVIew;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener{

    private MyScrollVIew sl;
    private RelativeLayout ll;
    private LinearLayout ll2;
    private TextView tt_bg;
    private TextView input;
    private RelativeLayout.LayoutParams lp;

    private float yDown;
    private float yMove;
    private float yUp;
    private float yJuli;

    private float apl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        sl = (MyScrollVIew) findViewById(R.id.sl);
        ll = (RelativeLayout) findViewById(R.id.ll);
        ll2 = (LinearLayout) findViewById(R.id.ll2);

        sl.setOnTouchListener(this);

        tt_bg = (TextView) findViewById(R.id.tt);
        input = (TextView) findViewById(R.id.input);
        lp = (RelativeLayout.LayoutParams) input.getLayoutParams();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                if (sl.getScrollY() >= ll.getY()){
                    ll2.setVisibility(View.VISIBLE);
                } else if (sl.getScrollY() < ll.getY()){
                    ll2.setVisibility(View.GONE);
                }

                sl.setScrollYListener(new MyScrollVIew.ScrollYListener() {
                    @Override
                    public void onScrollY(int t) {

                        apl = ((float)t/(float)540);
                        Log.i("test", "透明度 = " + apl);
                        Log.e("test", "onScrollY = " + t);
                        if (t >= ll.getY()){
                            ll2.setVisibility(View.VISIBLE);
                        } else if (t < ll.getY()){
                            ll2.setVisibility(View.GONE);
                            tt_bg.setAlpha(apl + 0.2f);

                            lp.rightMargin = (int)(apl * 200)+12;
                            input.setLayoutParams(lp);

                        }
                    }
                });

                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return false;
    }
}

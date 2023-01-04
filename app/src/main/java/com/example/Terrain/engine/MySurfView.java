package com.example.Terrain.engine;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class MySurfView extends SurfaceView  {
    public MySurfView(Context context) {

        super(context);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }


    public MySurfView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MySurfView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
            // Invalidate() is inside the case statements because there are
            // many other motion events, and we don't want to invalidate
            // the view for those.
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    this.performClick();
                    invalidate();
                    break;
                case MotionEvent.ACTION_MOVE:
                    invalidate();
                    break;
                default:
                    // Do nothing.
            }
            return true;
    }
}

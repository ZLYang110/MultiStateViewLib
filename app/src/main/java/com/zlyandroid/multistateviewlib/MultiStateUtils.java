package com.zlyandroid.multistateviewlib;

import android.view.View;

import com.zlylib.multistateview.MultiStateView;


public class MultiStateUtils {


    //点击重试
    public static void setEmptyAndErrorClick(MultiStateView view, final SimpleListener listener) {
        view.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.retry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onResult();
            }
        });
    }



    public interface SimpleListener {
        void onResult();
    }

}

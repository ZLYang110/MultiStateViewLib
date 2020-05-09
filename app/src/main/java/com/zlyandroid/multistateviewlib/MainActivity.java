package com.zlyandroid.multistateviewlib;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zlylib.multistateview.MultiStateView;


public class MainActivity extends AppCompatActivity implements MultiStateView.StateListener {

    private Handler mHandler = new Handler();
    private MultiStateView mMultiStateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initMultiStateView();
        initListView();
    }
    private void initMultiStateView() {
        mMultiStateView = findViewById(R.id.multiStateView);
        mMultiStateView.setStateListener(this);
        startLoading(mMultiStateView);
        MultiStateUtils.setEmptyAndErrorClick(mMultiStateView, new MultiStateUtils.SimpleListener() {
            @Override
            public void onResult() {
                mMultiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
                Toast.makeText(getApplicationContext(), "重新加载数据", Toast.LENGTH_SHORT).show();
                Message msg = mHandler.obtainMessage();
                msg.obj = mMultiStateView;
                mHandler.sendMessageDelayed(msg, 1000);
            }
        });

    }

    private void initListView() {
        ListView list = findViewById(R.id.list);
        String[] data = new String[100];
        for (int i = 0; i < 100; i++) {
            data[i] = "数据" + i;
        }
        list.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, data));
    }
    @Override
    public void onStateChanged(int viewState) {
        Log.i("状态切换", "状态切换: " + viewState);
    }

    private void startLoading(MultiStateView multiStateView) {
        View loadingView = multiStateView.getView(MultiStateView.VIEW_STATE_LOADING);
        AnimationDrawable animBackground = (AnimationDrawable) loadingView.findViewById(R.id.loading_anim_view).getBackground();
        animBackground.start();
    }


    @Override
    protected void onPause() {
        mHandler.removeCallbacksAndMessages(null);
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.error:
                mMultiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
                return true;

            case R.id.empty:
                mMultiStateView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
                return true;

            case R.id.content:
                mMultiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
                return true;

            case R.id.loading:
                startLoading(mMultiStateView);
                mMultiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

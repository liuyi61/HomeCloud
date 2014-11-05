package com.liuyi.homecloud_aos.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.liuyi.homecloud_aos.R;
import com.liuyi.homecloud_aos.util.ConnectivityUtility;

public class WelcomeActivity extends Activity {

    private final static String TAG = "WelcomeActivity";

    private final static int MSG_UPDATE_STATE = 0x1;
    private Handler mHandler = null;
    private boolean isConnected = false;

    private TextView mStatusTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        mStatusTextView = (TextView) findViewById(R.id.status);
        
        init();
    }

    private void init() {
        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                case MSG_UPDATE_STATE:
                    mStatusTextView.invalidate();
                    break;

                default:
                    break;
                }
                super.handleMessage(msg);
            }
        };

        // Check connectivity
        checkConnectivity();
    }

    private void checkConnectivity() {
        if (ConnectivityUtility.checkWiFiConnected(getApplicationContext())) {
            mStatusTextView.setText(R.string.status_wifi_connected);
            mHandler.sendEmptyMessage(MSG_UPDATE_STATE);
            isConnected = true;
            return;
        }
        mStatusTextView.setText(R.string.status_disconnected);
        mHandler.sendEmptyMessage(MSG_UPDATE_STATE);
        isConnected = false;
    }

    OnClickListener clickListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (isConnected) {
                Intent intent = new Intent();
                intent.setClass(WelcomeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }
    };
    
}

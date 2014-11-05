package com.liuyi.homecloud_aos.activities;

import com.liuyi.homecloud_aos.R;
import com.liuyi.homecloud_aos.util.CommonUtility;

import android.app.Activity;
import android.os.Bundle;

public class LoginActivity extends Activity {

    private static final String TAG = "LoginActivity";
    private static final boolean DEBUG = CommonUtility.DEBUG;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    
}

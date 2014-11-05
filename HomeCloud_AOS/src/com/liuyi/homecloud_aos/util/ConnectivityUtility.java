package com.liuyi.homecloud_aos.util;

import android.content.Context;
import android.net.ConnectivityManager;

public class ConnectivityUtility {

    public static boolean checkWiFiOpen() {
        return true;
    }

    public static boolean checkWiFiConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager
                .getNetworkInfo(ConnectivityManager.TYPE_WIFI).isConnected();
    }
}

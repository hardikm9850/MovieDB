package com.moviedb;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import javax.inject.Inject;


/**
 * To check network connections states
 * Created by hardik on 06/01/16.
 */
public class ConnectionManager  {

    Context context;
    @Inject
    public ConnectionManager(Context context) {
        this.context = context;
    }

    /**
     * Get the network info
     *
     * @return Network info
     */
    private NetworkInfo getNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    /**
     * Check if there is any connectivity
     *
     * @return Has network connected or not
     */
    public boolean isConnected() {
        NetworkInfo info = getNetworkInfo();
        return info != null && info.isConnected();
    }

    public boolean isNetworkAvailable(){
        NetworkInfo info = getNetworkInfo();
        return info != null && info.isConnected();
    }
}
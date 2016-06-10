package com.thinkincode.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.net.InetAddress;

/**
 * Class containing helper methods for checking the state of the network.
 * */
public class NetworkInspector {

    /**
     * This method should not be called in the main/UI thread
     * as it makes a network call.
     *
     * @param context is non-null.
     * @return true iff the active network is connected and working.
     * @see #isActiveNetworkConnected(Context)
     */
    public boolean isActiveNetworkConnectedAndWorking(Context context) {
        return isActiveNetworkConnected(context)
                && (isGoogleReachableWithPing() || isGoogleReachableWithInetAddress());
    }

	/**
     * @param context is non-null.
     * @return true iff the active network is connected.
     * @see #isActiveNetworkConnectedAndWorking(Context)
	 * */
    public boolean isActiveNetworkConnected(Context context) {
    	ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

    	return networkInfo != null
				&& networkInfo.isAvailable()
    			&& networkInfo.isConnected();
    }

    /**
     * @return true iff a ping to www.google.com succeeded.
     */
    boolean isGoogleReachableWithPing() {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("/system/bin/ping -c 1 www.google.com");

            int exitValue = process.waitFor();

            if (exitValue == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
	}

    /**
     * @return true iff an address can be found for www.google.com with {@link InetAddress}.
     */
    boolean isGoogleReachableWithInetAddress() {
        try {
            InetAddress inetAddress = InetAddress.getByName("www.google.com");

            if (inetAddress != null && !inetAddress.toString().equals("")) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }
}

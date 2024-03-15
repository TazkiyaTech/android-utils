package com.tazkiyatech.utils.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.annotation.NonNull;

import java.net.InetAddress;

/**
 * Helper methods for checking the state of the network.
 */
public class NetworkInspector {

    @NonNull private final Context context;

    /**
     * Constructor.
     *
     * @param context The {@link Context} to use in order to get system services.
     */
    public NetworkInspector(@NonNull Context context) {
        this.context = context;
    }

    /**
     * This method should not be called in the main/UI thread as it makes a network call.
     *
     * @return true iff the active network is connected and working.
     * @see #isActiveNetworkConnected()
     */
    public boolean isActiveNetworkConnectedAndWorking() {
        return isActiveNetworkConnected()
                && (isGoogleReachableWithInetAddress() || isGoogleReachableWithPing());
    }

    /**
     * @return true iff the active network is connected.
     * @see #isActiveNetworkConnectedAndWorking()
     */
    public boolean isActiveNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    /**
     * @return true iff a ping to www.google.com succeeded.
     */
    boolean isGoogleReachableWithPing() {
        try {
            Process process = Runtime.getRuntime().exec("/system/bin/ping -c 1 google.com");

            int exitValue = process.waitFor();

            return exitValue == 0;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * @return true iff an address can be found for www.google.com with {@link InetAddress}.
     */
    boolean isGoogleReachableWithInetAddress() {
        try {
            return InetAddress.getByName("google.com").isReachable(5_000);
        } catch (Exception ex) {
            return false;
        }
    }
}

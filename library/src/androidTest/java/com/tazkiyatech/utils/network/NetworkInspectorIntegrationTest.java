package com.tazkiyatech.utils.network;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class NetworkInspectorIntegrationTest {

    private NetworkInspector networkInspector;

    @Before
    public void setUp() {
        networkInspector = new NetworkInspector(getContext());
    }

    @Test
    public void testIsActiveNetworkConnectedAndWorking() {
        assertTrue(networkInspector.isActiveNetworkConnectedAndWorking());
    }

    @Test
    public void testIsActiveNetworkConnected() {
        assertTrue(networkInspector.isActiveNetworkConnected());
    }

    @Test
    public void testIsGoogleReachableWithPing() {
        assertTrue(networkInspector.isGoogleReachableWithPing());
    }

    @Test
    public void testIsGoogleReachableWithInetAddress() {
        assertTrue(networkInspector.isGoogleReachableWithInetAddress());
    }

    /**
     * @return the {@link Context} for the target application being instrumented.
     */
    private Context getContext() {
        return ApplicationProvider.getApplicationContext();
    }
}

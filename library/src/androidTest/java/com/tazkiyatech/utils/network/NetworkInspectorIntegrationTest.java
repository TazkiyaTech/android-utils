package com.tazkiyatech.utils.network;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import static androidx.test.core.app.ApplicationProvider.getApplicationContext;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class NetworkInspectorIntegrationTest {

    private NetworkInspector networkInspector;

    @Before
    public void setUp() {
        networkInspector = new NetworkInspector(getApplicationContext());
    }

    @Test
    public void isActiveNetworkConnectedAndWorking() {
        assertTrue(networkInspector.isActiveNetworkConnectedAndWorking());
    }

    @Test
    public void isActiveNetworkConnected() {
        assertTrue(networkInspector.isActiveNetworkConnected());
    }

    @Test
    public void isGoogleReachableWithPing() {
        assertTrue(networkInspector.isGoogleReachableWithPing());
    }

    @Test
    public void isGoogleReachableWithInetAddress() {
        assertTrue(networkInspector.isGoogleReachableWithInetAddress());
    }
}

package com.thinkincode.utils.network;

import android.support.test.runner.AndroidJUnit4;

import com.thinkincode.utils.BaseTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class NetworkInspectorTest extends BaseTestCase {

    private NetworkInspector networkInspector;

    @Before
    @Override
    public void setUp() {
        super.setUp();
        networkInspector = new NetworkInspector();
    }

    @Test
    public void testIsActiveNetworkConnectedAndWorking() {
        assertTrue(networkInspector.isActiveNetworkConnectedAndWorking(getContext()));
    }

    @Test
    public void testIsActiveNetworkConnected() {
        assertTrue(networkInspector.isActiveNetworkConnected(getContext()));
    }

    @Test
    public void testIsGoogleReachableWithPing() {
        assertTrue(networkInspector.isGoogleReachableWithPing());
    }

    @Test
    public void testIsGoogleReachableWithInetAddress() {
        assertTrue(networkInspector.isGoogleReachableWithInetAddress());
    }
}

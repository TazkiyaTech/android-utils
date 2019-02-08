package com.thinkincode.utils.network;

import com.thinkincode.utils.BaseTestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class NetworkInspectorTest extends BaseTestCase {

    private NetworkInspector networkInspector;

    @Before
    @Override
    public void setUp() {
        super.setUp();
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
}

package com.tazkiyatech.utils.network

import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NetworkInspectorIntegrationTest {

    private var networkInspector = NetworkInspector(ApplicationProvider.getApplicationContext())

    @Test
    fun isActiveNetworkConnectedAndWorking() {
        assertTrue(networkInspector.isActiveNetworkConnectedAndWorking)
    }

    @Test
    fun isActiveNetworkConnected() {
        assertTrue(networkInspector.isActiveNetworkConnected)
    }

    @Test
    fun isGoogleReachableWithPing() {
        assertTrue(networkInspector.isGoogleReachableWithPing)
    }

    @Test
    fun isGoogleReachableWithInetAddress() {
        assertTrue(networkInspector.isGoogleReachableWithInetAddress)
    }
}
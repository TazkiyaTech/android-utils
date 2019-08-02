package com.tazkiyatech.utils.display

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

/**
 * Like [DialogFragment.show] but allows the show to be executed after an activity's state is saved.
 */
fun DialogFragment.showAllowingStateLoss(fragmentManager: FragmentManager, tag: String?) {
    fragmentManager.beginTransaction().add(this, tag).commitAllowingStateLoss()
}
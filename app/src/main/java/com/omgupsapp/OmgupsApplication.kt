package com.omgupsapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class OmgupsApplication @Inject constructor(): Application() {
}
package com.example.core.utils

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Parcelable

@Suppress("DEPRECATION")
inline fun <reified P : Parcelable> Intent.getParcelable(key: String): P? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableExtra(key, P::class.java)
    } else {
        getParcelableExtra(key)
    }
}

@Suppress("DEPRECATION")
inline fun <reified P : Parcelable> Intent.getParcelableArrayList(key: String): ArrayList<P>? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableArrayListExtra(key, P::class.java)
    } else {
        getParcelableArrayListExtra(key)
    }
}

@Suppress("DEPRECATION")
inline fun <reified P : Parcelable> Bundle.getParcelableValue(key: String): P? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelable(key, P::class.java)
    } else {
        getParcelable(key)
    }
}

@Suppress("DEPRECATION")
inline fun <reified P : Parcelable> Bundle.getParcelableArrayListValue(key: String): ArrayList<P>? {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableArrayList(key, P::class.java)
    } else {
        getParcelableArrayList(key)
    }
}

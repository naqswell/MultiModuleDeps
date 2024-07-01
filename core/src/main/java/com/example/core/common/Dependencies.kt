package com.example.core.common

import androidx.fragment.app.Fragment

interface Dependencies

typealias DepsMap = Map<Class<out Dependencies>, @JvmSuppressWildcards Dependencies>

interface HasDependencies {
    val depsMap: DepsMap
}

inline fun <reified D: Dependencies> Fragment.findDependencies(): D {
    val hasDependencies = parentFragment as? HasDependencies
        ?: activity as? HasDependencies
        ?: activity?.application as? HasDependencies

    return hasDependencies
        ?.depsMap
        ?.get(D::class.java) as? D
        ?: error("No dependencies ${D::class.java} for ${this::class.java}")
}
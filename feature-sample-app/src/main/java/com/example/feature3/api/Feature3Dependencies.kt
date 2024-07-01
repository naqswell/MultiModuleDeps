package com.example.feature3.api

import com.example.core.common.Dependencies
import com.example.core.utils.SystemLogger

interface Feature3Dependencies: Dependencies {
    val systemLogger: SystemLogger
}
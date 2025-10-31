package com.example.benchmark
import androidx.benchmark.macro.StartupTimingMetric
import androidx.benchmark.macro.StartupMode
import androidx.benchmark.macro.junit4.MacrobenchmarkRule
import androidx.benchmark.macro.CompilationMode
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import android.util.Log

@RunWith(AndroidJUnit4::class)
class StartupBenchmark {

    @get:Rule
    val benchmarkRule = MacrobenchmarkRule()

    @Test
    fun startup() {
        benchmarkRule.measureRepeated(
            packageName = "com.example.android_macrobenchmark_v3",
            metrics = listOf(StartupTimingMetric()),
            compilationMode = CompilationMode.None(),
            startupMode = StartupMode.COLD,
            iterations = 5
        ) {
            pressHome()
            startActivityAndWait()
        }

        // Note: metrics aren't directly accessible here anymore
        // But you can rely on verbose Gradle output or external results.json
        Log.i("BenchmarkInfo", "Startup benchmark executed — check Gradle console or results.json for timing metrics")
    }
}

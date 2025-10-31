package com.example.android_macrobenchmark_v3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var counter by remember { mutableStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Macrobenchmark Demo App") })
        }
    ) { padding ->
        Button(
            onClick = { counter++ },
            modifier = androidx.compose.ui.Modifier.padding(padding)
        ) {
            Text("Clicked $counter times")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    MyApp()
}
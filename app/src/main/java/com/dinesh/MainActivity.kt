package com.dinesh

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dinesh.ui.theme.AppTheme
import com.parallelc.micts.R
import com.parallelc.micts.config.AppConfig.CONFIG_NAME
import com.parallelc.micts.config.AppConfig.DEFAULT_CONFIG
import com.parallelc.micts.config.AppConfig.KEY_DEFAULT_DELAY
import com.parallelc.micts.config.AppConfig.KEY_TILE_DELAY
import com.parallelc.micts.config.AppConfig.KEY_VIBRATE
import com.parallelc.micts.ui.activity.triggerCircleToSearch

//import android.webkit.WebResourceRequest
//import android.webkit.WebResourceResponse
//import android.webkit.WebView
//import android.webkit.WebViewClient
//
//class MyWebViewClient : WebViewClient() {
//    override fun shouldInterceptRequest(
//        view: WebView?,
//        request: WebResourceRequest?
//    ): WebResourceResponse? {
//        // 1. Intercept the request
//        val url = request?.url?.toString() ?: return null
//
//        // 2. Identify if this request is for video data
//        if (isVideoRequest(url)) { // You'll implement this logic
//            // 3. Initiate the download (using a separate library)
//            initiateDownload(url) // You'll implement this
//        }
//
//        // Return null to let the WebView handle the request normally
//        // if it's not a video we want to download ourselves.
//        return null
//    }
//
//    private fun isVideoRequest(url: String): Boolean {
//        // Implement your logic here.  Examples:
//        // - Check for file extensions: .ts, .m3u8, .mpd, .mp4, .webm
//        // - Check for MIME types: video/mp4, application/vnd.apple.mpegurl, etc.
//        // - Check for specific URL patterns known to be used for video segments.
//        //   (This is fragile and website-specific).
//        return url.contains(".ts") || url.contains(".m3u8") || url.contains(".mp4")
//    }
//
//    private fun initiateDownload(url: String) {
//        // Use FileDownloader (or OkHttp directly) to download the URL
//        // to your app's storage.  See details below.
//    }
//}

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

//        startActivity(Intent(this, com.parallelc.micts.ui.activity.MainActivity::class.java))

//        val prefs = getSharedPreferences(CONFIG_NAME, MODE_PRIVATE)
//        val key = if (intent.getBooleanExtra("from_tile", false)) KEY_TILE_DELAY else KEY_DEFAULT_DELAY
//        val delay = prefs.getLong(key, DEFAULT_CONFIG[key] as Long)
//        if (delay > 0) {
//            Thread.sleep(delay)
//        }
//        if (!triggerCircleToSearch(1, this, prefs.getBoolean(KEY_VIBRATE, DEFAULT_CONFIG[KEY_VIBRATE] as Boolean))) {
//            Toast.makeText(this, getString(R.string.trigger_failed), Toast.LENGTH_SHORT).show()
//        }
//        finish()

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        Greeting("Android")
    }
}


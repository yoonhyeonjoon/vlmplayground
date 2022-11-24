
package com.vlm.vlmplayground

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import com.vlmplayground.core.feature.bulletin.BulletinViewModel
import com.vlmplayground.core.model.data.Bulletin
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

//@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@OptIn(ExperimentalLifecycleComposeApi::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
//        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)

//        var uiState: MainActivityUiState by mutableStateOf(Loading)

//        // Update the uiState
//        lifecycleScope.launch {
//            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.uiState
//                    .onEach {
//                        uiState = it
//                    }
//                    .collect()
//            }
//        }
//
//        // Keep the splash screen on-screen until the UI state is loaded. This condition is
//        // evaluated each time the app needs to be redrawn so it should be fast to avoid blocking
//        // the UI.
//        splashScreen.setKeepOnScreenCondition {
//            when (uiState) {
//                Loading -> true
//                is Success -> false
//            }
//        }

        // Turn off the decor fitting system windows, which allows us to handle insets,
        // including IME animations
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            BulletinCompose()

//            val systemUiController = rememberSystemUiController()
//            val darkTheme = shouldUseDarkTheme(uiState)
//
//            // Update the dark content of the system bars to match the theme
//            DisposableEffect(systemUiController, darkTheme) {
//                systemUiController.systemBarsDarkContentEnabled = !darkTheme
//                onDispose {}
//            }
//
//            NiaTheme(
//                darkTheme = darkTheme,
//                androidTheme = shouldUseAndroidTheme(uiState)
//            ) {
//                NiaApp(
//                    networkMonitor = networkMonitor,
//                    windowSizeClass = calculateWindowSizeClass(this),
//                )
//            }
        }
    }

//    override fun onResume() {
//        super.onResume()
//        lazyStats.get().isTrackingEnabled = true
//    }
//
//    override fun onPause() {
//        super.onPause()
//        lazyStats.get().isTrackingEnabled = false
//    }
}

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun BulletinCompose(
    modifier: Modifier = Modifier,
    viewModel: BulletinViewModel = hiltViewModel()
) {
//    val bulletinState = viewModel.streamisOk
//    val coroutineScope = rememberCoroutineScope()

//    LaunchedEffect(true){
    viewModel.bulletinBoardInitializing()

    viewModel.bulletinUploading(
        Bulletin(
            fid = "vUwh0CY4mwecal2n8BR",
            images = listOf<String>("images/011.jpg", "images/012.jpg", "images/013.jpg"),
            date = Date(),
            score = 131,
            name = "CheckFor2",
            text = "이것이야말로 넣는 다.",
            title = "아침이 계십니다. 책상을 남은 이름을 말 이국 봅니다."
        )
    )
//        viewModel.bulletinBoardInitializing()
//        bulletinState.collect{ list ->
//            println("printed by bulletin : $list")
////            list.forEach{println("printed by bulletin : $it")}
//        }
//    }

}

///**
// * Returns `true` if the Android theme should be used, as a function of the [uiState].
// */
//@Composable
//fun shouldUseAndroidTheme(
//    uiState: MainActivityUiState,
//): Boolean = when (uiState) {
//    Loading -> false
//    is Success -> when (uiState.userData.themeBrand) {
//        ThemeBrand.DEFAULT -> false
//        ThemeBrand.ANDROID -> true
//    }
//}

///**
// * Returns `true` if dark theme should be used, as a function of the [uiState] and the
// * current system context.
// */
//@Composable
//fun shouldUseDarkTheme(
//    uiState: MainActivityUiState,
//): Boolean = when (uiState) {
//    Loading -> isSystemInDarkTheme()
//    is Success -> when (uiState.userData.darkThemeConfig) {
//        DarkThemeConfig.FOLLOW_SYSTEM -> isSystemInDarkTheme()
//        DarkThemeConfig.LIGHT -> false
//        DarkThemeConfig.DARK -> true
//    }
//}

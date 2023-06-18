package com.example.quantumwallettest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quantumwallettest.fragment.login.LoginFragment
import com.example.quantumwallettest.fragment.register.RegisterFragment
import com.example.quantumwallettest.fragment.verification.VerificationSuccessFragment
import com.example.quantumwallettest.ui.theme.QuantumWalletTestTheme
import com.example.quantumwallettest.utils.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuantumWalletTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    JetpackComposeAppScreen()
                }
            }
        }
    }
}

@Composable
fun JetpackComposeAppScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.Register.route) {
        composable(route = Route.Register.route) {
            RegisterFragment(onLoginClicked = {
                navController.navigate(Route.Login.route)
            })
        }
        composable(route = Route.Login.route) {
            LoginFragment(onRegisterClicked = {
                navController.navigate(Route.Register.route)
            }, onLoginSucceed = {
                navController.navigate(Route.Verified.route)
            })
        }
        composable(route = Route.Verified.route) {
            VerificationSuccessFragment()
        }
    }
}
package com.example.quantumwallettest.fragment.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.quantumwallettest.R
import com.example.quantumwallettest.ui.component.ClickSpannableText
import com.example.quantumwallettest.ui.component.PhoneEditText
import com.example.quantumwallettest.ui.theme.QuantumWalletTestTheme
import kotlinx.coroutines.flow.collectLatest


/**
 * Created by ray <rizkirayraynaldy@gmail.com> on 11/06/23.
 */

@Composable
fun LoginFragment(
    modifier: Modifier = Modifier,
    viewModel: LoginViewModel = hiltViewModel(),
    onLoginSucceed: () -> Unit = {},
    onRegisterClicked: () -> Unit = {}
) {
    val context = LocalContext.current
    LaunchedEffect(Unit) {
        viewModel.shouldVerified.collectLatest {
            if (it) onLoginSucceed.invoke()
            else Toast.makeText(context, "User not found", Toast.LENGTH_SHORT).show()
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        LoginScreen(onRegisterClicked = onRegisterClicked, onLoginClicked = { phone ->
            viewModel.getUserByPhone(phone)
        })
    }
}

@Composable
fun LoginScreen(
    onLoginClicked: (String) -> Unit = {},
    onRegisterClicked: () -> Unit = {}
) {
    val context = LocalContext.current
    var phone by remember { mutableStateOf("4227 242 6432") }
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.image_bg),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Column {
            Image(
                modifier = Modifier
                    .statusBarsPadding()
                    .padding(24.dp),
                painter = painterResource(id = R.drawable.ic_quantum),
                contentDescription = null
            )
            Text(
                text = "Welcome!",
                color = Color.White,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(24.dp)
            )
            Text(
                text = "Please enter your phone number to continue",
                color = Color.White.copy(alpha = 0.7f),
                style = MaterialTheme.typography.bodyLarge.copy(lineHeight = 24.sp),
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp)
                    .weight(1f)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Card(
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                modifier = Modifier
            ) {
                PhoneEditText(
                    value = phone,
                    onValueChange = { phone = it },
                    label = "Phone number",
                    leftText = "+01",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 24.dp, end = 24.dp, top = 16.dp)
                )
                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = {
                        onLoginClicked.invoke(phone)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(54.dp)
                        .padding(start = 24.dp, end = 24.dp),
                    shape = RoundedCornerShape(14.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5EA7FF))
                ) {
                    Text("Log In", style = MaterialTheme.typography.bodyLarge)
                }
                ClickSpannableText(
                    regularText = "Still have no account?",
                    clickableText = "Register",
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 24.dp)
                        .align(Alignment.CenterHorizontally),
                ) {
                    onRegisterClicked.invoke()
                }
                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    QuantumWalletTestTheme {
        LoginFragment()
    }
}
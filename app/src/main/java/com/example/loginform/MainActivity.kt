package com.example.loginform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginform.ui.theme.LoginFormTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginFormTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LoginForm()
                }
            }
        }
    }
}

@Composable
fun LoginForm(modifier: Modifier = Modifier) {
    var emailInputField by remember {mutableStateOf("")}
    var passwordInputField by remember { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier=Modifier.padding(horizontal = 40.dp)
    ) {
        Text(
            text = stringResource(id = R.string.login),
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(100.dp))
        EditTextField(
            label = R.string.email,
            leadingIcon = R.drawable.email,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            value = emailInputField,
            onValueChange = {emailInputField = it}
        )
        Spacer(modifier = Modifier.height(30.dp))
        EditTextField(
            label = R.string.password,
            leadingIcon = R.drawable.password,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            value = passwordInputField,
            onValueChange = {passwordInputField = it}
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text= stringResource(id = R.string.forgot_password),
            textAlign = TextAlign.Center,
            color = Color.Blue,
            modifier = Modifier.clickable {}

        )
        Spacer(modifier = Modifier.height(15.dp))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(stringResource(id = R.string.login))
        }
        Spacer(modifier = Modifier.height(30.dp))
        Row {
            Text(text = stringResource(id = R.string.not_a_member))
            Text(
                text = stringResource(id = R.string.sign_up),
                color = Color.Blue,
                modifier = Modifier
                    .padding(start = 4.dp)
                    .clickable { }

            )
        }
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTextField(
    @DrawableRes leadingIcon :Int,
    @StringRes label : Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        label = {Text(text = stringResource(id = label))},
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), contentDescription = null)},
        keyboardOptions = keyboardOptions,
        modifier = Modifier.fillMaxWidth()
    )

}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LoginFormTheme {
        LoginForm()
    }
}
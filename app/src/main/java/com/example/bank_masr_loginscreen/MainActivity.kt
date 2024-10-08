package com.example.bank_masr_loginscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bank_masr_loginscreen.ui.theme.Bank_Masr_LoginScreenTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bank_Masr_LoginScreenTheme {
                BankLoginScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BankLoginScreen() {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    val isButtonEnabled = text.isNotEmpty() && password.isNotEmpty()
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,

            ) {
            Image(
                painter = painterResource(id = R.drawable.bm_icon),
                contentDescription = "Bank Masr Logo",
                modifier = Modifier.padding(top = 72.dp, start = 16.dp)
            )
            Text(
                text = stringResource(R.string.language),
                modifier = Modifier
                    .padding(top = 88.dp, start = 240.dp)
                    .clickable {},
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Red,
                textAlign = TextAlign.Center
            )

        }
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text(text = stringResource(R.string.username)) },
            modifier = Modifier
                .width(408.dp)
                .padding(top = 32.dp, start = 36.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color.Red,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Color.Red
            )
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = stringResource(R.string.password)) },
            modifier = Modifier
                .width(408.dp)
                .padding(top = 32.dp, start = 36.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val icon = if (passwordVisible)
                    painterResource(id = R.drawable.visibility) // Replace with your visibility icon
                else painterResource(id = R.drawable.unvisibility) // Replace with your visibility off icon

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(painter = icon, contentDescription = "Toggle password visibility")
                }
            },

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.Red,
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color.Red,
                unfocusedLabelColor = Color.Gray,
                cursorColor = Color.Red
            )

        )
        Text(
            text = stringResource(R.string.forgot),
            modifier = Modifier
                .padding(top = 28.dp, start = 36.dp)
                .clickable {},
            fontSize = 16.sp,
            textDecoration = TextDecoration.Underline,
            color = Color.Red,
            textAlign = TextAlign.Center

        )

        Button(
            onClick = { },
            modifier = Modifier
                .width(408.dp)
                .height(96.dp)
                .padding(top = 32.dp, start = 36.dp),
            shape = MaterialTheme.shapes.medium,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isButtonEnabled) Color(red = 189, green = 52, blue = 70, alpha = 255) else Color.Gray,

            )
        ) {
            Text(text = stringResource(R.string.login), fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.need_help),
                modifier = Modifier
                    .padding(top = 28.dp, start = 36.dp)
                    .clickable { },
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                // Only needed once
                color = Color.Red
            )


            Text(
                text = stringResource(R.string.contact),
                modifier = Modifier
                    .padding(top = 28.dp)
                    .clickable {},
                fontSize = 16.sp,

                textDecoration = TextDecoration.Underline, // Only needed once
                color = Color.Red
            )
        }

        HorizontalDivider(
            thickness = 0.5.dp,
            color = Color.Red,
            modifier = Modifier.padding(top = 32.dp, start = 36.dp, end = 36.dp)
        )

        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(Modifier.padding(start = 8.dp, top = 24.dp)) {
                Image(painter = painterResource(R.drawable.our_products), contentDescription = "")
                Text(
                    text = stringResource(R.string.products),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    modifier = Modifier.clickable {},
                    maxLines = 1,
                    overflow = TextOverflow.Visible
                )

            }


            Column(Modifier.padding(start = 8.dp, top = 24.dp)) {
                Image(painter = painterResource(R.drawable.exchange_rate), contentDescription = "")
                Text(
                    text = stringResource(R.string.exchange),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    modifier = Modifier.clickable {},
                    maxLines = 1,
                    overflow = TextOverflow.Visible
                )

            }
            Column(Modifier.padding(start = 8.dp, top = 24.dp)) {
                Image(painter = painterResource(R.drawable.security_tips), contentDescription = "")
                Text(text = stringResource(R.string.security),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    modifier = Modifier.clickable {},
                    maxLines = 1,
                    overflow = TextOverflow.Visible
                )

            }
            Column(Modifier.padding(start = 8.dp, top = 24.dp)) {
                Image(
                    painter = painterResource(R.drawable.nearest_branch_or_atm),
                    contentDescription = ""
                )
                Text(text = stringResource(R.string.nearest),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red,
                    modifier = Modifier
                        .clickable {},
                    overflow = TextOverflow.Visible

                )

            }


        }

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BankLoginScreenPreview() {
    BankLoginScreen()
}
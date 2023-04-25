package com.sumit.jetpackdemo

import android.R
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.sumit.jetpackdemo.ui.theme.JetPackDemoTheme
import com.sumit.jetpackdemo.ui.theme.BackgroundImage.Background
import com.sumit.jetpackdemo.ui.theme.UserListCard.UserCard

@SuppressLint("StaticFieldLeak")
var context : Context?=null
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    context = LocalContext.current
                    HomePage()

//                    Expanded().MyApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }


    @Composable
    fun Greeting() {

    }

    @Composable
    fun card(){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            UserCard().ui()
            Spacer(modifier = Modifier.height(0.dp))
            Background().BackgroundImage()
            Spacer(modifier = Modifier.height(0.dp))
            UserCard().ui()
        }
    }
    @Composable
    fun HomePage(){

        val showDialog =  remember { mutableStateOf(false) }

        if(showDialog.value)
            CustomDialog(value = "", setShowDialog = {
                showDialog.value = it
            }) {
                Log.i("HomePage","HomePage : $it")
            }

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Home")
                    }
                )
            }) {
            Box(modifier = Modifier.background(Color.White)) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Button(onClick = {
                        showDialog.value = true
                    }) {
                        Text(text = "Open Dialog")
                    }
                }
            }
        }
    }


    @Composable
    fun CustomDialog(value: String, setShowDialog: (Boolean) -> Unit, setValue: (String) -> Unit) {

        val txtFieldError = remember { mutableStateOf("") }
        val txtField = remember { mutableStateOf(value) }

        Dialog(onDismissRequest = { setShowDialog(false) }) {
            Surface(
                shape = RoundedCornerShape(16.dp),
                color = Color.White
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Column(modifier = Modifier.padding(20.dp)) {

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Set value",
                                style = TextStyle(
                                    fontSize = 24.sp,
                                    fontFamily = FontFamily.Default,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Icon(
                                imageVector = Icons.Filled.Home,
                                contentDescription = "",
                                tint = colorResource(android.R.color.darker_gray),
                                modifier = Modifier
                                    .width(30.dp)
                                    .height(30.dp)
                                    .clickable { setShowDialog(false) }
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(
                                    BorderStroke(
                                        width = 2.dp,
                                        color = colorResource(id = if (txtFieldError.value.isEmpty()) R.color.holo_green_light else R.color.holo_red_dark)
                                    ),
                                    shape = RoundedCornerShape(50)
                                ),
                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.AccountBox,
                                    contentDescription = "",
                                    tint = colorResource(android.R.color.holo_green_light),
                                    modifier = Modifier
                                        .width(20.dp)
                                        .height(20.dp)
                                )
                            },
                            placeholder = { Text(text = "Enter value") },
                            value = txtField.value,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            onValueChange = {
                                txtField.value = it.take(10)
                            })

                        Spacer(modifier = Modifier.height(20.dp))

                        Box(modifier = Modifier.padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                            Button(
                                onClick = {
                                    if (txtField.value.isEmpty()) {
                                        txtFieldError.value = "Field can not be empty"
                                        return@Button
                                    }
                                    setValue(txtField.value)
                                    setShowDialog(false)
                                },
                                shape = RoundedCornerShape(50.dp),
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp)
                            ) {
                                Text(text = "Done")
                            }
                        }
                    }
                }
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetPackDemoTheme {
//        UserCard().ui()
        HomePage()
    }
  }
}


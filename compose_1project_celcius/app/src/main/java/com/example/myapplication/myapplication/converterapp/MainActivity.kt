package com.example.myapplication.myapplication.converterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewMainActivity()
        }
    }
}

// Texto hello

@Composable
fun Hello(name: String) {
    Text("Hello friend $name")
}

@Preview(showBackground = true)
@Composable
fun PreviewHello() {
    Column {
        Hello("Carlos")
        Hello("Nemo")
    }
}

// Texto 3 columnas

@Composable
fun ListTeamHello(names: List<String>) {
    for (name in names) {
        Text("Hello $name")
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListTeamHello(){
    Column {
        ListTeamHello(listOf("Zoro", "Shanks", "Luffy"))
    }
}

// Converter Celcius

@Composable
fun Header(image: Int, description: String) {
    Image(
        painter = painterResource(image),
        contentDescription = description,
        modifier = Modifier.height(180.dp).fillMaxWidth(),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TemperatureText(celsius: Int) {
    val fara = (celsius.toDouble()*9/5)+32
    Text("$celsius Celsius is $fara Fahrenhe it")
}

@Composable
fun ConvertButton(clicked: () -> Unit) {
    Button(onClick = clicked) {
        Text("Button Text")
    }
}

@Composable
fun ExampleTextField() {
    val text = remember{ mutableStateOf("") }
    TextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text("What is your name?") },
    )
}

@Composable
fun LabelAndPlaceHolder() {
    val text = remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        onValueChange = {
            text.value = it
        },
        label = { Text(text = "Your Label") },
        placeholder = { Text(text = "Your Placeholder/Hint") },
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainActivity() {
    val celsiusValue = remember { mutableStateOf(0) }
    Column {
        Header(R.drawable.sunrise, "image sunrise")
        ConvertButton { celsiusValue.value = 20 }
        TemperatureText(celsiusValue.value)
    }
}



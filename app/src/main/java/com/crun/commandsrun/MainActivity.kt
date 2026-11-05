package com.crun.commandsrun

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CrunApp()
        }
    }
}

@Composable
fun CrunApp() {
    var code by remember {
        mutableStateOf("print(\"Hello, Crun:C!\")")
    }

    var output by remember {
        mutableStateOf("Ready to run your code.")
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFF0D1117)
    ) {
        Column(Modifier.padding(18.dp)) {
            Text(
                "Crun:C",
                color = Color(0xFF3FB950),
                fontSize = 28.sp
            )

            Text("Commandsrun", color = Color.Gray)

            Spacer(Modifier.height(24.dp))

            Text("PYTHON", color = Color(0xFF3FB950))

            OutlinedTextField(
                value = code,
                onValueChange = { code = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(220.dp),
                textStyle = LocalTextStyle.current.copy(
                    color = Color.White,
                    fontSize = 15.sp
                )
            )

            Spacer(Modifier.height(14.dp))

            Button(
                onClick = {
                    output = "Execution server not connected yet."
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF238636)
                )
            ) {
                Text("▶ Run")
            }

            Spacer(Modifier.height(20.dp))

            Text("OUTPUT", color = Color(0xFF3FB950))

            Text(
                output,
                color = Color.LightGray,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color(0xFF161B22),
                        RoundedCornerShape(8.dp)
                    )
                    .padding(14.dp)
            )
        }
    }
}

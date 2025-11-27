package com.gromber05.examendin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import com.gromber05.examendin.ui.theme.ExamenDinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ExamenDinTheme(darkTheme = false ) {
                MainScreen(Modifier.background(Color(0xFFE8DD54)))
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MainScreen(modifier: Modifier = Modifier) {
        Scaffold(
            modifier = modifier,
            topBar = {
                TopAppBar(
                    title = {
                        Row() {
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    Icons.Filled.Search,
                                    contentDescription = "Icono de búsqueda",
                                )
                            }
                            IconButton(
                                onClick = {}
                            ) {
                                Icon(
                                    Icons.Filled.Star,
                                    contentDescription = "Icono de favorito",
                                )
                            }
                            Button(
                                onClick = {}
                            ) {
                                Text("Hamburguesa")
                            }
                        }
                    }
                )
            }
        ) { innerPadding ->
            var pantallaActual by rememberSaveable { mutableStateOf(0) }

            when (pantallaActual) {
                0 -> HomeScreen(
                    Modifier.padding(innerPadding),
                    onAgrupaciones = { pantallaActual = 1},
                    onDisfraces = { pantallaActual = 2},
                )
                1 -> AgrupacionesScreen(
                    Modifier.padding(innerPadding),
                    onBack = { pantallaActual = 0 }
                )
                2 -> DisfracesScreen(
                    Modifier.padding(innerPadding),
                    onBack = { pantallaActual = 0 }
                )
            }
        }
    }

    @Preview(
        showBackground = true,
    )
    @Composable
    fun Preview_MainScreen() {
        MainScreen()
    }
}


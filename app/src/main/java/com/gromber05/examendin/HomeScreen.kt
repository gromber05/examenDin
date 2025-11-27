package com.gromber05.examendin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gromber05.examendin.ui.theme.ExamenDinTheme

/*
    Esta página es la vista principal. Aquí se recoge el comportamiento principal de los botones que hacen posible la navegación
    dentro de la aplicación.
*/
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onAgrupaciones: () -> Unit,
    onDisfraces: () -> Unit) {
    ExamenDinTheme {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Carnaval Cádiz 2025",
                fontSize = 30.sp,
                color = Color(0xFF4CAF50)

            )

            Spacer(Modifier.padding(10.dp))

            Text(
                text = "Aplicación para informarte sobre el carnaval de cádiz del año 2025",
                fontSize = 14.sp,
                color = Color(0xFF4CAF50)
            )

            Spacer(Modifier.padding(20.dp))

            Image(
                painter = painterResource(R.drawable.carnaval1),
                contentDescription = "Foto del carnaval de cádiz"
            )

            Button(onClick = {
                onAgrupaciones()
            }) {
                Text(text = "Ver Agrupaciones")
            }


            Button(onClick = {
                onDisfraces()
            }) {
                Text(text = "Ver Disfraces")
            }
        }
    }
}
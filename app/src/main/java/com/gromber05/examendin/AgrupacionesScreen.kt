package com.gromber05.examendin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gromber05.examendin.domain.model.Agrupaciones
import com.gromber05.examendin.domain.model.AgrupacionesTypes

@Composable
fun AgrupacionesScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {

    val listaAgrupaciones = mutableListOf<Agrupaciones>(
        Agrupaciones("Los taquilleros", R.drawable.agrupacion1, AgrupacionesTypes.COMPARSA),
        Agrupaciones("No eres tú, soy yo (Los egocéntricos)", R.drawable.egocentricos, AgrupacionesTypes.CHIRIGOTA ),
        Agrupaciones("El gremio", R.drawable.elgremio, AgrupacionesTypes.CORO ),
        Agrupaciones("¡Que dolo de muñeca!", R.drawable.agrupacion1, AgrupacionesTypes.CUARTETO ),
        Agrupaciones("Agutin", R.drawable.elgremio, AgrupacionesTypes.ROMANCEROS ),
        Agrupaciones("Fran y el huerto", R.drawable.egocentricos, AgrupacionesTypes.PREGONEROS ),
    )

    Column(
        modifier = modifier.fillMaxSize()
            .background(Color(0xFFDBD9C4))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "AGRUPACIONES",
            fontSize = 30.sp,
            color = Color(0xFF4CAF50)
        )
        Spacer(Modifier.padding(10.dp))

        Button(
            onClick = {
                onBack()
            }
        ) { Text(text = "Volver a inicio") }
        Spacer(Modifier.padding(10.dp))

        LazyColumn() {
            items(listaAgrupaciones) { item ->
                AgrupacionItem(item.name, item.image, item.type)
                Spacer(Modifier.padding(10.dp))
            }
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgrupacionItem(name: String, image: Int, type: AgrupacionesTypes, modifier: Modifier = Modifier) {
    var dialog by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier =
            modifier.fillMaxWidth(),
        onClick = {
            dialog = true
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Foto de la agrupación ${name}",
                modifier = Modifier
                    .width(200.dp)
                    .height(150.dp)
            )

            Spacer(Modifier.padding(10.dp))

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name,
                    color = Color(0xFF6BDB24)
                )
                Text(
                    text = type.toString(),
                    color = Color(0xFF6BDB24)
                )
            }
        }

        if (dialog) {
            AlertDialog(
                onDismissRequest = { dialog = false },
                modifier = Modifier.clip(RoundedCornerShape(20.dp))
            ) {
                Column(
                    modifier = Modifier
                        .width(300.dp)
                        .background(Color(0xFFFFF5AF))
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(image),
                        contentDescription = "Foto de la agrupación $name",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(180.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )

                    Spacer(Modifier.padding(16.dp))

                    Text(
                        text = name,
                        color = Color(0xFF6BDB24)
                    )
                    Spacer(Modifier.padding(8.dp))
                    Text(
                        text = type.toString(),
                        color = Color(0xFF6BDB24)
                    )
                    Spacer(Modifier.padding(8.dp))
                    Button(
                        onClick = { dialog = false }
                    ) {
                        Text(text = "Cerrar")
                    }
                }
            }
        }

    }
}

@Preview(
    showBackground = true,
)
@Composable
fun Preview_AgruacionItem() {
    Agrupaciones("Los taquilleros", R.drawable.agrupacion1, AgrupacionesTypes.COMPARSA)
}


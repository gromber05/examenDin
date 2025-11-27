package com.gromber05.examendin

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gromber05.examendin.domain.model.Disfraces


@Composable
fun DisfracesScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    val listaDisfraces = listOf<Disfraces>(
        Disfraces("Disfraz1", R.drawable.disfraz1),
        Disfraces("Disfraz2", R.drawable.disfraz2),
        Disfraces("Disfraz3", R.drawable.disfraz1),
        Disfraces("Disfraz4", R.drawable.disfraz2),
        Disfraces("Disfraz5", R.drawable.disfraz1),
        Disfraces("Disfraz6", R.drawable.disfraz2),
        Disfraces("Disfraz7", R.drawable.disfraz1),
        Disfraces("Disfraz8", R.drawable.disfraz2),
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "DISFRACES",
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

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.padding(10.dp)
        ){
            items(listaDisfraces) { item ->
                DisfracesItem(item.name, item.image)
                Spacer(Modifier.padding(10.dp))
            }
        }
    }
}

@Composable
fun DisfracesItem(name: String, image: Int, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = "Foto del disfraz ${name}",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Text(
                text = name,
                color = Color(0xFF6BDB24)
            )
        }
    }
}
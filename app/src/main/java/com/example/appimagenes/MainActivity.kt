package com.example.appimagenes

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.appimagenes.ui.theme.AppimagenesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppimagenesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaImagen(modifier=Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun PantallaImagen (modifier: Modifier = Modifier) {
    val imagen_fondo = painterResource(R.drawable.img_fondo)
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    )
    {
                Image(
            imagen_fondo,
            contentDescription = "Imagen de fondo",
                    contentScale=ContentScale.Fit,
            modifier=Modifier.size(150.dp)
        )
        Text(text="Mis Tareas", color=Color.Red,modifier=Modifier.padding(horizontal = 25.dp))

        // Box: capas, el texto queda encima de la imagen
        Box(contentAlignment = Alignment.BottomStart) {
            Image(
                painter = painterResource(R.drawable.img_fondo),
                contentDescription = null,
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.Crop
            )
            Text("Sobre la imagen", color = Color.Red)
        }

        // Row: imagen y texto en horizontal
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(R.drawable.img_fondo),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Text("Al lado")
        }

        // Column: imagen y texto en vertical
        Column {
            Image(
                painter = painterResource(R.drawable.img_fondo),
                contentDescription = null,
                modifier = Modifier.size(60.dp)
            )
            Text("Debajo")
        }

        // Surface: forma circular y sombra
        Surface(
            shape = CircleShape,
            shadowElevation = 8.dp,
            modifier = Modifier.size(100.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.img_fondo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
    }



}


@Preview(showBackground = true)
@Composable
fun PantallaImagenPreview() {
    AppimagenesTheme {
        PantallaImagen()
    }
}
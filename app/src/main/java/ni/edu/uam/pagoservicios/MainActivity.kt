package ni.edu.uam.pagoservicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ni.edu.uam.pagoservicios.components.DetallePago
import ni.edu.uam.pagoservicios.components.ResumenPagoCard
import ni.edu.uam.pagoservicios.ui.theme.PagoServiciosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PagoServiciosTheme {
                // El Scaffold maneja los espacios de la pantalla (como la barra de estado)
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Definimos los datos del pago
                    val miPago = DetallePago(
                        servicio = "Matrícula UAM",
                        monto = "$150.00",
                        fecha = "15 de Abril, 2026"
                    )

                    // Mostramos el componente dentro de un contenedor con el padding del Scaffold
                    Column(modifier = Modifier.padding(innerPadding)) {
                        ResumenPagoCard(detalle = miPago)
                    }
                }
            }
        }
    }
}

// Preview para que puedas verlo en Android Studio sin ejecutar en el celular
@Preview(showBackground = true)
@Composable
fun ResumenPagoPreview() {
    PagoServiciosTheme {
        val pagoPrueba = DetallePago(
            servicio = "Servicio de Prueba",
            monto = "$0.00",
            fecha = "01/01/2026"
        )
        ResumenPagoCard(detalle = pagoPrueba)
    }
}
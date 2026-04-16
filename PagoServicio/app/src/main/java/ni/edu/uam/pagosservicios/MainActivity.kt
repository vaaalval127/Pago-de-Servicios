package ni.edu.uam.pagosservicios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import ni.edu.uam.pagosservicios.components.FormularioPago
import ni.edu.uam.pagosservicios.ui.theme.PagosServiciosTheme

class MainActivity : ComponentActivity() {
    // Inicializamos el ViewModel con la arquitectura de Android
    private val pagoViewModel: PagoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PagosServiciosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        // Inyectamos el ViewModel al componente visual
                        FormularioPago(viewModel = pagoViewModel)
                    }
                }
            }
        }
    }
}
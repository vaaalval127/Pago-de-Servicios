package ni.edu.uam.main
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí usamos el tema de tu proyecto
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainScreenApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenApp() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Pago de Servicios",
                        style = MaterialTheme.typography.headlineMedium
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            // SECCIÓN DE ERVIN (Formulario)
            item {
                Text(text = "Registrar Nuevo Pago", style = MaterialTheme.typography.titleLarge)

                // Aquí pegarás el código de Ervin después
                Card(modifier = Modifier.fillMaxWidth().height(150.dp)) {
                    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Text("Espacio para el formulario de Ervin")
                    }
                }
            }

            // SECCIÓN DE ANGELO (Historial)
            item {
                HorizontalDivider()
                Text(text = "Historial de Pagos", style = MaterialTheme.typography.titleLarge)
            }

            // Aquí es donde conectarás con los datos de Valeria
            val listaEjemplo = listOf("Agua - C$ 200", "Luz - C$ 500")

            items(listaEjemplo) { pago ->
                // Aquí pegarás la Card diseñada por Angelo después
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
                ) {
                    Text(text = pago, modifier = Modifier.padding(16.dp))
                }
            }
        }
    }
}
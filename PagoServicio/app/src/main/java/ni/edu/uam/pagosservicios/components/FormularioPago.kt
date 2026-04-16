package ni.edu.uam.pagosservicios.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormularioPago() {
    // Estados de los campos
    var servicioSeleccionado by remember { mutableStateOf("") }
    var monto by remember { mutableStateOf("") }
    var fechaSeleccionada by remember { mutableStateOf("") }

    // Estados para los Menús y Calendario
    var expandedDropdown by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }

    val datePickerState = rememberDatePickerState()
    val opcionesServicios = listOf("Agua", "Luz", "Internet", "Cable")

    // Lógica para formatear la fecha cuando se selecciona en el calendario
    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    val selectedDate = datePickerState.selectedDateMillis
                    if (selectedDate != null) {
                        val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                        fechaSeleccionada = formatter.format(Date(selectedDate))
                    }
                    showDatePicker = false
                }) { Text("OK") }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) { Text("Cancelar") }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // --- Selector de Servicio ---
        ExposedDropdownMenuBox(
            expanded = expandedDropdown,
            onExpandedChange = { expandedDropdown = !expandedDropdown }
        ) {
            OutlinedTextField(
                value = servicioSeleccionado,
                onValueChange = {},
                readOnly = true,
                label = { Text("Selecciona Servicio") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDropdown) },
                modifier = Modifier.menuAnchor().fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expandedDropdown,
                onDismissRequest = { expandedDropdown = false }
            ) {
                opcionesServicios.forEach { opcion ->
                    DropdownMenuItem(
                        text = { Text(opcion) },
                        onClick = {
                            servicioSeleccionado = opcion
                            expandedDropdown = false
                        }
                    )
                }
            }
        }

        // --- Campo de Monto ---
        OutlinedTextField(
            value = monto,
            onValueChange = { monto = it },
            label = { Text("Monto") },
            prefix = { Text("$ ") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        //Ervin
        // --- Campo de Fecha (Activa el Calendario) ---
        OutlinedTextField(
            value = fechaSeleccionada,
            onValueChange = { },
            readOnly = true, // Para que no puedan escribir, solo seleccionar del calendario
            label = { Text("Fecha de Pago") },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Abrir Calendario"
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showDatePicker = true },
            enabled = false, // Lo desactivamos para que el click lo detecte el modificador clickable
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = MaterialTheme.colorScheme.onSurface,
                disabledBorderColor = MaterialTheme.colorScheme.outline,
                disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                disabledTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        // --- Botón de Validación ---
        Button(
            onClick = { /* Acción de pago */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = servicioSeleccionado.isNotEmpty() && monto.isNotEmpty() && fechaSeleccionada.isNotEmpty()
        ) {
            Text("Procesar Pago")
        }
    }
}
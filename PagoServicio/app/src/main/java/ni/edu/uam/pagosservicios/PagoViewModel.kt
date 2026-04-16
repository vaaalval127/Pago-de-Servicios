package ni.edu.uam.pagosservicios

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class PagoViewModel : ViewModel() {

    // Estado observable por la UI
    var uiState by mutableStateOf(PagoUiState())
        private set

    // Función para registrar un pago
    fun registrarPago(servicio: String, montoStr: String, fecha: String) {
        // 1. Validaciones básicas
        val monto = montoStr.toDoubleOrNull()

        if (servicio.isNotBlank() && monto != null && fecha.isNotBlank()) {
            val nuevoPago = PagoServicio(
                id = uiState.listaPagos.size + 1,
                servicio = servicio,
                monto = monto,
                fecha = fecha
            )

            // 2. Actualizar el estado
            uiState = uiState.copy(
                listaPagos = uiState.listaPagos + nuevoPago,
                ultimoPagoRegistrado = nuevoPago,
                mensajeConfirmacion = "¡Pago de $servicio registrado con éxito!"
            )
        }
    }

    // Función para limpiar el mensaje después de mostrarlo
    fun resetMensaje() {
        uiState = uiState.copy(mensajeConfirmacion = "")
    }
}
package ni.edu.uam.pagosservicios

data class PagoUiState(
    val listaPagos: List<PagoServicio> = emptyList(),
    val ultimoPagoRegistrado: PagoServicio? = null,
    val mensajeConfirmacion: String = "",
    val hayError: Boolean = false
)
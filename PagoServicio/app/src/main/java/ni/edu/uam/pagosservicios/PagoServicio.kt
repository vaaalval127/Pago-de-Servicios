package ni.edu.uam.pagosservicios

// Modelo de datos para representar un pago
data class PagoServicio(
    val id: Int,
    val servicio: String,
    val monto: Double,
    val fecha: String
)
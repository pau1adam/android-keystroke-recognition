package gr.padam.keyrec

data class KeyPress(
        val maxPressure: Float = -1f,
        val maxSize: Float = -1f,
        val pressDuration: Long = -1L,
        val startTime: Long = -1L,
        val endTime: Long = -1L,
        val key: String = "NO KEY"
)

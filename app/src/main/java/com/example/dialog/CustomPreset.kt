package com.example.dialog


class CustomPreset(
    val backgroundColor: Int = android.R.color.white,
    val backgroundBorderColor: Int = android.R.color.darker_gray,
    val textTitleSize: Float = 18f,
    val textDescriptionSize: Float = 14f,
    val textColor: Int = android.R.color.black
) {
    fun copy(
        backgroundColor: Int = this.backgroundColor,
        backgroundBorderColor: Int = this.backgroundBorderColor,
        textTitleSize: Float = this.textTitleSize,
        textDescriptionSize: Float = this.textDescriptionSize,
        textColor: Int = this.textColor,

    ) = CustomPreset(
        backgroundColor,
        backgroundBorderColor,
        textTitleSize,
        textDescriptionSize,
        textColor
    )
}
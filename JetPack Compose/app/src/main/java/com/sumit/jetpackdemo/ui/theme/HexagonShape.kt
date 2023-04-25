package com.sumit.jetpackdemo.ui.theme

import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.min
import kotlin.math.sqrt

class HexagonShape : Shape {

    override fun createOutline(
        size: androidx.compose.ui.geometry.Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            path = drawCustomHexagonPath(size)
        )

    }

    fun drawCustomHexagonPath(size: androidx.compose.ui.geometry.Size): Path {
        return Path().apply {
            val radius = min(size.width / 2f, size.height / 2f)
            customHexagon(radius, size)
        }
    }

    fun Path.customHexagon(radius: Float, size: androidx.compose.ui.geometry.Size) {
        val triangleHeight = (sqrt(3.0) * radius / 2)
        val centerX = size.width / 2
        val centerY = size.height / 2

        moveTo(centerX, centerY + radius)
        lineTo((centerX - triangleHeight).toFloat(), centerY + radius / 2)
        lineTo((centerX - triangleHeight).toFloat(), centerY - radius / 2)
        lineTo(centerX, centerY - radius)
        lineTo((centerX + triangleHeight).toFloat(), centerY - radius / 2)
        lineTo((centerX + triangleHeight).toFloat(), centerY + radius / 2)
        close()
    }
}
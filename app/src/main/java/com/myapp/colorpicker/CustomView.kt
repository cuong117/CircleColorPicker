package com.myapp.colorpicker

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.ComposeShader
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.RadialGradient
import android.graphics.Shader
import android.graphics.SweepGradient
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class CustomView(context: Context, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint()
    private var radius = 0f

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawCircle(
            measuredWidth / 2f,
            measuredHeight / 2f,
            radius,
            paint
        )
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        radius = min(w / 2f, h / 2f)
        val sweepGradient = SweepGradient(
            w / 2f,
            h / 2f,
            intArrayOf(
                context.getColor(R.color.color_FF0000),
                context.getColor(R.color.color_FF8A00),
                context.getColor(R.color.color_FFE600),
                context.getColor(R.color.color_14FF00),
                context.getColor(R.color.color_00A3FF),
                context.getColor(R.color.color_0500FF),
                context.getColor(R.color.color_AD00FF),
                context.getColor(R.color.color_FF00C7),
                context.getColor(R.color.color_FF0000),
            ),
            null
        )
        val radialGradient = RadialGradient(
            w / 2f,
            h / 2f,
            radius,
            Color.TRANSPARENT,
            Color.WHITE,
            Shader.TileMode.CLAMP
        )
        paint.shader = ComposeShader(
            sweepGradient, radialGradient, PorterDuff.Mode.MULTIPLY
        )
    }
}

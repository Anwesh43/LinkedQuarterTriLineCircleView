package com.anwesh.uiprojects.quartertrilinecircleview

/**
 * Created by anweshmishra on 23/02/19.
 */

import android.view.View
import android.view.MotionEvent
import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Color
import android.graphics.RectF

val nodes : Int = 5
val lines : Int = 3
val scGap : Float = 0.05f
val scDiv : Double = 0.51
val sizeFactor : Float = 2.9f
val strokeFactor : Int = 90
val foreColor : Int = Color.parseColor("#4CAF50")
val backColor : Int = Color.parseColor("#212121")

fun Int.inverse() : Float = 1f / this
fun Float.maxScale(i : Int, n : Int) : Float = Math.max(0f, this - i * n.inverse()).toFloat()
fun Float.divideScale(i : Int, n : Int) : Float = Math.min(n.inverse(), maxScale(i, n)) * n
fun Float.scaleFactor() : Float = Math.floor(this / scDiv).toFloat()
fun Float.mirrorValue(a : Int, b : Int) : Float = (1 - scaleFactor()) * a.inverse() + scaleFactor() * b.inverse()
fun Float.updateValue(dir : Float, a : Int, b : Int) : Float = mirrorValue(a, b) * dir * scGap

fun Canvas.drawQTLCNode(i : Int, scale : Float, paint : Paint) {
    val w : Float = width.toFloat()
    val h : Float = height.toFloat()
    val gap : Float = h / (nodes + 1)
    val size : Float = gap / sizeFactor
    val sc1 : Float = scale.divideScale(0, 2)
    val sc2 : Float = scale.divideScale(1, 2)
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = Math.min(w, h) / strokeFactor
    paint.color = foreColor
    paint.strokeCap = Paint.Cap.ROUND
    save()
    translate(w / 2, gap * (i + 1))
    rotate(90f * sc2)
    drawArc(RectF(-size, -size, size, size), -90f, 90f, true, paint)
    var deg : Float = 0f
    val gapDeg : Float = 90f / lines
    for (j in 0..(lines - 1)) {
        deg += gapDeg * sc1
        save()
        rotate(-deg)
        drawLine(0f, 0f, size, 0f, paint)
        restore()
    }
    restore()
}

class QuarterTriLineCircleView(ctx : Context) : View(ctx) {

    private val paint : Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    override fun onDraw(canvas : Canvas) {

    }

    override fun onTouchEvent(event : MotionEvent) : Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {

            }
        }
        return true
    }
}
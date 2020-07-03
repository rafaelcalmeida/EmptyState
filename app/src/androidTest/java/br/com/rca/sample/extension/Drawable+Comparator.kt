package br.com.rca.sample.extension

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.core.graphics.drawable.DrawableCompat
import java.util.*

/**
 * Created by Rafael C. Almeida on 27/06/20.
 */

// region Public Methods

fun Drawable.compare(other: Drawable): Boolean {
    val a: Bitmap = getBitmap()
    val b: Bitmap = other.getBitmap()

    return pixelsEqualTo(a, b)
}

// endregion

// region Private Methods

private fun getPixels(bitmap: Bitmap): IntArray? {
    val pixels = IntArray(bitmap.width * bitmap.height)
    bitmap.getPixels(pixels, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
    return pixels
}

private fun Drawable.getBitmap(): Bitmap {
    var drawable = this
    if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        drawable = DrawableCompat.wrap(drawable).mutate()
    }
    val bitmap = Bitmap.createBitmap(
        drawable.intrinsicWidth,
        drawable.intrinsicHeight,
        Bitmap.Config.ARGB_8888
    )
    val canvas = Canvas(bitmap)
    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
    drawable.draw(canvas)

    return bitmap
}

private fun pixelsEqualTo(bitmap: Bitmap, other: Bitmap): Boolean {
    return if (bitmap.width == other.width && bitmap.height == other.height) {
        Arrays.equals(
            getPixels(bitmap),
            getPixels(other)
        )
    } else false
}

// endregion
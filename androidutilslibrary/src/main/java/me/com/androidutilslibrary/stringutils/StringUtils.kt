package me.com.androidutilslibrary.colorutils

import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.widget.TextView
import java.util.concurrent.atomic.AtomicBoolean


object StringUtils {
    fun justify(textView: TextView) {
        val isJustify = AtomicBoolean(false)
        val textString = textView.text.toString()
        val textPaint = textView.paint
        val builder = SpannableStringBuilder()
        textView.post {
            if (!isJustify.get()) {
                val lineCount = textView.lineCount
                val textViewWidth = textView.width
                for (i in 0 until lineCount) {
                    val lineStart = textView.layout.getLineStart(i)
                    val lineEnd = textView.layout.getLineEnd(i)
                    val lineString = textString.substring(lineStart, lineEnd)
                    if (i == lineCount - 1) {
                        builder.append(SpannableString(lineString))
                        break
                    }
                    val trimSpaceText = lineString.trim { it <= ' ' }
                    val removeSpaceText = lineString.replace(" ".toRegex(), "")
                    val removeSpaceWidth = textPaint.measureText(removeSpaceText)
                    val spaceCount = trimSpaceText.length - removeSpaceText.length.toFloat()
                    val eachSpaceWidth = (textViewWidth - removeSpaceWidth) / spaceCount
                    val spannableString = SpannableString(lineString)
                    for (j in trimSpaceText.indices) {
                        val c = trimSpaceText[j]
                        if (c == ' ') {
                            val drawable: Drawable = ColorDrawable(0x00ffffff)
                            drawable.setBounds(0, 0, eachSpaceWidth.toInt(), 0)
                            val span = ImageSpan(drawable)
                            spannableString.setSpan(span, j, j + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
                        }
                    }
                    builder.append(spannableString)
                }
                textView.text = builder
                isJustify.set(true)
            }
        }
    }

    fun toTitleCase(str: String): String {
        var space = true
        val builder = StringBuilder(str)
        val len = builder.length
        for (i in 0 until len) {
            val c = builder[i]
            if (space) {
                if (!Character.isWhitespace(c)) {
                    // Convert to title case and switch out of whitespace mode.
                    builder.setCharAt(i, Character.toTitleCase(c))
                    space = false
                }
            } else if (Character.isWhitespace(c)) {
                space = true
            } else {
                builder.setCharAt(i, Character.toLowerCase(c))
            }
        }
        return builder.toString()
    }

    /**
     * Colorize a specific substring in a string for TextView. Use it like this: <pre>
     * textView.setText(
     * Strings.colorized("The some words are black some are the default.","black", Color.BLACK),
     * TextView.BufferType.SPANNABLE
     * );
    </pre> *
     *
     * @param text Text that contains a substring to colorize
     * @param word The substring to colorize
     * @param argb The color
     * @return the Spannable for TextView's consumption
     */
    fun colorized(text: String, word: String, argb: Int): Spannable {
        val spannable: Spannable = SpannableString(text)
        var substringStart = 0
        var start: Int
        while (text.indexOf(word, substringStart).also { start = it } >= 0) {
            spannable.setSpan(
                    ForegroundColorSpan(argb), start, start + word.length,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            substringStart = start + word.length
        }
        return spannable
    }
}
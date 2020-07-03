package br.com.rca.emptystate.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.widget.LinearLayout
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import br.com.rca.emptystate.R
import kotlinx.android.synthetic.main.empty_view.view.*

/**
 * Created by Rafael C. Almeida on 2020-04-07.
 */
class EmptyView : LinearLayout {

    // region Public Variables

    var actionHandler: (() -> Unit)? = null

    var title: String? = null
        set(value) {
            field = value
            titleTextView?.text = field
            titleTextView?.isVisible = field?.isNotEmpty() ?: false
        }

    var message: String? = null
        set(value) {
            field = value
            messageTextView?.text = field
            messageTextView?.isVisible = field?.isNotEmpty() ?: false
        }

    var labelButton: String? = null
        set(value) {
            field = value
            actionButton?.text = field
            actionButton?.isVisible = field?.isNotEmpty() ?: false
        }

    @ColorInt
    var imageColor: Int? = null
        set(value) {
            field = value
            field?.let {
                imageView?.setColorFilter(it)
            } ?: run {
                imageView?.colorFilter = null
            }
        }

    // endregion

    // region Private Variables

    private val actionOnClickListener = OnClickListener {
        actionHandler?.invoke()
    }

    // endregion

    // region Constructors

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        init()
    }

    // endregion

    // region Public Methods

    fun setTitleRes(@StringRes resId: Int) {
        title = context.getString(resId)
    }

    fun setMessageRes(@StringRes resId: Int) {
        message = context.getString(resId)
    }

    fun setLabelButtonRes(@StringRes resId: Int) {
        labelButton = context.getString(resId)
    }

    fun setImageRes(@DrawableRes resId: Int?) {
        resId?.let {
            imageView?.setImageResource(it)
            imageView?.visibility = VISIBLE
        } ?: run {
            imageView?.setImageDrawable(null)
            imageView?.visibility = GONE
        }
    }

    fun setImageColorRes(@ColorRes resId: Int?) {
        imageColor = resId?.let { ContextCompat.getColor(context, it) }
    }

    // endregion

    // region Private Methods

    private fun init() {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.empty_view, this)

        setupListeners()
    }

    private fun setupListeners() {
        actionButton?.setOnClickListener(actionOnClickListener)
    }

    // endregion
}
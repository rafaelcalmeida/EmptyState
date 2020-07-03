package br.com.rca.emptystate.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.widget.LinearLayout
import br.com.rca.emptystate.R
import kotlinx.android.synthetic.main.empty_view.view.*

/**
 * Created by Rafael C. Almeida on 2020-04-07.
 */
class EmptyView : LinearLayout {

    // region Public Variables

    var actionHandler: (() -> Unit)? = null

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
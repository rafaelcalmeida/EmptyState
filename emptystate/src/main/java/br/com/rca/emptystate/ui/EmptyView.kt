package br.com.rca.emptystate.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import br.com.rca.emptystate.R

/**
 * Created by Rafael C. Almeida on 2020-04-07.
 */
class EmptyView : LinearLayout {

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
    }

    // endregion
}
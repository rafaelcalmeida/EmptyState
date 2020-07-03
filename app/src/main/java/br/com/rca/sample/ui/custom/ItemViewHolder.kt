package br.com.rca.sample.ui.custom

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.rca.sample.R
import br.com.rca.sample.model.SimpleMenuItem

/**
 * Created by Rafael C. Almeida on 2020-04-06.
 */
class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    // region Public Variables

    var menuItem: SimpleMenuItem? = null
        set(value) {
            field = value
            updateUI()
        }

    // endregion

    // region Private Views

    private var titleTextView: TextView = itemView.findViewById(R.id.title_text_view)
    private var subtitleTextView: TextView = itemView.findViewById(R.id.subtitle_text_view)

    // endregion

    // region Constructors

    init {
        setupListeners()
    }

    // endregion

    // region Private Methods

    private fun updateUI() {
        titleTextView.text = menuItem?.title
        subtitleTextView.text = menuItem?.subtitle
    }

    private fun setupListeners() {
        itemView.setOnClickListener {
            menuItem?.actionHandler?.invoke()
        }
    }

    // endregion
}
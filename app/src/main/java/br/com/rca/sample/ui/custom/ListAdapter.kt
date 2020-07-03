package br.com.rca.sample.ui.custom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rca.sample.R
import br.com.rca.sample.model.SimpleMenuItem

/**
 * Created by Rafael C. Almeida on 2020-04-06.
 */
class ListAdapter(private val items: List<SimpleMenuItem>): RecyclerView.Adapter<ItemViewHolder>() {

    // region Inner Methods

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_view_holder, parent, false)

        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.menuItem = items[position]
    }

    // endregion
}

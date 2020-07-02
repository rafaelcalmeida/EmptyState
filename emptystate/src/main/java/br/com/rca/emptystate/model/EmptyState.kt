package br.com.rca.emptystate.model

import androidx.annotation.StringRes

/**
 * Created by Rafael C. Almeida on 2020-04-07.
 */
class EmptyState {

    // region Public Variables

    var title: String? = null
        set(value) {
            titleRes?.let {
                titleRes = null
            }
            field = value
        }

    @StringRes
    var titleRes: Int? = null
        set(value) {
            title?.let {
                title = null
            }
            field = value
        }
    
    // endregion
}

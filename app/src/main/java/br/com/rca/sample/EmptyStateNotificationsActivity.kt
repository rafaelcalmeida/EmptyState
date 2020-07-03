package br.com.rca.sample

import android.os.Bundle
import android.view.View
import br.com.rca.emptystate.model.EmptyState
import kotlinx.android.synthetic.main.activity_empty_state.*
import kotlinx.android.synthetic.main.widget_toolbar_inverse.*

/**
 * Created by Rafael C. Almeida on 14/04/20.
 */
class EmptyStateNotificationsActivity : BaseActivity() {

    // region Private Variables

    private val emptyState: EmptyState by lazy {
        val emptyState = EmptyState()
        emptyState.imageRes = R.drawable.ic_notification
        emptyState.title = "Notifications."
        emptyState.message = "We'll let you know when get news for you."

        emptyState
    }

    private var isLoading: Boolean = true
        set(value) {
            field = value
            if (value) {
                progressBar?.visibility = View.VISIBLE
                emptyView?.visibility = View.GONE
            } else {
                progressBar?.visibility = View.GONE
                emptyView?.visibility = View.VISIBLE
            }
        }

    // endregion

    // region Life Cycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty_state)

        setupUI()
    }

    // endregion

    // region Private Methods

    private fun setupUI() {
        setSupportActionBar(toolbar);
        title = "EmptyState"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        emptyView?.emptyState = emptyState
        isLoading = false
    }

    // endregion
}
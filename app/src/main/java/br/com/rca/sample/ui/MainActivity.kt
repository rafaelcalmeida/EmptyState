package br.com.rca.sample.ui

import android.content.Intent
import android.os.Bundle
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.rca.sample.R
import br.com.rca.sample.model.SimpleMenuItem
import br.com.rca.sample.ui.custom.BaseActivity
import br.com.rca.sample.ui.custom.ListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.widget_toolbar_inverse.*

class MainActivity : BaseActivity() {

    // region Private Variables

    private val adapter: ListAdapter by lazy {
        val items = listOf(
            menuItemEmptyConnection,
            menuItemEmptyGeneric,
            menuItemEmptySearch,
            menuItemEmptyNotifications
        )
        ListAdapter(items)
    }

    private val menuItemEmptyConnection: SimpleMenuItem by lazy {
        SimpleMenuItem(
            "Connection error",
            "Image - Title - Message - Button"
        ) {
            start(Intent(this, EmptyStateConnectionErrorActivity::class.java))
        }
    }

    private val menuItemEmptyGeneric: SimpleMenuItem by lazy {
        SimpleMenuItem(
            "Internal server error",
            "Image - Title - Message - Button"
        ) {
            start(Intent(this, EmptyStateGenericErrorActivity::class.java))
        }
    }

    private val menuItemEmptySearch: SimpleMenuItem by lazy {
        SimpleMenuItem(
            "No search results found",
            "Image - Title - Message"
        ) {
            start(Intent(this, EmptyStateSearchActivity::class.java))
        }
    }

    private val menuItemEmptyNotifications: SimpleMenuItem by lazy {
        SimpleMenuItem(
            "Notifications",
            "Image - Title - Message"
        ) {
            start(Intent(this, EmptyStateNotificationsActivity::class.java))
        }
    }

    // endregion

    // region Inner Methods

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    // endregion

    // region Private Methods

    private fun setupUI() {
        setSupportActionBar(toolbar);
        title = getString(R.string.examples)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }

    private fun start(intent: Intent) {
        val options = ActivityOptionsCompat.makeCustomAnimation(
            this,
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        ContextCompat.startActivity(this, intent, options.toBundle())
    }

    // endregion
}

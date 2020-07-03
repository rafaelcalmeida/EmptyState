package br.com.rca.sample

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import br.com.rca.emptystate.model.EmptyState
import br.com.rca.emptystate.ui.EmptyView
import br.com.rca.sample.extension.compare
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith

/**
 * Created by Rafael C. Almeida on 13/04/20.
 */
@RunWith(AndroidJUnit4::class)
class EmptyViewTest {

    // region Public Variables

    @get:Rule
    var instantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    var activityRule: ActivityTestRule<EmptyStateSearchActivity> =
        ActivityTestRule(EmptyStateSearchActivity::class.java)

    // endregion

    // region Private Views

    private var emptyView: EmptyView? = null

    // endregion

    // region Private Variables

    private var context: Context? = null
    private var actionCalled: Boolean = false

    // endregion

    // region Public Methods

    @Before
    fun setup() {
        restartActivity()

        context = activityRule.activity
        emptyView = activityRule.activity.findViewById(R.id.emptyView)
    }

    @After
    fun tearDown() {
        emptyView = null
        context = null
        actionCalled = false
    }

    @Test
    fun testeEmptyStateNull() {
        emptyView?.test?.setupEmptyState(null)

        assertNull(emptyView?.emptyState)
        assertEquals(GONE, emptyView?.visibility)
    }

    @Test
    fun testeEmptyStateCorrespondeAoConfigurado() {
        val emptyState = EmptyState()
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(emptyState, emptyView?.emptyState)
        assertEquals(VISIBLE, emptyView?.visibility)
    }

    // endregion

    // region Private Methods

    private fun restartActivity() {
        activityRule.activity?.finish()
        activityRule.launchActivity(Intent())
    }

    private fun assertEstadoInicialEmptyView() {
        assertNotNull(emptyView)
        assertEquals(VISIBLE, emptyView?.test?.titleTextView?.visibility)
        assertEquals("", emptyView?.test?.titleTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.messageTextView?.visibility)
        assertEquals("", emptyView?.test?.messageTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.actionButton?.visibility)
        assertEquals("", emptyView?.test?.actionButton?.text)
        assertEquals(VISIBLE, emptyView?.test?.emptyImageView?.visibility)
        assertNull(emptyView?.test?.emptyImageView?.drawable)
    }

    // endregion

}
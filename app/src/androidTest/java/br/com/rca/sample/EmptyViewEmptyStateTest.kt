package br.com.rca.sample

import android.content.Context
import android.content.Intent
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import br.com.rca.emptystate.model.EmptyState
import br.com.rca.emptystate.ui.EmptyView
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith

/**
 * Created by Rafael C. Almeida on 13/04/20.
 */
@RunWith(AndroidJUnit4::class)
class EmptyViewEmptyStateTest {

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
    private var emptyState: EmptyState? = null

    // endregion

    // region Public Methods

    @Before
    fun setup() {
        restartActivity()

        context = activityRule.activity
        emptyView = activityRule.activity.findViewById(R.id.emptyView)

        actionCalled = false
        emptyState = EmptyState()
        emptyState?.title = "Title"
        emptyState?.message = "Message"
        emptyState?.imageRes = R.drawable.ic_search
        emptyState?.labelButton = "Label Button"
    }

    @After
    fun tearDown() {
        actionCalled = false
        emptyView = null
        context = null
        emptyState = null
    }

    @Test
    fun testeTitleValorNull() {
        emptyState?.title = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNull(emptyView?.title)
        assertEquals("", emptyView?.test?.titleTextView?.text)
        assertEquals(GONE, emptyView?.test?.titleTextView?.visibility)
    }

    @Test
    fun testeTitleValorVazio() {
        emptyState?.title = ""
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals("", emptyView?.title)
        assertEquals("", emptyView?.test?.titleTextView?.text)
        assertEquals(GONE, emptyView?.test?.titleTextView?.visibility)
    }

    @Test
    fun testeTitleConfiguradoCorretamente() {
        val title = "Title teste"
        emptyState?.title = title
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(title, emptyView?.title)
        assertEquals(title, emptyView?.test?.titleTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.titleTextView?.visibility)
    }

    @Test
    fun testeTitleResValorNull() {
        emptyState?.titleRes = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNull(emptyView?.title)
        assertEquals("", emptyView?.test?.titleTextView?.text)
        assertEquals(GONE, emptyView?.test?.titleTextView?.visibility)
    }

    @Test
    fun testeTitleResConfiguradoCorretamente() {
        val titleRes = R.string.lorem_ipsum_medium
        emptyState?.titleRes = titleRes
        emptyView?.test?.setupEmptyState(emptyState)

        val title = context?.getString(titleRes)
        assertEquals(title, emptyView?.title)
        assertEquals(title, emptyView?.test?.titleTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.titleTextView?.visibility)
    }

    // endregion

    // region Private Methods

    private fun restartActivity() {
        activityRule.activity?.finish()
        activityRule.launchActivity(Intent())
    }

    // endregion
}
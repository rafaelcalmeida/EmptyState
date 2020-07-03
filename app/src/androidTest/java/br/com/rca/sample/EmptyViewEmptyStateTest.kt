package br.com.rca.sample

import android.content.Context
import android.content.Intent
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.core.content.ContextCompat
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

    @Test
    fun testeMessageValorNull() {
        emptyState?.message = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNull(emptyView?.message)
        assertEquals("", emptyView?.test?.messageTextView?.text)
        assertEquals(GONE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeMessageValorVazio() {
        emptyState?.message = ""
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals("", emptyView?.message)
        assertEquals("", emptyView?.test?.messageTextView?.text)
        assertEquals(GONE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeMessageConfiguradoCorretamente() {
        val message = "Message teste"
        emptyState?.message = message
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(message, emptyView?.message)
        assertEquals(message, emptyView?.test?.messageTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeMessageResValorNull() {
        emptyState?.messageRes = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNull(emptyView?.message)
        assertEquals("", emptyView?.test?.messageTextView?.text)
        assertEquals(GONE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeMessageResConfiguradoCorretamente() {
        val messageRes = R.string.lorem_ipsum_medium
        emptyState?.messageRes = messageRes
        emptyView?.test?.setupEmptyState(emptyState)

        val message = context?.getString(messageRes)
        assertEquals(message, emptyView?.message)
        assertEquals(message, emptyView?.test?.messageTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeLabelButtonValorNull() {
        emptyState?.labelButton = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNull(emptyView?.labelButton)
        assertEquals("", emptyView?.test?.actionButton?.text)
        assertEquals(GONE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeLabelButtonValorVazio() {
        emptyState?.labelButton = ""
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals("", emptyView?.labelButton)
        assertEquals("", emptyView?.test?.actionButton?.text)
        assertEquals(GONE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeLabelButtonConfiguradoCorretamente() {
        val label = "Label teste"
        emptyState?.labelButton = label
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(label, emptyView?.labelButton)
        assertEquals(label, emptyView?.test?.actionButton?.text)
        assertEquals(VISIBLE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeLabelButtonResValorNull() {
        emptyState?.labelButtonRes = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNull(emptyView?.labelButton)
        assertEquals("", emptyView?.test?.actionButton?.text)
        assertEquals(GONE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeLabelButtonResConfiguradoCorretamente() {
        val labelRes = R.string.lorem_ipsum_medium
        emptyState?.labelButtonRes = labelRes
        emptyView?.test?.setupEmptyState(emptyState)

        val label = context?.getString(labelRes)
        assertEquals(label, emptyView?.labelButton)
        assertEquals(label, emptyView?.test?.actionButton?.text)
        assertEquals(VISIBLE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeImageResValorNull() {
        emptyState?.imageRes = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNull(emptyView?.test?.emptyImageView?.drawable)
        assertEquals(GONE, emptyView?.test?.emptyImageView?.visibility)
    }

    @Test
    fun testeDrawableDaImagemCorrespondeAImageResConfigurada() {
        val resId = R.drawable.ic_search
        val drawable = ContextCompat.getDrawable(context!!, resId)?.mutate()

        emptyState?.imageRes = resId
        emptyState?.imageColor = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNotNull(drawable)
        assertNotNull(emptyView?.test?.emptyImageView?.drawable)
        assertTrue(drawable!!.compare(emptyView!!.test.emptyImageView.drawable))
    }

    // endregion

    // region Private Methods

    private fun restartActivity() {
        activityRule.activity?.finish()
        activityRule.launchActivity(Intent())
    }

    // endregion
}
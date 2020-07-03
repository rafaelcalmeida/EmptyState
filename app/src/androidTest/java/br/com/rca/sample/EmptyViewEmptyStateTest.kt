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
import br.com.rca.sample.ui.EmptyStateSearchActivity
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

    @Test
    fun testeImageColorConfiguradaValorNull() {
        emptyState?.imageRes = R.drawable.ic_search
        emptyState?.imageColor = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNotNull(emptyView?.test?.emptyImageView?.drawable)
        assertNull(emptyView?.test?.emptyImageView?.colorFilter)
    }

    @Test
    fun testeImageColorConfiguradaCorretamente() {
        val color = Color.GREEN

        emptyState?.imageRes = R.drawable.ic_search
        emptyState?.imageColor = color
        emptyView?.test?.setupEmptyState(emptyState)

        assertNotNull(emptyView?.test?.emptyImageView?.drawable)
        assertNotNull(emptyView?.test?.emptyImageView?.colorFilter)
        assertTrue(
            emptyView?.test?.emptyImageView?.colorFilter == PorterDuffColorFilter(
                color,
                PorterDuff.Mode.SRC_ATOP
            )
        )
    }

    @Test
    fun testeImageColorResConfiguradaValorNull() {
        emptyState?.imageRes = R.drawable.ic_search
        emptyState?.imageColorRes = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertNotNull(emptyView?.test?.emptyImageView?.drawable)
        assertNull(emptyView?.test?.emptyImageView?.colorFilter)
    }

    @Test
    fun testeImageColorResConfiguradaCorretamente() {
        val colorRes = R.color.colorPrimary

        emptyState?.imageRes = R.drawable.ic_search
        emptyState?.imageColorRes = colorRes
        emptyView?.test?.setupEmptyState(emptyState)

        val drawable = DrawableCompat.wrap(
            ContextCompat.getDrawable(
                context!!,
                R.drawable.ic_search
            )?.mutate()!!
        )
        DrawableCompat.setTint(drawable, ContextCompat.getColor(context!!, colorRes))

        assertNotNull(emptyView?.test?.emptyImageView?.drawable)
        assertNotNull(emptyView?.test?.emptyImageView?.colorFilter)
        assertTrue(drawable.compare(emptyView!!.test.emptyImageView.drawable))
    }

    @Test
    fun testeTitleColorConfiguradoValorNull() {
        val color = emptyView?.test?.titleTextView?.currentTextColor

        emptyState?.title = "Title"
        emptyState?.titleColor = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(color, emptyView?.test?.titleTextView?.currentTextColor)
    }

    @Test
    fun testeTitleColorConfiguradaCorretamente() {
        val color = Color.GREEN

        emptyState?.title = "Title"
        emptyState?.titleColor = color
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(color, emptyView?.test?.titleTextView?.currentTextColor)
    }

    @Test
    fun testeTitleColorResConfiguradoValorNull() {
        val color = emptyView?.test?.titleTextView?.currentTextColor

        emptyState?.title = "Title"
        emptyState?.titleColorRes = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(color, emptyView?.test?.titleTextView?.currentTextColor)
    }

    @Test
    fun testeTitleColorResConfiguradaCorretamente() {
        val colorRes = android.R.color.holo_red_dark

        emptyState?.title = "Title"
        emptyState?.titleColorRes = colorRes
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(
            ContextCompat.getColor(context!!, colorRes),
            emptyView?.test?.titleTextView?.currentTextColor
        )
    }

    @Test
    fun testeMessageColorConfiguradoValorNull() {
        val color = emptyView?.test?.messageTextView?.currentTextColor

        emptyState?.message = "Message"
        emptyState?.messageColor = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(color, emptyView?.test?.messageTextView?.currentTextColor)
    }

    @Test
    fun testeMessageColorConfiguradaCorretamente() {
        val color = Color.GREEN

        emptyState?.message = "Message"
        emptyState?.messageColor = color
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(color, emptyView?.test?.messageTextView?.currentTextColor)
    }

    @Test
    fun testeMessageColorResConfiguradoValorNull() {
        val color = emptyView?.test?.messageTextView?.currentTextColor

        emptyState?.message = "Message"
        emptyState?.messageColorRes = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(color, emptyView?.test?.messageTextView?.currentTextColor)
    }

    @Test
    fun testeMessageColorResConfiguradaCorretamente() {
        val colorRes = android.R.color.holo_red_dark

        emptyState?.message = "Message"
        emptyState?.messageColorRes = colorRes
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(
            ContextCompat.getColor(context!!, colorRes),
            emptyView?.test?.messageTextView?.currentTextColor
        )
    }

    @Test
    fun testeLabelButtonColorConfiguradoValorNull() {
        val color = emptyView?.test?.actionButton?.currentTextColor

        emptyState?.labelButton = "Label Button"
        emptyState?.labelButtonColor = null
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(color, emptyView?.test?.actionButton?.currentTextColor)
    }

    @Test
    fun testeLabelButtonColorConfiguradaCorretamente() {
        val color = Color.GREEN

        emptyState?.labelButton = "Label Button"
        emptyState?.labelButtonColor = color
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(color, emptyView?.test?.actionButton?.currentTextColor)
    }

    @Test
    fun testeLabelButtonColorResConfiguradoValorNull() {
        val color = emptyView?.test?.actionButton?.currentTextColor

        emptyState?.labelButton = "Label Button"
        emptyState?.labelButtonColor = color
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(color, emptyView?.test?.actionButton?.currentTextColor)
    }

    @Test
    fun testeLabelButtonColorResConfiguradaCorretamente() {
        val colorRes = android.R.color.holo_red_dark

        emptyState?.labelButton = "Label Button"
        emptyState?.labelButtonColorRes = colorRes
        emptyView?.test?.setupEmptyState(emptyState)

        assertEquals(
            ContextCompat.getColor(context!!, colorRes),
            emptyView?.test?.actionButton?.currentTextColor
        )
    }

    @Test
    fun testeActionHandlerEChamadoAoClicarNoBotao() {
        emptyState?.actionHandler = {
            actionCalled = true
        }

        emptyView?.test?.setupEmptyState(emptyState)
        emptyView?.test?.actionButtonCallOnClick()

        assertTrue(actionCalled)
    }

    @Test
    fun testeEmptyViewDeveFicarOcultaAoPassarIsVisibleFalse() {
        emptyState?.isVisible = false

        emptyView?.test?.setupEmptyState(emptyState)
        assertEquals(GONE, emptyView?.visibility)
    }

    @Test
    fun testeEmptyViewDeveFicarVisivelAoPassarIsVisibleTrue() {
        emptyState?.isVisible = false

        emptyView?.test?.setupEmptyState(emptyState)
        assertEquals(GONE, emptyView?.visibility)

        emptyState?.isVisible = true

        emptyView?.test?.setupEmptyState(emptyState)
        assertEquals(VISIBLE, emptyView?.visibility)
    }

    @Test
    fun testeEmptyViewDeveFicarOcultaAoPassarEmptyStateNull() {
        emptyView?.test?.setupEmptyState(emptyState)
        assertEquals(VISIBLE, emptyView?.visibility)

        emptyView?.test?.setupEmptyState(null)
        assertEquals(GONE, emptyView?.visibility)
    }

    // endregion

    // region Private Methods

    private fun restartActivity() {
        activityRule.activity?.finish()
        activityRule.launchActivity(Intent())
    }

    // endregion
}
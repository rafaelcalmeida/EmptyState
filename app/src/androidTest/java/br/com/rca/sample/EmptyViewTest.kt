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

    @Test
    fun testeTitleValorNull() {
        emptyView?.test?.setupTitle(null)

        assertNull(emptyView?.title)
        assertEquals("", emptyView?.test?.titleTextView?.text)
        assertEquals(GONE, emptyView?.test?.titleTextView?.visibility)
    }

    @Test
    fun testeTitleValorVazio() {
        emptyView?.test?.setupTitle("")

        assertEquals("", emptyView?.title)
        assertEquals("", emptyView?.test?.titleTextView?.text)
        assertEquals(GONE, emptyView?.test?.titleTextView?.visibility)
    }

    @Test
    fun testeValorCorrespondeAoConfiguradoNoTitle() {
        val title = "Valor configurado"
        emptyView?.test?.setupTitle(title)

        assertEquals(title, emptyView?.title)
        assertEquals(title, emptyView?.test?.titleTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.titleTextView?.visibility)
    }

    @Test
    fun testeValorCorrespondeAoConfiguradoNoTitleRes() {
        val titleRes = R.string.app_name
        emptyView?.test?.setupTitleRes(titleRes)

        val title = context?.getString(titleRes)
        assertEquals(title, emptyView?.title)
        assertEquals(title, emptyView?.test?.titleTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.titleTextView?.visibility)
    }

    @Test
    fun testeTitleResAoSerConfiguradoDeveAlterarValorTitle() {
        var title = "Valor inicial"
        emptyView?.test?.setupTitle(title)

        assertEquals(title, emptyView?.title)
        assertEquals(title, emptyView?.test?.titleTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.titleTextView?.visibility)

        emptyView?.test?.setupTitleRes(R.string.app_name)

        title = context?.getString(R.string.app_name) ?: ""
        assertEquals(title, emptyView?.title)
        assertEquals(title, emptyView?.test?.titleTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.titleTextView?.visibility)
    }

    @Test
    fun testeMessageValorNull() {
        emptyView?.test?.setupMessage(null)

        assertNull(emptyView?.message)
        assertEquals("", emptyView?.test?.messageTextView?.text)
        assertEquals(GONE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeMessageValorVazio() {
        emptyView?.test?.setupMessage("")

        assertEquals("", emptyView?.message)
        assertEquals("", emptyView?.test?.messageTextView?.text)
        assertEquals(GONE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeValorCorrespondeAoConfiguradoNaMessage() {
        val message = "Valor configurado"
        emptyView?.test?.setupMessage(message)

        assertEquals(message, emptyView?.message)
        assertEquals(message, emptyView?.test?.messageTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeValorCorrespondeAoConfiguradoNoMessageRes() {
        val messageRes = R.string.app_name
        emptyView?.test?.setupMessageRes(messageRes)

        val message = context?.getString(messageRes)
        assertEquals(message, emptyView?.message)
        assertEquals(message, emptyView?.test?.messageTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeMessageResAoSerConfiguradoDeveAlterarValorMessage() {
        var message = "Valor inicial"
        emptyView?.test?.setupMessage(message)

        assertEquals(message, emptyView?.message)
        assertEquals(message, emptyView?.test?.messageTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.messageTextView?.visibility)

        message = context?.getString(R.string.app_name) ?: ""
        emptyView?.test?.setupMessageRes(R.string.app_name)

        assertEquals(message, emptyView?.message)
        assertEquals(message, emptyView?.test?.messageTextView?.text)
        assertEquals(VISIBLE, emptyView?.test?.messageTextView?.visibility)
    }

    @Test
    fun testeLabelButtonValorNull() {
        emptyView?.test?.setupLabelButton(null)

        assertNull(emptyView?.labelButton)
        assertEquals("", emptyView?.test?.actionButton?.text)
        assertEquals(GONE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeLabelButtonValorVazio() {
        emptyView?.test?.setupLabelButton("")

        assertEquals("", emptyView?.labelButton)
        assertEquals("", emptyView?.test?.actionButton?.text)
        assertEquals(GONE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeValorCorrespondeAoConfiguradoNaLabelButton() {
        val label = "Valor configurado"
        emptyView?.test?.setupLabelButton(label)

        assertEquals(label, emptyView?.labelButton)
        assertEquals(label, emptyView?.test?.actionButton?.text)
        assertEquals(VISIBLE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeValorCorrespondeAoConfiguradoNaLabelButtonRes() {
        val labelRes = R.string.app_name
        emptyView?.test?.setupLabelButtonRes(labelRes)

        val message = context?.getString(labelRes)
        assertEquals(message, emptyView?.labelButton)
        assertEquals(message, emptyView?.test?.actionButton?.text)
        assertEquals(VISIBLE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeLabelButtonResAoSerConfiguradoDeveAlterarValorLabelButton() {
        var label = "Valor inicial"
        emptyView?.test?.setupLabelButton(label)

        assertEquals(label, emptyView?.labelButton)
        assertEquals(label, emptyView?.test?.actionButton?.text)
        assertEquals(VISIBLE, emptyView?.test?.actionButton?.visibility)

        label = context?.getString(R.string.app_name) ?: ""
        emptyView?.test?.setupLabelButtonRes(R.string.app_name)

        assertEquals(label, emptyView?.labelButton)
        assertEquals(label, emptyView?.test?.actionButton?.text)
        assertEquals(VISIBLE, emptyView?.test?.actionButton?.visibility)
    }

    @Test
    fun testeImageResValorNull() {
        emptyView?.test?.setupImageRes(null)

        assertNull(emptyView?.test?.emptyImageView?.drawable)
        assertEquals(GONE, emptyView?.test?.emptyImageView?.visibility)
    }

    @Test
    fun testeDrawableDaImagemCorrespondeAImageResConfigurada() {
        val resId = R.drawable.ic_search
        val drawable = ContextCompat.getDrawable(context!!, resId)?.mutate()
        emptyView?.test?.setupImageRes(resId)
        emptyView?.test?.setupImageColor(null)

        assertNotNull(drawable)
        assertNotNull(emptyView?.test?.emptyImageView?.drawable)
        assertTrue(drawable!!.compare(emptyView!!.test.emptyImageView.drawable))
    }

    @Test
    fun testeImageColorConfiguradaValorNull() {
        emptyView?.test?.setupImageRes(R.drawable.ic_search)
        emptyView?.test?.setupImageColor(null)

        assertNotNull(emptyView?.test?.emptyImageView?.drawable)
        assertNull(emptyView?.test?.emptyImageView?.colorFilter)
    }

    @Test
    fun testeImageColorConfiguradaCorretamente() {
        val color = Color.GREEN
        emptyView?.test?.setupImageRes(R.drawable.ic_search)
        emptyView?.test?.setupImageColor(color)

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
        emptyView?.test?.setupImageRes(R.drawable.ic_search)
        emptyView?.test?.setupImageColorRes(null)

        assertNotNull(emptyView?.test?.emptyImageView?.drawable)
        assertNull(emptyView?.test?.emptyImageView?.colorFilter)
    }

    @Test
    fun testeImageColorResConfiguradaCorretamente() {
        val colorRes = R.color.colorPrimary
        emptyView?.test?.setupImageRes(R.drawable.ic_search)
        emptyView?.test?.setupImageColorRes(colorRes)

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
        emptyView?.test?.setupTitle("Title")
        emptyView?.test?.setupTitleColor(null)

        assertEquals(color, emptyView?.test?.titleTextView?.currentTextColor)
    }

    @Test
    fun testeTitleColorConfiguradaCorretamente() {
        val color = Color.GREEN
        emptyView?.test?.setupTitle("Title")
        emptyView?.test?.setupTitleColor(color)

        assertEquals(color, emptyView?.test?.titleTextView?.currentTextColor)
    }

    @Test
    fun testeTitleColorResConfiguradoValorNull() {
        val color = emptyView?.test?.titleTextView?.currentTextColor
        emptyView?.test?.setupTitle("Title")
        emptyView?.test?.setupTitleColorRes(null)

        assertEquals(color, emptyView?.test?.titleTextView?.currentTextColor)
    }

    @Test
    fun testeTitleColorResConfiguradaCorretamente() {
        val colorRes = android.R.color.holo_red_dark
        emptyView?.test?.setupTitle("Title")
        emptyView?.test?.setupTitleColorRes(colorRes)

        assertEquals(
            ContextCompat.getColor(context!!, colorRes),
            emptyView?.test?.titleTextView?.currentTextColor
        )
    }

    @Test
    fun testeMessageColorConfiguradoValorNull() {
        val color = emptyView?.test?.messageTextView?.currentTextColor
        emptyView?.test?.setupMessage("Message")
        emptyView?.test?.setupMessageColor(null)

        assertEquals(color, emptyView?.test?.messageTextView?.currentTextColor)
    }

    @Test
    fun testeMessageColorConfiguradaCorretamente() {
        val color = Color.GREEN
        emptyView?.test?.setupMessage("Message")
        emptyView?.test?.setupMessageColor(color)

        assertEquals(color, emptyView?.test?.messageTextView?.currentTextColor)
    }

    @Test
    fun testeMessageColorResConfiguradoValorNull() {
        val color = emptyView?.test?.messageTextView?.currentTextColor
        emptyView?.test?.setupMessage("Message")
        emptyView?.test?.setupMessageColorRes(null)

        assertEquals(color, emptyView?.test?.messageTextView?.currentTextColor)
    }

    @Test
    fun testeMessageColorResConfiguradaCorretamente() {
        val colorRes = android.R.color.holo_red_dark
        emptyView?.test?.setupMessage("Message")
        emptyView?.test?.setupMessageColorRes(colorRes)

        assertEquals(
            ContextCompat.getColor(context!!, colorRes),
            emptyView?.test?.messageTextView?.currentTextColor
        )
    }

    @Test
    fun testeLabelButtonColorConfiguradoValorNull() {
        val color = emptyView?.test?.actionButton?.currentTextColor
        emptyView?.test?.setupLabelButton("Label Button")
        emptyView?.test?.setupLabelButtonColor(null)

        assertEquals(color, emptyView?.test?.actionButton?.currentTextColor)
    }

    @Test
    fun testeLabelButtonColorConfiguradaCorretamente() {
        val color = Color.GREEN
        emptyView?.test?.setupLabelButton("Label Button")
        emptyView?.test?.setupLabelButtonColor(color)

        assertEquals(color, emptyView?.test?.actionButton?.currentTextColor)
    }

    @Test
    fun testeLabelButtonColorResConfiguradoValorNull() {
        val color = emptyView?.test?.actionButton?.currentTextColor
        emptyView?.test?.setupLabelButton("Label Button")
        emptyView?.test?.setupLabelButtonColorRes(null)

        assertEquals(color, emptyView?.test?.actionButton?.currentTextColor)
    }

    @Test
    fun testeLabelButtonColorResConfiguradaCorretamente() {
        val colorRes = android.R.color.holo_red_dark
        emptyView?.test?.setupLabelButton("Label Button")
        emptyView?.test?.setupLabelButtonColorRes(colorRes)

        assertEquals(
            ContextCompat.getColor(context!!, colorRes),
            emptyView?.test?.actionButton?.currentTextColor
        )
    }

    @Test
    fun testeActionHandlerEChamadoAoClicarNoBotao() {
        emptyView?.actionHandler = {
            actionCalled = true
        }

        emptyView?.test?.actionButtonCallOnClick()
        assertTrue(actionCalled)
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
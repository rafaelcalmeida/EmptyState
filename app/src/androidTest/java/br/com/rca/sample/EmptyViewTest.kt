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
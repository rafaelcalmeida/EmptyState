package br.com.rca.sample

import android.graphics.Color
import br.com.rca.emptystate.R
import br.com.rca.emptystate.model.EmptyState
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test

/**
 * Created by Rafael C. Almeida on 2020-04-07.
 */
class EmptyStateTest {

    // region Private Variables

    private var emptyState: EmptyState? = null

    // endregion

    // region Public Methods

    @Before
    fun setup() {
        emptyState = EmptyState()
    }

    @After
    fun tearDown() {
        emptyState = null
    }

    @Test
    fun testeValidaEstadoInicialDoEmtpyState() {
        assertNull(emptyState?.title)
        assertNull(emptyState?.titleRes)
        assertNull(emptyState?.titleColor)
        assertNull(emptyState?.titleColorRes)

        assertNull(emptyState?.message)
        assertNull(emptyState?.messageRes)
        assertNull(emptyState?.messageColor)
        assertNull(emptyState?.messageColorRes)

        assertNull(emptyState?.labelButton)
        assertNull(emptyState?.labelButtonRes)
        assertNull(emptyState?.labelButtonColor)
        assertNull(emptyState?.labelButtonColorRes)

        assertNull(emptyState?.imageRes)
        assertNull(emptyState?.imageColor)
        assertNull(emptyState?.imageColorRes)
    }

    @Test
    fun testeValidaTituloConfiguradoCorretamenteComValorString() {
        val title = "Valor do título"
        emptyState?.title = title

        assertEquals(title, emptyState?.title)
        assertNull(emptyState?.titleRes)
    }

    @Test
    fun testeValidaTituloConfiguradoCorretamenteComValorStringRes() {
        val titleRes = R.string.lorem_ipsum_short
        emptyState?.titleRes = titleRes

        assertEquals(titleRes, emptyState?.titleRes)
        assertNull(emptyState?.title)
    }

    @Test
    fun testeValidaSeValorStringConfiguradoResetaValorResDoTitulo() {
        val title = "Valor do título"

        emptyState?.titleRes = R.string.lorem_ipsum_short
        emptyState?.title = title

        assertEquals(title, emptyState?.title)
        assertNull(emptyState?.titleRes)
    }

    @Test
    fun testeValidaSeValorStringResResetaValorStringDoTitulo() {
        val titleRes = R.string.lorem_ipsum_short

        emptyState?.title = "Valor do título"
        emptyState?.titleRes = titleRes

        assertEquals(titleRes, emptyState?.titleRes)
        assertNull(emptyState?.title)
    }

    @Test
    fun testeValidaMensagemConfiguradaCorretamenteComValorString() {
        val message = "Valor da mensagem"
        emptyState?.message = message

        assertEquals(message, emptyState?.message)
        assertNull(emptyState?.messageRes)
    }

    @Test
    fun testeValidaMensagemConfiguradaCorretamenteComValorStringRes() {
        val messageRes = R.string.lorem_ipsum_short
        emptyState?.messageRes = messageRes

        assertEquals(messageRes, emptyState?.messageRes)
        assertNull(emptyState?.message)
    }

    @Test
    fun testeValidaSeValorStringResetaValorResDaMensagem() {
        val message = "Valor da mensagem"

        emptyState?.messageRes = R.string.lorem_ipsum_short
        emptyState?.message = message

        assertEquals(message, emptyState?.message)
        assertNull(emptyState?.messageRes)
    }

    @Test
    fun testeValidaSeValorStringResResetaValorStringDaMensagem() {
        val messageRes = R.string.lorem_ipsum_short

        emptyState?.message = "Valor da mensagem"
        emptyState?.messageRes = messageRes

        assertEquals(messageRes, emptyState?.messageRes)
        assertNull(emptyState?.message)
    }

    @Test
    fun testeValidaTextoBotaoConfiguradoCorretamenteComValorString() {
        val label = "Texto do botão"
        emptyState?.labelButton = label

        assertEquals(label, emptyState?.labelButton)
        assertNull(emptyState?.labelButtonRes)
    }

    @Test
    fun testeValidaTextoBotaoConfiguradoCorretamenteComValorStringRes() {
        val labelRes = R.string.lorem_ipsum_short
        emptyState?.labelButtonRes = labelRes

        assertEquals(labelRes, emptyState?.labelButtonRes)
        assertNull(emptyState?.labelButton)
    }

    @Test
    fun testeValidaSeValorStringResetaValorResDoBotao() {
        val label = "Texto do botão"

        emptyState?.labelButtonRes =
            R.string.lorem_ipsum_short
        emptyState?.labelButton = label

        assertEquals(label, emptyState?.labelButton)
        assertNull(emptyState?.labelButtonRes)
    }

    @Test
    fun testeValidaSeValorStringResResetaValorStringDoBotao() {
        val labelRes = R.string.lorem_ipsum_short

        emptyState?.labelButton = "Texto do botão"
        emptyState?.labelButtonRes = labelRes

        assertEquals(labelRes, emptyState?.labelButtonRes)
        assertNull(emptyState?.labelButton)
    }

    @Test
    fun testeValidaSeImagemConfiguradaCorretamente() {
        val imageRes = android.R.drawable.arrow_up_float

        emptyState?.imageRes = imageRes
        assertEquals(imageRes, emptyState?.imageRes)

        emptyState?.imageRes = null
        assertNull(emptyState?.imageRes)
    }

    @Test
    fun testeValidaCorImagemConfiguradaCorretamenteComValorColor() {
        val color = Color.BLACK
        emptyState?.imageColor = color

        assertEquals(color, emptyState?.imageColor)
        assertNull(emptyState?.imageColorRes)
    }

    @Test
    fun testeValidaCorImagemConfiguradaCorretamenteComValorColorRes() {
        val colorRes = android.R.color.darker_gray
        emptyState?.imageColorRes = colorRes

        assertEquals(colorRes, emptyState?.imageColorRes)
        assertNull(emptyState?.imageColor)
    }

    @Test
    fun testeValidaSeValorColorResetaValorColorResDaImagem() {
        val color = Color.RED

        emptyState?.imageColorRes = android.R.color.darker_gray
        emptyState?.imageColor = color

        assertEquals(color, emptyState?.imageColor)
        assertNull(emptyState?.imageColorRes)
    }

    @Test
    fun testeValidaValorColorResResetaValorColorDaImagem() {
        val colorRes = android.R.color.darker_gray

        emptyState?.imageColor = Color.RED
        emptyState?.imageColorRes = colorRes

        assertEquals(colorRes, emptyState?.imageColorRes)
        assertNull(emptyState?.imageColor)
    }

    @Test
    fun testeValidaCorTextoBotaoConfiguradaCorretamenteComValorColor() {
        val color = Color.BLACK
        emptyState?.labelButtonColor = color

        assertEquals(color, emptyState?.labelButtonColor)
        assertNull(emptyState?.labelButtonColorRes)
    }

    @Test
    fun testeValidaCorTextoBotaoConfiguradaCorretamenteComValorColorRes() {
        val colorRes = android.R.color.darker_gray
        emptyState?.labelButtonColorRes = colorRes

        assertEquals(colorRes, emptyState?.labelButtonColorRes)
        assertNull(emptyState?.labelButtonColor)
    }

    @Test
    fun testeValidaSeValorColorResetaValorColorResDoTextoBotao() {
        val color = Color.RED

        emptyState?.labelButtonColorRes = android.R.color.darker_gray
        emptyState?.labelButtonColor = color

        assertEquals(color, emptyState?.labelButtonColor)
        assertNull(emptyState?.labelButtonColorRes)
    }

    @Test
    fun testeValidaSeValorColorResResetaValorColorDoTextoBotao() {
        val colorRes = android.R.color.darker_gray

        emptyState?.labelButtonColor = Color.RED
        emptyState?.labelButtonColorRes = colorRes

        assertEquals(colorRes, emptyState?.labelButtonColorRes)
        assertNull(emptyState?.labelButtonColor)
    }

    @Test
    fun testeValidaCorTituloConfiguradaCorretamenteComValorColor() {
        val color = Color.BLACK
        emptyState?.titleColor = color

        assertEquals(color, emptyState?.titleColor)
        assertNull(emptyState?.titleColorRes)
    }

    @Test
    fun testeValidaCorTituloConfiguradaCorretamenteComValorColorRes() {
        val colorRes = android.R.color.darker_gray
        emptyState?.titleColorRes = colorRes

        assertEquals(colorRes, emptyState?.titleColorRes)
        assertNull(emptyState?.titleColor)
    }

    @Test
    fun testeValidaSeValorColorResetaValorColorResDoTitulo() {
        val color = Color.RED

        emptyState?.titleColorRes = android.R.color.darker_gray
        emptyState?.titleColor = color

        assertEquals(color, emptyState?.titleColor)
        assertNull(emptyState?.titleColorRes)
    }

    @Test
    fun testeValidaSeValorColorResResetaValorColorDoTitulo() {
        val colorRes = android.R.color.darker_gray

        emptyState?.titleColor = Color.RED
        emptyState?.titleColorRes = colorRes

        assertEquals(colorRes, emptyState?.titleColorRes)
        assertNull(emptyState?.titleColor)
    }

    @Test
    fun testeValidaCorMensagemConfiguradaCorretamenteComValorColor() {
        val color = Color.BLACK
        emptyState?.messageColor = color

        assertEquals(color, emptyState?.messageColor)
        assertNull(emptyState?.messageColorRes)
    }

    @Test
    fun testeValidaCorMensagemConfiguradaCorretamenteComValorColorRes() {
        val colorRes = android.R.color.darker_gray
        emptyState?.messageColorRes = colorRes

        assertEquals(colorRes, emptyState?.messageColorRes)
        assertNull(emptyState?.messageColor)
    }

    @Test
    fun testeValidaSeValorColorResetaValorColorResDaMensagem() {
        val color = Color.RED

        emptyState?.messageColorRes = android.R.color.darker_gray
        emptyState?.messageColor = color

        assertEquals(color, emptyState?.messageColor)
        assertNull(emptyState?.messageColorRes)
    }

    @Test
    fun testeValidaSeValorColorResResetaValorColorDaMensagem() {
        val colorRes = android.R.color.darker_gray

        emptyState?.messageColor = Color.RED
        emptyState?.messageColorRes = colorRes

        assertEquals(colorRes, emptyState?.messageColorRes)
        assertNull(emptyState?.messageColor)
    }

    // endregion
}
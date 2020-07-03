package br.com.rca.sample

import android.graphics.Color
import br.com.rca.emptystate.R
import br.com.rca.emptystate.model.EmptyState
import org.junit.After
import org.junit.Assert.*
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

    // endregion
}
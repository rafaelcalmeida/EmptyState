package br.com.rca.emptystate.model

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by Rafael C. Almeida on 2020-04-07.
 */
class EmptyState {

    // region Public Variables

    var title: String? = null
        set(value) {
            titleRes?.let {
                titleRes = null
            }
            field = value
        }

    @StringRes
    var titleRes: Int? = null
        set(value) {
            title?.let {
                title = null
            }
            field = value
        }

    var message: String? = null
        set(value) {
            messageRes?.let {
                messageRes = null
            }
            field = value
        }

    @StringRes
    var messageRes: Int? = null
        set(value) {
            message?.let {
                message = null
            }
            field = value
        }

    var labelButton: String? = null
        set(value) {
            labelButtonRes?.let {
                labelButtonRes = null
            }
            field = value
        }

    @StringRes
    var labelButtonRes: Int? = null
        set(value) {
            labelButton?.let {
                labelButton = null
            }
            field = value
        }

    @DrawableRes
    var imageRes: Int? = null

    @ColorRes
    var imageColorRes: Int? = null
        set(value) {
            imageColor?.let {
                imageColor = null
            }
            field = value
        }

    @ColorInt
    var imageColor: Int? = null
        set(value) {
            imageColorRes?.let {
                imageColorRes = null
            }
            field = value
        }

    @ColorRes
    var labelButtonColorRes: Int? = null
        set(value) {
            labelButtonColor?.let {
                labelButtonColor = null
            }
            field = value
        }

    @ColorInt
    var labelButtonColor: Int? = null
        set(value) {
            labelButtonColorRes?.let {
                labelButtonColorRes = null
            }
            field = value
        }

    @ColorRes
    var titleColorRes: Int? = null
        set(value) {
            titleColor?.let {
                titleColor = null
            }
            field = value
        }

    @ColorInt
    var titleColor: Int? = null
        set(value) {
            titleColorRes?.let {
                titleColorRes = null
            }
            field = value
        }

    @ColorRes
    var messageColorRes: Int? = null
        set(value) {
            messageColor?.let {
                messageColor = null
            }
            field = value
        }

    @ColorInt
    var messageColor: Int? = null
        set(value) {
            messageColorRes?.let {
                messageColorRes = null
            }
            field = value
        }

    // endregion
}

package br.com.rca.emptystate.model

import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Created by Rafael C. Almeida on 2020-04-07.
 */
class EmptyState(
    title: String? = null,
    @StringRes titleRes: Int? = null,
    message: String? = null,
    @StringRes messageRes: Int? = null,
    labelButton: String? = null,
    @StringRes labelButtonRes: Int? = null,
    @DrawableRes var imageRes: Int? = null,
    @ColorRes imageColorRes: Int? = null,
    @ColorInt imageColor: Int? = null,
    @ColorRes labelButtonColorRes: Int? = null,
    @ColorInt labelButtonColor: Int? = null,
    @ColorRes titleColorRes: Int? = null,
    @ColorInt titleColor: Int? = null,
    @ColorRes messageColorRes: Int? = null,
    @ColorInt messageColor: Int? = null,
    var isVisible: Boolean = true,
    var actionHandler: (() -> Unit)? = null
) {

    // region Public Variables

    var title: String? = title
        set(value) {
            titleRes?.let {
                titleRes = null
            }
            field = value
        }

    @StringRes
    var titleRes: Int? = titleRes
        set(value) {
            title?.let {
                title = null
            }
            field = value
        }

    var message: String? = message
        set(value) {
            messageRes?.let {
                messageRes = null
            }
            field = value
        }

    @StringRes
    var messageRes: Int? = messageRes
        set(value) {
            message?.let {
                message = null
            }
            field = value
        }

    var labelButton: String? = labelButton
        set(value) {
            labelButtonRes?.let {
                labelButtonRes = null
            }
            field = value
        }

    @StringRes
    var labelButtonRes: Int? = labelButtonRes
        set(value) {
            labelButton?.let {
                labelButton = null
            }
            field = value
        }

    @ColorRes
    var imageColorRes: Int? = imageColorRes
        set(value) {
            imageColor?.let {
                imageColor = null
            }
            field = value
        }

    @ColorInt
    var imageColor: Int? = imageColor
        set(value) {
            imageColorRes?.let {
                imageColorRes = null
            }
            field = value
        }

    @ColorRes
    var labelButtonColorRes: Int? = labelButtonColorRes
        set(value) {
            labelButtonColor?.let {
                labelButtonColor = null
            }
            field = value
        }

    @ColorInt
    var labelButtonColor: Int? = labelButtonColor
        set(value) {
            labelButtonColorRes?.let {
                labelButtonColorRes = null
            }
            field = value
        }

    @ColorRes
    var titleColorRes: Int? = titleColorRes
        set(value) {
            titleColor?.let {
                titleColor = null
            }
            field = value
        }

    @ColorInt
    var titleColor: Int? = titleColor
        set(value) {
            titleColorRes?.let {
                titleColorRes = null
            }
            field = value
        }

    @ColorRes
    var messageColorRes: Int? = messageColorRes
        set(value) {
            messageColor?.let {
                messageColor = null
            }
            field = value
        }

    @ColorInt
    var messageColor: Int? = messageColor
        set(value) {
            messageColorRes?.let {
                messageColorRes = null
            }
            field = value
        }

    // endregion
}

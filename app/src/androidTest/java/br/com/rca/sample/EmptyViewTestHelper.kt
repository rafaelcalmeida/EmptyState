package br.com.rca.sample

import android.widget.Button
import br.com.rca.emptystate.model.EmptyState
import br.com.rca.emptystate.ui.EmptyView

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.test.platform.app.InstrumentationRegistry

/**
 * Created by Rafael C. Almeida on 13/04/20.
 */
class EmptyViewTestHelper(emptyView: EmptyView) {

    // region Public Views

    var emptyView: EmptyView = emptyView

    val titleTextView: TextView by lazy {
        emptyView.findViewById<TextView>(R.id.titleTextView)
    }

    val messageTextView: TextView by lazy {
        emptyView.findViewById<TextView>(R.id.messageTextView)
    }

    val actionButton: Button by lazy {
        emptyView.findViewById<Button>(R.id.actionButton)
    }

    val emptyImageView: ImageView by lazy {
        emptyView.findViewById<ImageView>(R.id.imageView)
    }

    // endregion

    // region Public Methods

    fun actionButtonCallOnClick() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            actionButton.callOnClick()
        }
    }

    fun setupEmptyState(emptyState: EmptyState?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.emptyState = emptyState
        }
    }

    fun setupTitle(title: String?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.title = title
        }
    }

    fun setupTitleRes(@StringRes resId: Int) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.setTitleRes(resId)
        }
    }

    fun setupMessage(message: String?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.message = message
        }
    }

    fun setupMessageRes(@StringRes resId: Int) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.setMessageRes(resId)
        }
    }

    fun setupLabelButton(label: String?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.labelButton = label
        }
    }

    fun setupLabelButtonRes(@StringRes resId: Int) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.setLabelButtonRes(resId)
        }
    }

    fun setupImageRes(@DrawableRes resId: Int?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.setImageRes(resId)
        }
    }

    fun setupImageColor(@ColorInt color: Int?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.imageColor = color
        }
    }

    fun setupImageColorRes(@ColorRes resId: Int?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.setImageColorRes(resId)
        }
    }

    fun setupTitleColor(@ColorInt color: Int?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.titleColor = color
        }
    }

    fun setupTitleColorRes(@ColorRes resId: Int?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.setTitleColorRes(resId)
        }
    }

    fun setupMessageColor(@ColorInt color: Int?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.messageColor = color
        }
    }

    fun setupMessageColorRes(@ColorRes resId: Int?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.setMessageColorRes(resId)
        }
    }

    fun setupLabelButtonColor(@ColorInt color: Int?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.labelButtonColor = color
        }
    }

    fun setupLabelButtonColorRes(@ColorRes resId: Int?) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.setLabelButtonColorRes(resId)
        }
    }

    fun reset() {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            emptyView.reset()
        }
    }

    // endregion
}

// region Extensions

val EmptyView.test: EmptyViewTestHelper
    get() = EmptyViewTestHelper(this)

// endregion
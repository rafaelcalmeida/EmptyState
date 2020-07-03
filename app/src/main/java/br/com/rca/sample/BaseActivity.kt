package br.com.rca.sample

import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Rafael C. Almeida on 2020-04-06.
 */
abstract class BaseActivity: AppCompatActivity() {

    // region Inner Methods

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    // endregion
}
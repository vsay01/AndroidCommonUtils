package me.com.androidcommonutils

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_sample.*
import kotlinx.android.synthetic.main.content_sample.*
import me.com.androidutilslibrary.dialogutils.DialogUtils.buildDialog
import me.com.androidutilslibrary.networkutils.NetworkUtils.isOnline

class SampleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sample)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view: View? ->
            Snackbar.make(view!!, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        btnShowDialog.setOnClickListener { buildDialog(this@SampleActivity, getString(R.string.welcome), getString(R.string.dialog_welcome_message), getString(R.string.ok)).show() }

        if (isOnline(this)) {
            buildDialog(this@SampleActivity, getString(R.string.welcome), getString(R.string.message_online), getString(R.string.ok)).show()
        } else {
            buildDialog(this@SampleActivity, getString(R.string.welcome), getString(R.string.message_offline), getString(R.string.ok)).show()
        }
    }
}
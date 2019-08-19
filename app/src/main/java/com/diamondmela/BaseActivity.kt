package com.diamondmela

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.diamondmela.util.NetworkUtils
import com.kaopiz.kprogresshud.KProgressHUD
import android.content.Intent
import androidx.fragment.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.toolbar.*


abstract class BaseActivity : AppCompatActivity(), BindingListener {

    private var hud: KProgressHUD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())
        if (!NetworkUtils.isOnline(this)) {
            val builder = AlertDialog.Builder(this)
            builder.setTitle(getString(R.string.no_internet))
            builder.setMessage(getString(R.string.internet_msg))
            builder.setNegativeButton(getString(R.string.close),
                { dialog, which -> dialog.dismiss() })
            val alertDialog = builder.create()
            alertDialog.show()
        }

        hud = KProgressHUD(this);
        init()
        initView()
        postInitView()
        addListener()
        loadData()


    }

    override fun onStop() {
        super.onStop()
        hideProgressDialog()
    }

    protected fun startNewActivity(activity: Class<out Activity>) {
        startActivity(Intent(this, activity))
    }

    protected fun startNewActivityWithIntent(intent: Intent) {
        startActivity(intent)
    }

    protected fun showProgressDialog(title: String, message: String) {
        hud?.dismiss()
        hud = KProgressHUD.create(this)
            .setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
            .setLabel(title)
            .setDetailsLabel(message)
            .show()
    }

    protected fun hideProgressDialog() {
        if (hud != null && hud!!.isShowing()) {
            hud!!.dismiss()
            hud = null
        }

    }

    protected abstract fun getLayoutResourceId(): Int

    fun replaceFragment(fragment: Fragment) {
        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.frameContainer, fragment)
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit()
    }

    protected fun bindToolBar(headerTitle: String) {
        toolbar.setTitle(headerTitle)
        setSupportActionBar(toolbar)
        // add back arrow to toolbar
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }
        toolbar.setNavigationIcon(R.drawable.ic_back)
        toolbar.setNavigationOnClickListener { finish() }
    }

}
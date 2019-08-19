package com.diamondmela

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kaopiz.kprogresshud.KProgressHUD

abstract class BaseFragment : Fragment(), BindingListener {

    private var hud: KProgressHUD? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanseState: Bundle?): View? {
        val view = myFragmentView(inflater, parent, savedInstanseState)
        hud = KProgressHUD(activity!!)
        init()
        initView()
        postInitView()
        addListener()
        loadData()
        return view
    }

    abstract fun myFragmentView(inflater: LayoutInflater, parent: ViewGroup?, savedInstanceState: Bundle?): View

    protected fun startNewActivity(activity: Class<out Activity>) {
        startActivity(Intent(getActivity(), activity))
    }

    protected fun startNewActivityWithIntent(intent: Intent) {
        startActivity(intent)
    }

    protected fun showProgressDialog(title: String, message: String) {
        hud?.dismiss()
        hud = KProgressHUD.create(activity)
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

    fun replaceFragment(fragment: Fragment) {
        val fm = fragmentManager
        val fragmentTransaction = fm?.beginTransaction()
        fragmentTransaction?.replace(R.id.frameContainer, fragment)
        fragmentTransaction?.addToBackStack(null);
        fragmentTransaction?.commit()
    }
}
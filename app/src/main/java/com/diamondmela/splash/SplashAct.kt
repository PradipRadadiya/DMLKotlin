package com.diamondmela.splash

import android.os.Handler
import android.view.Window
import android.view.WindowManager
import com.diamondmela.BaseActivity
import com.diamondmela.R
import com.diamondmela.home.HomeAct
import com.diamondmela.signup_signin.SignInAct
import com.diamondmela.util.SharedPreferenceSession

class SplashAct : BaseActivity() {

    private var mDelayHandler: Handler? = null
    private val SPLASH_DELAY: Long = 5000 //3 seconds

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val session = SharedPreferenceSession(this@SplashAct)
            if (session.loginData.equals("")){
                startNewActivity(SignInAct::class.java)
                finish()
            }else{
                startNewActivity(HomeAct::class.java)
                finish()
            }
        }
    }

    override fun getLayoutResourceId(): Int {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_splash
    }

    override fun init() {
        //Initialize the Handler
        mDelayHandler = Handler()

        //Navigate with delay
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
    }

    public override fun onDestroy() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onDestroy()
    }

    override fun initView() {
    }

    override fun postInitView() {
    }

    override fun addListener() {
    }

    override fun loadData() {

    }

}

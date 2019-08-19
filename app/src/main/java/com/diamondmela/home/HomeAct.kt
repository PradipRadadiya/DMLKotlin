package com.diamondmela.home

import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.diamondmela.BaseActivity
import com.diamondmela.R
import com.diamondmela.SelectPicAct
import com.diamondmela.cart.CartFrg
import com.diamondmela.download.DownloadFrg
import com.diamondmela.home.fragment.HomeFrg
import com.diamondmela.my_account.MyProfileFrg
import com.diamondmela.referral.ReferralFrg
import com.diamondmela.signup_signin.model.login_item.LoginItem
import com.diamondmela.transaction.TransactionAct
import com.diamondmela.util.AppLogger
import com.diamondmela.util.SharedPreferenceSession
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import kotlinx.android.synthetic.main.content_home.*

class HomeAct : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {
    val homeFrg = HomeFrg()
    val referralFrg = ReferralFrg()
    val myProfileFrg = MyProfileFrg()
    val cartFrg = CartFrg()
    val downloadFrg = DownloadFrg()
    val fm = supportFragmentManager
    var active = homeFrg

    companion object {
        private const val ID_HOME = 1
        private const val ID_REFERRAL = 2
        private const val ID_ACCOUNT = 3
        private const val ID_CART = 4
        private const val ID_DOWNLOAD = 5
        var customerId: String = ""
        var groupId: String = ""
        var cartCount: String = ""
        var downloadCount: String = ""
    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_home
    }

    override fun init() {
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        bindBottomNavigation()
    }

    override fun initView() {

        var daysOfWeek = listOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")

        for ((index,day) in daysOfWeek.withIndex()){
            println("day is------------$index----$day")
        }

    }

    override fun postInitView() {
        val session = SharedPreferenceSession(this@HomeAct)
        if (!session.loginData.equals("")) {
            val gson = Gson()
            val loginResponse: LoginItem
            loginResponse = gson.fromJson(session.loginData, LoginItem::class.java)
            AppLogger.e(loginResponse.data.entityId)
            customerId = loginResponse.data.entityId
            groupId = loginResponse.data.groupId
        }
    }

    override fun addListener() {
    }

    override fun loadData() {
        fm.beginTransaction().add(R.id.frameContainer, downloadFrg, "5").hide(downloadFrg).commit();
        fm.beginTransaction().add(R.id.frameContainer, cartFrg, "4").hide(cartFrg).commit();
        fm.beginTransaction().add(R.id.frameContainer, myProfileFrg, "3").hide(myProfileFrg).commit();
        fm.beginTransaction().add(R.id.frameContainer, referralFrg, "2").hide(referralFrg).commit();
        fm.beginTransaction().add(R.id.frameContainer, homeFrg, "1").commit();
    }

    private fun bindBottomNavigation() {
        //Fragment declaration
        bottomNavigation.add(MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_home))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_REFERRAL, R.drawable.ic_referral))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_profile))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_CART, R.drawable.ic_cart))
        bottomNavigation.add(MeowBottomNavigation.Model(ID_DOWNLOAD, R.drawable.ic_download))
        bottomNavigation.setCount(ID_CART, cartCount)
        bottomNavigation.setCount(ID_DOWNLOAD, downloadCount)
        bottomNavigation.show(ID_HOME, true)

        bottomNavigation.setOnShowListener {
            val name = when (it.id) {
                ID_HOME -> AppLogger.e("Home")
                ID_REFERRAL -> AppLogger.e("Referral")
                ID_ACCOUNT -> AppLogger.e("my profile")
                ID_CART -> AppLogger.e("cart")
                ID_DOWNLOAD -> AppLogger.e("Download")
                else -> AppLogger.e("else")
            }
            AppLogger.e("$name page is selected")
        }

        bottomNavigation.setOnClickMenuListener {
            val name = when (it.id) {
                ID_HOME -> {
//                    replaceFragment(fragment = homeFrg)
//                    fm.beginTransaction().hide(active).show(homeFrg).commit();
//                    active = homeFrg
                    selectContentFragment(homeFrg)
                }
                ID_REFERRAL -> {
//                    replaceFragment(fragment = referralFrg)
//                    fm.beginTransaction().hide(active).show(referralFrg).commit();
//                    active  = this.referralFrg
                    selectContentFragment(referralFrg)
                }

                ID_ACCOUNT -> {
//                    replaceFragment(fragment = myProfileFrg)
//                    fm.beginTransaction().hide(active).show(myProfileFrg).commit();
//                    active  = myProfileFrg
                    selectContentFragment(myProfileFrg)
                }

                ID_CART -> {
//                    replaceFragment(fragment = cartFrg)
//                    fm.beginTransaction().hide(active).show(cartFrg).commit();
//                    active  = cartFrg
                    selectContentFragment(cartFrg)
                }

                ID_DOWNLOAD -> {
//                    replaceFragment(fragment = downloadFrg)
//                    fm.beginTransaction().hide(active).show(downloadFrg).commit();
//                    active  = downloadFrg
                    selectContentFragment(downloadFrg)
                }

                else -> {

                }
            }
        }
    }

    private fun selectContentFragment(fragmentToSelect: Fragment) {
        val fragmentTransaction = this.supportFragmentManager.beginTransaction()

        if (this.supportFragmentManager.fragments.contains(fragmentToSelect)) {
            // Iterate through all cached fragments.
            for (cachedFragment in this.supportFragmentManager.fragments) {
                if (cachedFragment !== fragmentToSelect) {
                    // Hide the fragments that are not the one being selected.
                    fragmentTransaction.hide(cachedFragment)
                }
            }
            // Show the fragment that we want to be selected.
            fragmentTransaction.show(fragmentToSelect)
        } else {
            // The fragment to be selected does not (yet) exist in the fragment manager, add it.
            fragmentTransaction.add(R.id.frameContainer, fragmentToSelect)
        }
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
                replaceFragment(fragment = homeFrg)
            }
            R.id.nav_transaction -> {
                startNewActivity(TransactionAct::class.java)
            }
            R.id.nav_order -> {
                startActivity(Intent(this@HomeAct, SelectPicAct::class.java))
            }
            R.id.nav_privacy_policy -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}

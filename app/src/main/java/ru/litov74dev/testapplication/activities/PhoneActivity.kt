package ru.litov74dev.testapplication.activities

import ru.litov74dev.testapplication.navigation.Navigation

class PhoneActivity : BaseActivity(), Navigation {

    override fun goToMain() {
        TODO("Not yet implemented")
    }

    override fun goToSearch() {
        TODO("Not yet implemented")
    }

    override fun goToProfile() {
        TODO("Not yet implemented")
    }

    override fun cleanTop() {
        val fm = supportFragmentManager
        fm.popBackStack()
    }

    override fun cleanBackStack() {
        val fm = supportFragmentManager
        for(i in 0 until fm.backStackEntryCount) {
            fm.popBackStack()
        }
    }

    override fun goBack() {
        val fm = supportFragmentManager
        showFragments()
        val count = fm.backStackEntryCount
        if (count > 1) {
            cleanTop()
        } else {
            finish()
        }
    }

    override fun closeScreen() {
        goBack()
    }

    private fun hideFragments() {
        val ft = supportFragmentManager.beginTransaction()
        supportFragmentManager.fragments.forEach { ft.hide(it) }
        ft.commit()
    }

    private fun showFragments() {
        val ft = supportFragmentManager.beginTransaction()
        supportFragmentManager.fragments.forEach { ft.show(it) }
        ft.commit()
    }

}
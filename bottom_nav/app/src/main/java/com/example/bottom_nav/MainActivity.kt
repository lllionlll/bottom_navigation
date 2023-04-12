package com.example.bottom_nav

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottom_nav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setFragment()
        setSelectedTab(binding.home.id)
        setClick()
    }

    override fun onClick(v: View) {
        setShowFragment(v.id)
        setSelectedTab(v.id)
    }

    private fun addFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .add(binding.fragment.id, fragment)
            .addToBackStack(tag)
            .commit()
    }

    private fun setSelectedTab(id: Int) {
        selectedHome(id == binding.home.id)
        selectedFriends(id == binding.friends.id)
        selectedWatch(id == binding.watch.id)
        selectedNotify(id == binding.noti.id)
        selectedMenu(id == binding.menu.id)
    }

    private fun setShowFragment(id: Int){
        showHome(id == binding.home.id)
        showFriends(id == binding.friends.id)
        showWatch(id == binding.watch.id)
        showNotify(id == binding.noti.id)
        showMenu(id == binding.menu.id)
    }

    private fun selectedHome(isSelected: Boolean) {
        if (isSelected) {
            binding.txtHome.setTextColor(getColor(R.color.select_bottom_nav))
            binding.selectedHome.setBackgroundColor(getColor(R.color.select_bottom_nav))
            binding.icHome.setColorFilter(getColor(R.color.select_bottom_nav))
            binding.icHome.setImageResource(R.drawable.ic_home_filled)
        } else {
            binding.txtHome.setTextColor(getColor(R.color.gray))
            binding.selectedHome.setBackgroundColor(getColor(R.color.un_select_bottom_nav))
            binding.icHome.setColorFilter(getColor(R.color.gray))
            binding.icHome.setImageResource(R.drawable.ic_home)
        }
    }

    private fun selectedFriends(isSelected: Boolean) {
        if (isSelected) {
            binding.txtFriends.setTextColor(getColor(R.color.select_bottom_nav))
            binding.selectedFriends.setBackgroundColor(getColor(R.color.select_bottom_nav))
            binding.icFriends.setColorFilter(getColor(R.color.select_bottom_nav))
            binding.icFriends.setImageResource(R.drawable.ic_people_filled)
        } else {
            binding.txtFriends.setTextColor(getColor(R.color.gray))
            binding.selectedFriends.setBackgroundColor(getColor(R.color.un_select_bottom_nav))
            binding.icFriends.setColorFilter(getColor(R.color.gray))
            binding.icFriends.setImageResource(R.drawable.ic_people)
        }
    }

    private fun selectedWatch(isSelected: Boolean) {
        if (isSelected) {
            binding.txtWatch.setTextColor(getColor(R.color.select_bottom_nav))
            binding.selectedWatch.setBackgroundColor(getColor(R.color.select_bottom_nav))
            binding.icWatch.setColorFilter(getColor(R.color.select_bottom_nav))
            binding.icWatch.setImageResource(R.drawable.ic_watch_filled)
        } else {
            binding.txtWatch.setTextColor(getColor(R.color.gray))
            binding.selectedWatch.setBackgroundColor(getColor(R.color.un_select_bottom_nav))
            binding.icWatch.setColorFilter(getColor(R.color.gray))
            binding.icWatch.setImageResource(R.drawable.ic_watch)
        }
    }

    private fun selectedNotify(isSelected: Boolean) {
        if (isSelected) {
            binding.txtNoti.setTextColor(getColor(R.color.select_bottom_nav))
            binding.selectedNotify.setBackgroundColor(getColor(R.color.select_bottom_nav))
            binding.icNoti.setColorFilter(getColor(R.color.select_bottom_nav))
            binding.icNoti.setImageResource(R.drawable.ic_noti_filled)
        } else {
            binding.txtNoti.setTextColor(getColor(R.color.gray))
            binding.selectedNotify.setBackgroundColor(getColor(R.color.un_select_bottom_nav))
            binding.icNoti.setColorFilter(getColor(R.color.gray))
            binding.icNoti.setImageResource(R.drawable.ic_noti)
        }
    }

    private fun selectedMenu(isSelected: Boolean) {
        if (isSelected) {
            binding.txtMenu.setTextColor(getColor(R.color.select_bottom_nav))
            binding.selectedMenu.setBackgroundColor(getColor(R.color.select_bottom_nav))
            binding.icMenu.setColorFilter(getColor(R.color.select_bottom_nav))
        } else {
            binding.txtMenu.setTextColor(getColor(R.color.gray))
            binding.selectedMenu.setBackgroundColor(getColor(R.color.un_select_bottom_nav))
            binding.icMenu.setColorFilter(getColor(R.color.gray))
        }
    }

    private fun showHome(isShowHome: Boolean) {
        if (isShowHome) {
            supportFragmentManager.beginTransaction()
                .show(supportFragmentManager.fragments[BottomNav.HOME.ordinal])
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .hide(supportFragmentManager.fragments[BottomNav.HOME.ordinal])
                .commit()
        }
    }

    private fun showFriends(isShowFriends: Boolean) {
        if (isShowFriends) {
            supportFragmentManager.beginTransaction()
                .show(supportFragmentManager.fragments[BottomNav.FRIENDS.ordinal])
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .hide(supportFragmentManager.fragments[BottomNav.FRIENDS.ordinal])
                .commit()
        }
    }

    private fun showWatch(isShowWatch: Boolean) {
        if (isShowWatch) {
            supportFragmentManager.beginTransaction()
                .show(supportFragmentManager.fragments[BottomNav.WATCH.ordinal])
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .hide(supportFragmentManager.fragments[BottomNav.WATCH.ordinal])
                .commit()
        }
    }

    private fun showNotify(isShowWatch: Boolean) {
        if (isShowWatch) {
            supportFragmentManager.beginTransaction()
                .show(supportFragmentManager.fragments[BottomNav.NOTIFY.ordinal])
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .hide(supportFragmentManager.fragments[BottomNav.NOTIFY.ordinal])
                .commit()
        }
    }

    private fun showMenu(isShowMenu: Boolean) {
        if (isShowMenu) {
            supportFragmentManager.beginTransaction()
                .show(supportFragmentManager.fragments[BottomNav.MENU.ordinal])
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .hide(supportFragmentManager.fragments[BottomNav.MENU.ordinal])
                .commit()
        }
    }

    private fun setClick() {
        binding.home.setOnClickListener(this)
        binding.friends.setOnClickListener(this)
        binding.watch.setOnClickListener(this)
        binding.noti.setOnClickListener(this)
        binding.menu.setOnClickListener(this)
    }

    private fun setFragment() {
        addFragment(HomeFragment(), BottomNav.HOME.name)
        addFragment(FriendsFragment(), BottomNav.FRIENDS.name)
        addFragment(WatchFragment(), BottomNav.WATCH.name)
        addFragment(NotifyFragment(), BottomNav.NOTIFY.name)
        addFragment(MenuFragment(), BottomNav.MENU.name)
    }

    override fun onBackPressed() {
        finishAfterTransition()
    }
}
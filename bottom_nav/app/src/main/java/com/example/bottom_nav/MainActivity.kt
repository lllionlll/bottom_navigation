package com.example.bottom_nav

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.bottom_nav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var listFragment: List<Fragment>
    lateinit var listTabView: List<LinearLayout>
    lateinit var listIcon: List<ImageView>
    lateinit var listTextLabel: List<TextView>
    lateinit var listSelectedTab: List<TextView>
    lateinit var listIconDrawable: List<Pair<Int, Int>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setValue()
        setContentView(binding.root)
        setFragment()
        setSelected(binding.home)
        setShowFragment(binding.home)
        setClick()
    }

    override fun onClick(v: View) {
        setSelected(v)
        setShowFragment(v)
    }

    private fun addFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction()
            .add(binding.fragment.id, fragment)
            .addToBackStack(tag)
            .commit()
    }

    private fun setShowFragment(v: View){
        listFragment.forEachIndexed { index, it ->
            if (listTabView[index] == v) {
                supportFragmentManager.beginTransaction().show(it).commit()
            } else {
                supportFragmentManager.beginTransaction().hide(it).commit()
            }
        }
    }

    private fun setSelected(v: View) {
        listTabView.forEachIndexed { index, view ->
            if (v == view) {
                listTextLabel[index].setTextColor(getColor(R.color.select_bottom_nav))
                listSelectedTab[index].setBackgroundColor(getColor(R.color.select_bottom_nav))
                listIcon[index].setImageResource(listIconDrawable[index].first)
                listIcon[index].setColorFilter(getColor(R.color.select_bottom_nav))
            } else {
                listTextLabel[index].setTextColor(getColor(R.color.gray))
                listSelectedTab[index].setBackgroundColor(getColor(R.color.un_select_bottom_nav))
                listIcon[index].setImageResource(listIconDrawable[index].second)
                listIcon[index].setColorFilter(getColor(R.color.gray))
            }
        }
    }

    private fun setClick() {
        listTabView.forEach {
            it.setOnClickListener(this)
        }
    }

    private fun setFragment() {
        listFragment.forEach {
            addFragment(it, it.tag.toString())
        }
    }

    private fun setValue() {
        listFragment = listOf(
            HomeFragment(),
            FriendsFragment(),
            WatchFragment(),
            NotifyFragment(),
            MenuFragment()
        )
        listTabView = listOf(
            binding.home,
            binding.friends,
            binding.watch,
            binding.noti,
            binding.menu,
        )
        listIcon = listOf(
            binding.icHome,
            binding.icFriends,
            binding.icWatch,
            binding.icNoti,
            binding.icMenu
        )
        listTextLabel = listOf(
            binding.txtHome,
            binding.txtFriends,
            binding.txtWatch,
            binding.txtNoti,
            binding.txtMenu
        )
        listSelectedTab = listOf(
            binding.selectedHome,
            binding.selectedFriends,
            binding.selectedWatch,
            binding.selectedNotify,
            binding.selectedMenu
        )
        listIconDrawable = listOf(
            Pair(R.drawable.ic_home_filled, R.drawable.ic_home),
            Pair(R.drawable.ic_people_filled, R.drawable.ic_people),
            Pair(R.drawable.ic_watch_filled, R.drawable.ic_watch),
            Pair(R.drawable.ic_noti_filled, R.drawable.ic_noti),
            Pair(R.drawable.ic_menu, R.drawable.ic_menu)
        )
    }

    override fun onBackPressed() {
        finishAfterTransition()
    }
}
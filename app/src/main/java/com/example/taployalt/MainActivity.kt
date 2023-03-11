package com.example.taployalt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.taployalt.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var bind: ActivityMainBinding
    private val fragList = listOf(
        frag1.newInstance(),
        frag2.newInstance(),
        frag3.newInstance(),
    )
    private val fragText = listOf(
        "Паджера спорт",
        "Хусарики",
        "Синий ламбаргини",
    )
    private val fragIcon = listOf(
        R.drawable.hook,
        R.drawable.huskar,
        R.drawable.lamba,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val adapter = Viewpageraddapter(this, fragList)
        bind.vp2.adapter = adapter
        TabLayoutMediator(bind.idtabl, bind.vp2){
            tab, pos ->
            tab.text = fragText[pos]
            tab.icon = ContextCompat.getDrawable(this, fragIcon[pos])
        }.attach()
//        supportFragmentManager.
//        beginTransaction().replace(R.id.vp2, fragList[0]).commit()
//        bind.idtabl.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                supportFragmentManager.
//                    beginTransaction().replace(R.id.vp2, fragList[tab?.position!!]).commit()
//                Toast.makeText(this@MainActivity, "Выбран раздел ${tab?.text} Pos ${tab?.position}", Toast.LENGTH_SHORT).show()
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                Toast.makeText(this@MainActivity, "Повторно выбран раздел ${tab?.text}", Toast.LENGTH_SHORT).show()
//            }
//
//        })
    }
}
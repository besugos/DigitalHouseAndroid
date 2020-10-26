package com.besugos.aula24exlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Obtem elementos
        val pager = findViewById<ViewPager>(R.id.view_pager)
        val tab = findViewById<TabLayout>(R.id.tab_layout)


        //Faz com que o tab use o viewpager
        tab.setupWithViewPager(pager)

        val fragments = listOf(
            FragLogin(),
            FragSignUp()
        )

        //Monta lista de títulos
        val titulos = listOf(
            getString(R.string.login),
            getString(R.string.signup)
        )

        pager.adapter = ViewPagerAdapter(fragments, titulos, supportFragmentManager)



    }
}
package com.bao.groupitemdecoration

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: UserAdapter
    private var mData: MutableList<UserBean> = ArrayList()
    private lateinit var itemDecoration: UserItemDecoration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in 0..10) {
            mData.add(UserBean("AAA$i", "A"))
        }
        for (i in 0..10) {
            mData.add(UserBean("BBB$i", "B"))
        }
        for (i in 0..10) {
            mData.add(UserBean("CCC$i", "C"))
        }
        for (i in 0..10) {
            mData.add(UserBean("DDD$i", "D"))
        }
        for (i in 0..10) {
            mData.add(UserBean("EEE$i", "E"))
        }


        adapter = UserAdapter(mData)

        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        itemDecoration = UserItemDecoration()
        recyclerView.addItemDecoration(itemDecoration)
    }
}
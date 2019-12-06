package com.example.ocrdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * created by hsf
 * date:2019/12/6
 * description:
 */
class SecondActivity : AppCompatActivity() {
    private lateinit var bean: GeneralBean
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        if (intent != null) {
            bean = intent.getSerializableExtra("bean") as GeneralBean
        }

        rv = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = Adapter(this, bean.words_result)
    }

}
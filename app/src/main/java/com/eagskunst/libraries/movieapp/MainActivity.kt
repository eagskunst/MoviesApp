package com.eagskunst.libraries.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val gridLayoutManager = GridLayoutManager(this, 2)
        dummyRv.layoutManager = gridLayoutManager

        dummyRv.withModels {
            (0..5).forEach {
                gradientCard {
                    id(it)
                    model(
                        DummyModel(
                        title = "Title $it",
                        colors = listOf(R.color.colorPrimary, R.color.colorAccent)
                        )
                    )
                }
            }
        }
    }
}

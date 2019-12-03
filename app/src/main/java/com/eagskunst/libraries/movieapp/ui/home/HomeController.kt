package com.eagskunst.libraries.movieapp.ui.home

import com.airbnb.epoxy.Typed2EpoxyController
import com.airbnb.epoxy.TypedEpoxyController
import com.eagskunst.libraries.movieapp.app.models.CategoryCard
import com.eagskunst.libraries.movieapp.gradientCard

/**
 * Created by eagskunst in 2/12/2019.
 */
class HomeController : Typed2EpoxyController<List<CategoryCard>, HomeItemClickListener>() {

    override fun buildModels(data1: List<CategoryCard>?, data2: HomeItemClickListener?) {
        data1?.let { itemList->
            itemList.forEach {
                gradientCard {
                    id(it.hashCode())
                    model(it)
                    clickListener { _, _, clickedView, _ -> data2?.onItemClicked(clickedView, it) }
                }
            }
        }
    }
}
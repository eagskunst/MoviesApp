package com.eagskunst.libraries.movieapp

import com.airbnb.epoxy.TypedEpoxyController
import com.eagskunst.libraries.movieapp.app.models.CategoryCard

/**
 * Created by eagskunst in 2/12/2019.
 */
class HomeController : TypedEpoxyController<List<CategoryCard>>() {

    override fun buildModels(data: List<CategoryCard>?) {
        data?.let { itemList->
            itemList.forEach {
                gradientCard {
                    id(it.hashCode())
                    model(it)
                }
            }
        }
    }
}
package jdsistema.me.breadlistmvvm

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import jdsistema.me.breadlistmvvm.breeds.AdapterItemsContract

/**
 * Created on data 26/07/18.
 */
class BindingAdapters {

    companion object {
        @BindingAdapter("items")
        @JvmStatic
        fun setItems(recyclerView: RecyclerView, items: List<Any>) {
            recyclerView.adapter.let {
                if (it is AdapterItemsContract) {
                    it.replaceItems(items)
                }
            }
        }
    }

}
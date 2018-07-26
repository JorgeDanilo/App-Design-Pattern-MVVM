package jdsistema.me.breadlistmvvm.breeds

import android.content.Context
import android.databinding.ObservableArrayList
import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import jdsistema.me.breadlistmvvm.data.Breed
import jdsistema.me.breadlistmvvm.data.BreedRepository

class BreedsViewModel(val repository: BreedRepository, val context: Context) {

    val breeds = ObservableArrayList<Breed>()
    val loadingVisibility = ObservableBoolean(false)
    val message = ObservableField<String>()

    fun load() {
        loadingVisibility.set(true)
        message.set("")
        repository.listAll({ items ->
            breeds.clear()
            breeds.addAll(items)
            if (items.isEmpty()) {
                message.set("Nenhuma raça disponível")
            }
            loadingVisibility.set(false)
        }, {
            message.set("Uma falha inesperada aconteceu =/, toque aqui para tentar novamente")
            loadingVisibility.set(false)
        })
    }

}

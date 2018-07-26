package jdsistema.me.breadlistmvvm.data

/**
 * Created on data 26/07/18.
 */
interface BreedDataSource {

    fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit)

}
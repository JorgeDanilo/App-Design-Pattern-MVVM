package jdsistema.me.breadlistmvvm.data

/**
 * Created on data 26/07/18.
 */
class BreedRepository(private val dogCeoDataSource: BreedDataSource): BreedDataSource {

    override fun listAll(success: (List<Breed>) -> Unit, failure: () -> Unit) {
        dogCeoDataSource.listAll(success, failure)
    }

}
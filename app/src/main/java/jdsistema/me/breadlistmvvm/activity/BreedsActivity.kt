package jdsistema.me.breadlistmvvm.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import jdsistema.me.breadlistmvvm.R
import jdsistema.me.breadlistmvvm.breeds.BreedsViewModel
import jdsistema.me.breadlistmvvm.data.BreedRepository
import jdsistema.me.breadlistmvvm.data.remote.DogCeoApi
import jdsistema.me.breadlistmvvm.data.remote.DogCeoDataSource

import kotlinx.android.synthetic.main.activity_breads.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BreedsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_breads)

        addFragmentTo(R.id.content_frame, createFragment())
        setSupportActionBar(toolbar)

    }


    private fun createFragment(): Fragment {
        return BreedsFragment.newInstance(createViewModel())

    }

    private fun createViewModel(): BreedsViewModel {
        val retrofit = Retrofit.Builder().baseUrl("http://dog.ceo/api/").addConverterFactory(GsonConverterFactory.create()).build()
        val dogCeoDataSource = DogCeoDataSource(retrofit.create(DogCeoApi::class.java))
        val repository = BreedRepository(dogCeoDataSource)
        return BreedsViewModel(repository, applicationContext)

    }

    fun AppCompatActivity.addFragmentTo(containerId: Int, fragment: Fragment, tag: String = "") {
        supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()
    }

}

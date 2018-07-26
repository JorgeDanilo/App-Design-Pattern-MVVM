package jdsistema.me.breadlistmvvm.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import jdsistema.me.breadlistmvvm.breeds.BreedsAdapter
import jdsistema.me.breadlistmvvm.breeds.BreedsViewModel
import jdsistema.me.breadlistmvvm.databinding.BreadsFragmentBinding

/**
 * A placeholder fragment containing a simple view.
 */
class BreedsFragment : Fragment() {

    lateinit var viewModel: BreedsViewModel

    companion object {
        fun newInstance(viewModel: BreedsViewModel): BreedsFragment {
            val fragment = BreedsFragment()
            fragment.viewModel = viewModel
            return fragment
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.load()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: BreadsFragmentBinding = BreadsFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerView.adapter = BreedsAdapter(emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(activity)
        return binding.root
    }
}

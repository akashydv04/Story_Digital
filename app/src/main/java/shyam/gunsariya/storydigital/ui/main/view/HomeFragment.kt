package shyam.gunsariya.storydigital.ui.main.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import shyam.gunsariya.storydigital.R
import shyam.gunsariya.storydigital.databinding.FragmentHomeBinding
import shyam.gunsariya.storydigital.ui.main.viewmodel.HomeFragmentViewModel


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModel<HomeFragmentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getDummyData()
        observeData()
    }

    private fun observeData() {
        viewModel.listData.observe(viewLifecycleOwner,{
            Log.d("TAG", "observeData: $it")
        })
    }

    private fun getDummyData() {
        viewModel.getDummyData()
    }

}
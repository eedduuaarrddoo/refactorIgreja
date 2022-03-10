package prova.example.igrejarefactor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import prova.example.igrejarefactor.R
import prova.example.igrejarefactor.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    lateinit var viewModel: HomeViewModel
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
       viewModel=ViewModelProvider(this).get(HomeViewModel::class.java)
       val adapter = IgrejaAdapter()

        binding.recyclerView.adapter= adapter

        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.list=it
            adapter.notifyDataSetChanged()
        })

        return binding.root



    }

}
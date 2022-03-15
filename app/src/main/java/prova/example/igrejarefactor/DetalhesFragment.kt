package prova.example.igrejarefactor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import prova.example.igrejarefactor.databinding.FragmentDetalhesBinding


class DetalhesFragment : Fragment() {
lateinit var binding: FragmentDetalhesBinding
lateinit var viewModel: DetalhesViewModel


override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    viewModel= ViewModelProvider(this).get(DetalhesViewModel::class.java)
    binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detalhes,container, false)
    binding.viewModel=viewModel
    binding.lifecycleOwner=this

    return binding.root
    }


}
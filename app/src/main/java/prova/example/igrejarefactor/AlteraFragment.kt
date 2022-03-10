package prova.example.igrejarefactor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import prova.example.igrejarefactor.databinding.FragmentAlteraBinding
import prova.example.igrejarefactor.databinding.FragmentCadastroBinding

class AlteraFragment : Fragment() {
    lateinit var viewModel: AlteraViewModel
    lateinit var binding: FragmentAlteraBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View
    {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_altera,container,false)
        viewModel=ViewModelProvider(this).get(AlteraViewModel::class.java)
        binding.viewModel=viewModel

        binding.lifecycleOwner=this


        return binding.root
    }

   
}
package prova.example.igrejarefactor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import prova.example.igrejarefactor.databinding.FragmentCadastroBinding


class CadastroFragment : Fragment() {
    lateinit var viewModel: CadastroViewModel
    lateinit var binding:FragmentCadastroBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cadastro,container,false)
    viewModel=ViewModelProvider(this).get(CadastroViewModel::class.java)

    binding.viewModel=viewModel
    binding.lifecycleOwner= this

        binding.button.setOnClickListener {
            viewModel.cadastraIgreja()
        Navigation.findNavController(it).navigate(R.id.action_cadastroFragment_to_homeFragment)
        }

        return binding.root
    }

}

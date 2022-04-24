package prova.example.igrejarefactor

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
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
    val factory = CadastroViewModel.CadastraFactory((requireActivity().application as IgrejaApplication).repository)
        viewModel= ViewModelProvider(this, factory)[CadastroViewModel::class.java]

    binding.viewModel=viewModel
    binding.lifecycleOwner= this



        viewModel.eventCadastra.observe(viewLifecycleOwner,{ gatilho ->
            if(gatilho){
                Navigation.findNavController(requireView()).navigate(CadastroFragmentDirections.actionCadastroFragmentToHomeFragment())
                viewModel.resetGatilho()
            }

        })


        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ajudamenu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menuajuda){
            Toast.makeText(context,"insira os dados de cadastro", Toast.LENGTH_SHORT)
        }

        return super.onOptionsItemSelected(item)
    }


}

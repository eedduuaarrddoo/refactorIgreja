package prova.example.igrejarefactor

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import prova.example.igrejarefactor.databinding.FragmentAlteraBinding
import prova.example.igrejarefactor.databinding.FragmentCadastroBinding

class AlteraFragment : Fragment() {
    lateinit var viewModel: AlteraViewModel
    lateinit var binding: FragmentAlteraBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View
    {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_altera,container,false)
        val args:AlteraFragmentArgs by navArgs()
        val viewModelFactory = AlteraViewModel.AlteraViewModelFactory(requireActivity().application,args.id)
        viewModel=ViewModelProvider(this,viewModelFactory).get(AlteraViewModel::class.java)
        binding.viewModel=viewModel

        binding.lifecycleOwner=this


        viewModel.eventAltera.observe(viewLifecycleOwner,{  hasChanged ->
            if (hasChanged==true){
                Navigation.findNavController(requireView()).navigate(AlteraFragmentDirections.actionAlteraFragmentToHomeFragment())
            }
    viewModel.resetGatilho()

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
            Toast.makeText(context,"ajuda altera", Toast.LENGTH_SHORT)
        }

        return super.onOptionsItemSelected(item)
    }

   
}
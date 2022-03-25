package prova.example.igrejarefactor


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import prova.example.igrejarefactor.databinding.FragmentDetalhesBinding


class DetalhesFragment : Fragment() {
lateinit var binding: FragmentDetalhesBinding
lateinit var viewModel: DetalhesViewModel


override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


    val args:DetalhesFragmentArgs by navArgs()

    binding=DataBindingUtil.inflate(inflater,R.layout.fragment_detalhes,container, false)

    val viewModelFactory = DetalhesViewModel.detalheFactory((requireActivity().application as IgrejaApplication).repository,args.id)

    viewModel= ViewModelProvider(this,viewModelFactory)[DetalhesViewModel::class.java]

    binding.viewModel=viewModel

    binding.lifecycleOwner=this

setHasOptionsMenu(true)

    return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    inflater.inflate(R.menu.ajudamenu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menuajuda){
        Toast.makeText(context,"ajuda detalhes",Toast.LENGTH_SHORT)
        }

        return super.onOptionsItemSelected(item)
    }





}
package prova.example.igrejarefactor

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
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

        viewModel.list.observe(viewLifecycleOwner, Observer {list->
            adapter.submitList(list)

        })



        binding.recyclerView.addOnItemTouchListener(RecycleViewClickListener(binding.recyclerView, object :RecycleViewClickListener.OnItemClickListener{

            override fun onItemClick(view: View, position: Int) {
Navigation.findNavController(binding.recyclerView).navigate(HomeFragmentDirections.actionHomeFragmentToDetalhesFragment(adapter.currentList[position].id   ))

    }

    override fun onItemLongClick(view: View, position: Int) {
        Navigation.findNavController(binding.recyclerView).navigate(HomeFragmentDirections.actionHomeFragmentToAlteraFragment(adapter.currentList[position].id  ))


    }


}))
        setHasOptionsMenu(true)

        return binding.root


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ajudamenu,menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.menuajuda){
            Toast.makeText(context,"IGREJAS CADASTRADAS", Toast.LENGTH_SHORT)
        }

        return super.onOptionsItemSelected(item)
    }



}
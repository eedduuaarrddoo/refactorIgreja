package prova.example.igrejarefactor
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import prova.example.igrejarefactor.databinding.IgrejaLayoutBinding

class IgrejaAdapter :ListAdapter<Igreja, IgrejaAdapter.IgrejaViewHolder>(IgrejaDiffCallBack()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IgrejaViewHolder {

        return IgrejaViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: IgrejaViewHolder, position: Int) {
        val igreja = currentList[position]
        holder.bind(igreja)

    }


    class IgrejaViewHolder private constructor(var binding: IgrejaLayoutBinding) : RecyclerView.ViewHolder(binding.root) {


        fun bind(igreja: Igreja) {
binding.igreja= igreja

        }

        companion object {
            fun from(parent: ViewGroup): IgrejaViewHolder {

                val binding: IgrejaLayoutBinding =DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.igreja_layout,parent,false)

                return IgrejaViewHolder(binding)
            }
        }

    }
}

class IgrejaDiffCallBack:DiffUtil.ItemCallback<Igreja>(){
            override fun areItemsTheSame(oldItem: Igreja, newItem: Igreja): Boolean {
            return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Igreja, newItem: Igreja): Boolean {
                return oldItem == newItem
                            }

        }




package prova.example.igrejarefactor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.databinding.DataBindingUtil.bind
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class IgrejaAdapter:ListAdapter<Igreja,IgrejaAdapter.IgrejaViewHolder>(IgrejaDiffCallBack())  {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IgrejaViewHolder {

        return IgrejaViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: IgrejaViewHolder, position: Int) {

        val igreja= currentList [position]
        holder.bind(holder, igreja)
    }




    class IgrejaViewHolder private constructor(itemView: View) :RecyclerView.ViewHolder(itemView){
    var nomeTextview = itemView.findViewById<TextView>(R.id.nomeigreja1)
    var descricaoTextview= itemView.findViewById<TextView>(R.id.descricao1)
    var profetaTextview= itemView.findViewById<TextView>(R.id.profeta1)

        fun bind(holder: IgrejaViewHolder, igreja: Igreja) {
            holder.nomeTextview.text = igreja.nome
            holder.descricaoTextview.text = igreja.descricao
            holder.profetaTextview.text = igreja.profeta
        }
        companion object {
             fun from(parent: ViewGroup): IgrejaViewHolder {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.igreja_layout, parent, false)
                return IgrejaViewHolder(view)
            }
        }


    }



}
class IgrejaDiffCallBack:DiffUtil.ItemCallback<Igreja>(){
    override fun areItemsTheSame(oldItem: Igreja, newItem: Igreja): Boolean {
     return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Igreja, newItem: Igreja): Boolean {
        return oldItem == newItem
    }

}
package prova.example.igrejarefactor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class IgrejaAdapter: RecyclerView.Adapter<IgrejaAdapter.IgrejaViewHolder>() {

   var list:List<Igreja> = ArrayList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IgrejaViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.igreja_layout,parent,false)
        return IgrejaViewHolder(view)
    }

    override fun onBindViewHolder(holder: IgrejaViewHolder, position: Int) {
val igreja= list [position]
        holder.nomeTextview.text= igreja.nome
    }

    override fun getItemCount(): Int {
        return list.size

    }

    class IgrejaViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    var nomeTextview = itemView.findViewById<TextView>(R.id.nomeigreja)

    }


}
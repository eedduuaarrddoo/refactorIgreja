package prova.example.igrejarefactor

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("nfieisAsText")

fun TextView.setnFieisAsText(igreja: Igreja?){
 igreja?.let {
     text = igreja.converteNfieis()
 }
}
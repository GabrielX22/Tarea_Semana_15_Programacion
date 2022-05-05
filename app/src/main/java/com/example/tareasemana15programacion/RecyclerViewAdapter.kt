package com.example.tareasemana15programacion

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

//Se crea la clase constructor del recyclerview
class RecyclerViewAdapter constructor(private val friendsList: List<Friends>) :
    RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    //Se crea una variable privada del clicklistener
    private var clickListener: ClickListener<Friends>? = null
    //En esta funcion,se llena el layout con la informacion que se da en el MyViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerviewlayout, parent, false)
        return MyViewHolder(view)
        //retorna el MyViewHolder con la variable view que es el LayoutInflater
    }

    //Se crea una variable que da la posicion en la lista, tambien se asignan los objetos que van en el holder
    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        //se crea la variable friend para conocer la posicion de la friendlist
        val friend = friendsList[position]
        holder.titulo.text = friend.titulo
        holder.image.setBackgroundResource(friend.image)
        //holder en el cardview cuando se accione el evento clic
        holder.cardView.setOnClickListener {
            clickListener!!.onItemClick(friend)
        }
        holder.txtdesc.text = "Descripcion: ${friend.desc}"
    }

    //esta funcion retorna el tamaño de la lista
    override fun getItemCount(): Int {
        return friendsList.size
    }
    //Crea una funcion que asigna lo que pasa al darle clic a un item del recyclerview
    fun setOnItemClickListener(friendClickListener: ClickListener<Friends>?) {
        clickListener = friendClickListener
    }

    //Esta es una clase interna que contiene los ID y las variables de los objetos que se usan el recyclerview
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titulo: TextView = itemView.findViewById(R.id.elnombre)
        val image: ImageView = itemView.findViewById(R.id.imagepersona)
        val cardView: CardView = itemView.findViewById(R.id.carView)
        val txtdesc: TextView = itemView.findViewById(R.id.txtdescripcion)
    }
}
//Esta es una interfaz del evento click
interface ClickListener<T> {
    fun onItemClick(data: T)
}
package com.example.tareasemana15programacion

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.recyclerviewlayout.*

class MainActivity : AppCompatActivity() {
    //Se asignan las variables que traemos de la clase Recycler y el recyclerview
    private var recyclerView: RecyclerView? = null
    private var recyclerViewAdapter: RecyclerViewAdapter? = null
    private var friendsList = mutableListOf<Friends>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Se le asigna que friendlist es igual a una array
        friendsList = ArrayList()
        //Se busca el ID y se asigna que es un Recyclerview
        recyclerView = findViewById(R.id.elreciclo) as RecyclerView
        //Se asigna el array que tendra el adaptador del recyclerview
        recyclerViewAdapter = RecyclerViewAdapter(friendsList)
        //Se crea una variable para el LayoutManager y va con el Recyclerview
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        //El recyclerview y el layoutmanager se asigna
        recyclerView!!.layoutManager = layoutManager
        //Si se hace tap en cualquiera de los recyclerview, generara un toas que contiene el nombre del amigo
        recyclerViewAdapter!!.setOnItemClickListener(object : ClickListener<Friends> {
            override fun onItemClick(data: Friends) {
                //Toast que aparece cuando se le da clic en un recyclerview mostrando el nombre del amigo
                Toast.makeText(this@MainActivity,"Amig@: "+data.titulo,Toast.LENGTH_SHORT).show()
            }
        })
        //Se le asigna el recyclerview su adaptador
        recyclerView!!.adapter = recyclerViewAdapter
        //Se trae la funcion
        prepareFriends()
        //Se hace un evento clic para pasar de activity cuando se haga clic en el boton
        imagepasar.setOnClickListener {
            val intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }
    }
    //Esta es la funcion que genera la lista y sus valores
    private fun prepareFriends(){
        //Se crea una variable, llamando a la data clase con los valores necesarios para llenarlos
        var friend = Friends("Jaime", R.drawable.jaime,"Mi mejor amigo y compañero de aventuras, siempre ayudandome y aconsejandome.")
        //Se agrega a la lista
        friendsList.add(friend)
        friend = Friends("Salvador", R.drawable.salvador,"Un gran amigo que conoci en la Universidad que siempre es muy amable agradable su compañia.")
        friendsList.add(friend)
        friend = Friends("Litzy", R.drawable.litzy,"Mi mejor amiga que siempre me ayuda y me aconseja siempre.")
        friendsList.add(friend)
        friend = Friends("Melvin", R.drawable.melvin1,"Un buen amigo muy gracioso y animador.")
        friendsList.add(friend)
        friend = Friends("Alex", R.drawable.alex,"Un amigo humilde y que siempre esta para apoyarte.")
        friendsList.add(friend)
        friend = Friends("Adiel", R.drawable.adiel,"Un amigo que hace reir y es divertido.")
        friendsList.add(friend)
        friend = Friends("Melvin Pereira", R.drawable.pereira,"Un buen amigo que siempre te ayuda en lo que pueda.")
        friendsList.add(friend)
        //Se notifica al adaptador del recyclerview que ha cambiado sus datos, lo cual hace que se muestren los recyclerview
        recyclerViewAdapter?.notifyDataSetChanged()
    }
}
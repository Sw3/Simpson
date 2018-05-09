package co.edu.uniquindio.android.electiva.simpson.util

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje
import kotlinx.android.synthetic.main.resumen_personaje.view.*
import co.edu.uniquindio.android.electiva.simpson.R
import co.edu.uniquindio.android.electiva.simpson.activity.DetalleActivity
import co.edu.uniquindio.android.electiva.simpson.fragment.ListaDePersonajesFragment

/**
 * Clase que representa el Adaptador para el recycler view de Personajes
 * @author caflorezvi
 */
class AdaptadorDePersonaje(var personajes:ArrayList<Personaje>) : RecyclerView.Adapter<AdaptadorDePersonaje.PersonajeViewHolder>() {

    lateinit var listener:OnClickAdaptadorDePersonaje

    constructor(fragmento:ListaDePersonajesFragment, personajes: ArrayList<Personaje>) : this(personajes){
        listener = fragmento
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonajeViewHolder {
        val v:View = LayoutInflater.from(parent?.context).inflate(R.layout.resumen_personaje, parent, false)
        return PersonajeViewHolder(v)
    }

    override fun getItemCount(): Int {
        return personajes.size
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder?, position: Int) {
        holder?.bindPersonaje(personajes.get(position))
    }

    inner class PersonajeViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        val nombre:TextView = itemView.nombre
        val fechaNacimiento:TextView = itemView.fecha_nacimiento

        constructor(itemView:View) : super(itemView){
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onClickPosition(adapterPosition)
        }

        fun bindPersonaje(personaje:Personaje){
            nombre.text = personaje.nombre
            fechaNacimiento.text = personaje.fecha.toString()
        }
    }

    /**
     * Interface que sirve como listener para los eventos de click del recyclerview
     */
    interface OnClickAdaptadorDePersonaje {
        fun onClickPosition(pos: Int)
    }

}
package co.edu.uniquindio.android.electiva.proyecto.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.resumen_servicio.view.*
import co.edu.uniquindio.android.electiva.simpson.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicios.ListaDeServiciosFragment

/**
 * Clase que representa el Adaptador para el recycler view de Personajes
 * @author caflorezvi
 */
class AdaptadorDeServicio(var personajes:ArrayList<Servicio>) : RecyclerView.Adapter<AdaptadorDeServicio.PersonajeViewHolder>() {

    lateinit var listener: OnClickAdaptadorDePersonaje

    constructor(fragmento: ListaDeServiciosFragment, personajes: ArrayList<Servicio>) : this(personajes){
        listener = fragmento
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PersonajeViewHolder {
        val v:View = LayoutInflater.from(parent?.context).inflate(R.layout.resumen_servicio, parent, false)
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

        fun bindPersonaje(personaje: Servicio){
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
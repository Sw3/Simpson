package co.edu.uniquindio.android.electiva.proyecto.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.resumen_servicio.view.*
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicio.ListaDeServiciosFragment

/**
 * Clase que representa el Adaptador para el recycler view de Servicios
 * @author caflorezvi
 */
class AdaptadorDeServicio(var servicios:ArrayList<Servicio>) : RecyclerView.Adapter<AdaptadorDeServicio.ServicioViewHolder>() {

    lateinit var listener:OnClickAdaptadorDeServicio

    constructor(fragmento: ListaDeServiciosFragment, servicios: ArrayList<Servicio>) : this(servicios){
        listener = fragmento
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ServicioViewHolder {
        val v:View = LayoutInflater.from(parent?.context).inflate(R.layout.resumen_servicio, parent, false)
        return ServicioViewHolder(v)
    }

    override fun getItemCount(): Int {
        return servicios.size
    }

    override fun onBindViewHolder(holder: ServicioViewHolder?, position: Int) {
        holder?.bindServicio(servicios.get(position))
    }

    inner class ServicioViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        val nombre:TextView = itemView.servicio_resumen_nombre
        val fechaNacimiento:TextView = itemView.servicio_resumen_fecha_nacimiento

        constructor(itemView:View) : super(itemView){
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onClickPosition(adapterPosition)
        }

        fun bindServicio(servicio:Servicio){
            nombre.text = servicio.nombre
            fechaNacimiento.text = servicio.descripcion
        }
    }

    /**
     * Interface que sirve como listener para los eventos de click del recyclerview
     */
    interface OnClickAdaptadorDeServicio {
        fun onClickPosition(pos: Int)
    }

}
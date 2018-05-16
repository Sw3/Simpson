package co.edu.uniquindio.android.electiva.proyecto.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Csolicitud
import kotlinx.android.synthetic.main.resumen_csolicitud.view.*
import co.edu.uniquindio.android.electiva.proyecto.fragment.CSolicitud.ListaDeCSolicitudsFragment

/**
 * Clase que representa el Adaptador para el recycler view de CSolicituds
 * @author caflorezvi
 */
class AdaptadorDeCsolicitud(var csolicituds:ArrayList<Csolicitud>) : RecyclerView.Adapter<AdaptadorDeCsolicitud.CSolicitudViewHolder>() {

    lateinit var listener:OnClickAdaptadorDeCSolicitud

    constructor(fragmento: ListaDeCSolicitudsFragment, csolicituds: ArrayList<Csolicitud>) : this(csolicituds){
        listener = fragmento
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CSolicitudViewHolder {
        val v:View = LayoutInflater.from(parent?.context).inflate(R.layout.resumen_csolicitud, parent, false)
        return CSolicitudViewHolder(v)
    }

    override fun getItemCount(): Int {
        return csolicituds.size
    }

    override fun onBindViewHolder(holder: CSolicitudViewHolder?, position: Int) {
        holder?.bindCSolicitud(csolicituds.get(position))
    }

    inner class CSolicitudViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        val nombre:TextView = itemView.csolicitud_resumen_nombre
        val fechaNacimiento:TextView = itemView.csolicitud_resumen_fecha_nacimiento

        constructor(itemView:View) : super(itemView){
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onClickPosition(adapterPosition)
        }

        fun bindCSolicitud(csolicitud:Csolicitud){
            nombre.text = csolicitud.nombre
            fechaNacimiento.text = csolicitud.fecha.toString()
        }
    }

    /**
     * Interface que sirve como listener para los eventos de click del recyclerview
     */
    interface OnClickAdaptadorDeCSolicitud {
        fun onClickPosition(pos: Int)
    }

}
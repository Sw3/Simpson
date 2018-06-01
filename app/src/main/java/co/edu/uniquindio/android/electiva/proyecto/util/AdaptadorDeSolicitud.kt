package co.edu.uniquindio.android.electiva.proyecto.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.R.id.solicitud_detalle_fecha
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud
import kotlinx.android.synthetic.main.resumen_solicitud.view.*
import co.edu.uniquindio.android.electiva.proyecto.fragment.Solicitud.ListaDeSolicitudsFragment
import kotlinx.android.synthetic.main.fragment_detalle_de_solicitud.view.*

/**
 * Clase que representa el Adaptador para el recycler view de Solicituds
 * @author caflorezvi
 */
class AdaptadorDeSolicitud(var solicituds:ArrayList<Solicitud>) : RecyclerView.Adapter<AdaptadorDeSolicitud.SolicitudViewHolder>() {

    lateinit var listener:OnClickAdaptadorDeSolicitud

    constructor(fragmento: ListaDeSolicitudsFragment, solicituds: ArrayList<Solicitud>) : this(solicituds){
        listener = fragmento
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SolicitudViewHolder {
        val v:View = LayoutInflater.from(parent?.context).inflate(R.layout.resumen_solicitud, parent, false)
        return SolicitudViewHolder(v)
    }

    override fun getItemCount(): Int {
        return solicituds.size
    }

    override fun onBindViewHolder(holder: SolicitudViewHolder?, position: Int) {
        holder?.bindSolicitud(solicituds.get(position))
    }

    inner class SolicitudViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        val servicio:TextView = itemView.solicitud_resumen_nombre
        val usuario: TextView = itemView.solicitud_resumen_fecha_nacimiento
        //val fecha:TextView = itemView.solicitud_resumen_fecha_nacimiento

        constructor(itemView:View) : super(itemView){
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onClickPosition(adapterPosition)
        }

        fun bindSolicitud(solicitud:Solicitud){

           // fecha.text = solicitud.fecha.toString()
            usuario.text = Sesion.buscarUsuario(solicitud.solicitante)
            servicio.text = Sesion.buscarServicio(solicitud.servicio)
        }

    }


    /**
     * Interface que sirve como listener para los eventos de click del recyclerview
     */
    interface OnClickAdaptadorDeSolicitud {
        fun onClickPosition(pos: Int)
    }

}
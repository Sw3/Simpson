package co.edu.uniquindio.android.electiva.proyecto.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Cservicio
import kotlinx.android.synthetic.main.resumen_cservicio.view.*
import co.edu.uniquindio.android.electiva.proyecto.fragment.CServicio.ListaDeCServiciosFragment

/**
 * Clase que representa el Adaptador para el recycler view de CServicios
 * @author caflorezvi
 */
class AdaptadorDeCservicio(var cservicios:ArrayList<Cservicio>) : RecyclerView.Adapter<AdaptadorDeCservicio.CServicioViewHolder>() {

    lateinit var listener:OnClickAdaptadorDeCServicio

    constructor(fragmento: ListaDeCServiciosFragment, cservicios: ArrayList<Cservicio>) : this(cservicios){
        listener = fragmento
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CServicioViewHolder {
        val v:View = LayoutInflater.from(parent?.context).inflate(R.layout.resumen_cservicio, parent, false)
        return CServicioViewHolder(v)
    }

    override fun getItemCount(): Int {
        return cservicios.size
    }

    override fun onBindViewHolder(holder: CServicioViewHolder?, position: Int) {
        holder?.bindCServicio(cservicios.get(position))
    }

    inner class CServicioViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        val nombre:TextView = itemView.cservicio_resumen_nombre
        val fechaNacimiento:TextView = itemView.cservicio_resumen_fecha_nacimiento

        constructor(itemView:View) : super(itemView){
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onClickPosition(adapterPosition)
        }

        fun bindCServicio(cservicio:Cservicio){
            nombre.text = cservicio.nombre
            //fechaNacimiento.text = cservicio.fecha.toString()
        }
    }

    /**
     * Interface que sirve como listener para los eventos de click del recyclerview
     */
    interface OnClickAdaptadorDeCServicio {
        fun onClickPosition(pos: Int)
    }

}
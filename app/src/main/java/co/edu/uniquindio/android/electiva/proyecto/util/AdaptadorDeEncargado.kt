package co.edu.uniquindio.android.electiva.proyecto.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import kotlinx.android.synthetic.main.resumen_encargado.view.*
import co.edu.uniquindio.android.electiva.proyecto.fragment.Encargado.ListaDeEncargadosFragment

/**
 * Clase que representa el Adaptador para el recycler view de Encargados
 * @author caflorezvi
 */
class AdaptadorDeEncargado(var encargados:ArrayList<Encargado>) : RecyclerView.Adapter<AdaptadorDeEncargado.EncargadoViewHolder>() {

    lateinit var listener:OnClickAdaptadorDeEncargado

    constructor(fragmento: ListaDeEncargadosFragment, encargados: ArrayList<Encargado>) : this(encargados){
        listener = fragmento
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): EncargadoViewHolder {
        val v:View = LayoutInflater.from(parent?.context).inflate(R.layout.resumen_encargado, parent, false)
        return EncargadoViewHolder(v)
    }

    override fun getItemCount(): Int {
        return encargados.size
    }

    override fun onBindViewHolder(holder: EncargadoViewHolder?, position: Int) {
        holder?.bindEncargado(encargados.get(position))
    }

    inner class EncargadoViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        val nombre:TextView = itemView.encargado_resumen_nombre
        val fechaNacimiento:TextView = itemView.encargado_resumen_fecha_nacimiento

        constructor(itemView:View) : super(itemView){
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onClickPosition(adapterPosition)
        }

        fun bindEncargado(encargado:Encargado){
            nombre.text = encargado.nombre
            fechaNacimiento.text = encargado.fecha.toString()
        }
    }

    /**
     * Interface que sirve como listener para los eventos de click del recyclerview
     */
    interface OnClickAdaptadorDeEncargado {
        fun onClickPosition(pos: Int)
    }

}
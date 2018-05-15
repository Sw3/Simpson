package co.edu.uniquindio.android.electiva.proyecto.util

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import kotlinx.android.synthetic.main.resumen_cliente.view.*
import co.edu.uniquindio.android.electiva.proyecto.fragment.Cliente.ListaDeClientesFragment

/**
 * Clase que representa el Adaptador para el recycler view de Clientes
 * @author caflorezvi
 */
class AdaptadorDeCliente(var clientes:ArrayList<Cliente>) : RecyclerView.Adapter<AdaptadorDeCliente.ClienteViewHolder>() {

    lateinit var listener:OnClickAdaptadorDeCliente

    constructor(fragmento: ListaDeClientesFragment, clientes: ArrayList<Cliente>) : this(clientes){
        listener = fragmento
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ClienteViewHolder {
        val v:View = LayoutInflater.from(parent?.context).inflate(R.layout.resumen_cliente, parent, false)
        return ClienteViewHolder(v)
    }

    override fun getItemCount(): Int {
        return clientes.size
    }

    override fun onBindViewHolder(holder: ClienteViewHolder?, position: Int) {
        holder?.bindCliente(clientes.get(position))
    }

    inner class ClienteViewHolder : RecyclerView.ViewHolder, View.OnClickListener {

        val nombre:TextView = itemView.cliente_resumen_nombre
        val fechaNacimiento:TextView = itemView.cliente_resumen_fecha_nacimiento

        constructor(itemView:View) : super(itemView){
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            listener.onClickPosition(adapterPosition)
        }

        fun bindCliente(cliente:Cliente){
            nombre.text = cliente.nombre
            fechaNacimiento.text = cliente.cedula
        }
    }

    /**
     * Interface que sirve como listener para los eventos de click del recyclerview
     */
    interface OnClickAdaptadorDeCliente {
        fun onClickPosition(pos: Int)
    }

}
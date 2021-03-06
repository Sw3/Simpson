package co.edu.uniquindio.android.electiva.proyecto.fragment.Cliente


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.util.AdaptadorDeCliente
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import kotlinx.android.synthetic.main.fragment_lista_de_cliente.*
import java.util.*

/**
 * Fragmento que contiene la Lista de Clientes
 * @author caflorezvi
 */
class ListaDeClientesFragment : Fragment(), AdaptadorDeCliente.OnClickAdaptadorDeCliente, AgregarClienteFragment.ClienteCreado, ManagerFireBase.ActualizarAdaptadorCliente {
    override fun onActualizarAdaptador(cliente: Cliente) {
        var listado:Boolean = false
        lista.forEach{if(it.id == cliente.id){
            listado = true
        }}
        if(!listado){
            lista.add(0, cliente)
            adaptador.notifyItemInserted(0)
        }
    }


    lateinit var managerFB : ManagerFireBase

    override fun onClienteCreadoListener(cliente: Cliente) {
        managerFB!!.insertarCliente(cliente)
    }

    /**
     * Método que le notifica al listener que hubo un click
     */
    override fun onClickPosition(pos: Int) {
        listener.onClienteSeleccionado(pos)
    }

    lateinit var adaptador: AdaptadorDeCliente
    lateinit var lista:ArrayList<Cliente>
    lateinit var listener: OnClienteSeleccionadoListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_cliente, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //intancia serviciolistener
        ManagerFireBase.instanciar(this)
        managerFB = ManagerFireBase.instant!!
        managerFB.listenerCliente =  this
        managerFB.escucharFireBaseCliente()
        //adapter

        adaptador = AdaptadorDeCliente(this, lista)
        listaClientes.adapter = adaptador
        listaClientes.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnClienteSeleccionadoListener
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){

            R.id.menu_agregar -> {
                var dialogo = AgregarClienteFragment()
                dialogo.listener = this
                dialogo.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogoTitulo)
                dialogo.show(fragmentManager, "AgregarCliente")
            }


        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Interface que sirve como listener para los eventos del dialogo
     */
    interface OnClienteSeleccionadoListener{
        fun onClienteSeleccionado(pos:Int)
    }

}

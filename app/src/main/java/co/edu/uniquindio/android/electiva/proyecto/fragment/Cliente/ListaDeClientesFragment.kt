package co.edu.uniquindio.android.electiva.proyecto.fragment.Cliente


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.util.AdaptadorDeCliente
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import kotlinx.android.synthetic.main.fragment_lista_de_cliente.*
import java.util.*

/**
 * Fragmento que contiene la Lista de Clientes
 * @author caflorezvi
 */
class ListaDeClientesFragment : Fragment(), AdaptadorDeCliente.OnClickAdaptadorDeCliente, AgregarClienteFragment.ClienteCreado {

    override fun onClienteCreadoListener(cliente: Cliente) {
        lista.add(0, cliente)
        adaptador.notifyItemInserted(0)
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

                //lista.add(0, Cliente("Ayudante de Santa", Date()))
                //adaptador.notifyItemInserted(0)
            }

            R.id.menu_eliminar -> {
                lista.removeAt(1)
                adaptador.notifyItemRemoved(1)
            }

            R.id.menu_modificar -> {
                var aux:Cliente = lista.get(1)
                lista.set(1, lista.get(2))
                lista.set(2, aux)
                adaptador.notifyItemMoved(1,2)
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

package co.edu.uniquindio.android.electiva.proyecto.fragment.Encargado


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.util.AdaptadorDeEncargado
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import kotlinx.android.synthetic.main.fragment_lista_de_encargados.*
import java.util.*

/**
 * Fragmento que contiene la Lista de Encargados
 * @author caflorezvi
 */
class ListaDeEncargadosFragment : Fragment(), AdaptadorDeEncargado.OnClickAdaptadorDeEncargado, AgregarEncargadoFragment.EncargadoCreado, ManagerFireBase.ActualizarAdaptadorEncargado {
    override fun onActualizarAdaptador(encargado: Encargado) {
        lista.add(0, encargado)
        adaptador.notifyItemInserted(0)
    }

    //Firebase
    lateinit var managerFB : ManagerFireBase
    override fun onEncargadoCreadoListener(encargado: Encargado) {
        managerFB!!.insertarEncargado(encargado)
       // managerFB.escucharFireBaseEncargado()
    }

    /**
     * Método que le notifica al listener que hubo un click
     */
    override fun onClickPosition(pos: Int) {
        listener.onEncargadoSeleccionado(pos)
    }

    lateinit var adaptador: AdaptadorDeEncargado
    lateinit var lista:ArrayList<Encargado>
    lateinit var listener: OnEncargadoSeleccionadoListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_encargados, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //intancia serviciolistener
        ManagerFireBase.instanciar(this)
        managerFB = ManagerFireBase.instant!!
        managerFB.listenerEncargado =  this
        managerFB.escucharFireBaseEncargado()
        //adapter
        adaptador = AdaptadorDeEncargado(this, lista)
        listaEncargados.adapter = adaptador
        listaEncargados.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnEncargadoSeleccionadoListener
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){

            R.id.menu_agregar -> {

                var dialogo = AgregarEncargadoFragment()
                dialogo.listener = this
                dialogo.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogoTitulo)
                dialogo.show(fragmentManager, "AgregarEncargado")

                //lista.add(0, Cliente("Ayudante de Santa", Date()))
                //adaptador.notifyItemInserted(0)
            }



        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Interface que sirve como listener para los eventos del dialogo
     */
    interface OnEncargadoSeleccionadoListener{
        fun onEncargadoSeleccionado(pos:Int)
    }

}

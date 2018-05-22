package co.edu.uniquindio.android.electiva.proyecto.fragment.Servicio


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.util.AdaptadorDeServicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.fragment_lista_de_servicio.*
import java.util.*

/**
 * Fragmento que contiene la Lista de Servicios
 * @author caflorezvi
 */
class ListaDeServiciosFragment : Fragment(), AdaptadorDeServicio.OnClickAdaptadorDeServicio, AgregarServicioFragment.ServicioCreado, ManagerFireBase.ActualizarAdaptadorServicio {

    override fun onActualizarAdaptador(servicio: Servicio) {
        lista.add(0, servicio)
        adaptador.notifyItemInserted(0)
    }

    //Firebase
    lateinit var managerFB : ManagerFireBase
    override fun onServicioCreadoListener(servicio: Servicio) {
        managerFB!!.insertarServicio(servicio)
        managerFB.escucharFireBaseServicio()
    }

    /**
     * Método que le notifica al listener que hubo un click
     */
    override fun onClickPosition(pos: Int) {
        listener.onServicioSeleccionado(pos)
    }

    lateinit var adaptador: AdaptadorDeServicio
    lateinit var lista:ArrayList<Servicio>
    lateinit var listener: OnServicioSeleccionadoListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_servicio, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //intancia serviciolistener
        ManagerFireBase.instanciar(this)
        managerFB = ManagerFireBase.instant!!
        managerFB.listenerServicio =  this
        managerFB.escucharFireBaseServicio()
        //adapter
        adaptador = AdaptadorDeServicio(this, lista)
        listaServicios.adapter = adaptador
        listaServicios.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnServicioSeleccionadoListener

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){

            R.id.menu_agregar -> {

                var dialogo = AgregarServicioFragment()
                dialogo.listener = this
                dialogo.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogoTitulo)
                dialogo.show(fragmentManager, "AgregarServicio")
                //lista.add(0, Servicio("Ayudante de Santa", Date()))
                //adaptador.notifyItemInserted(0)
            }


        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Interface que sirve como listener para los eventos del dialogo
     */
    interface OnServicioSeleccionadoListener{
        fun onServicioSeleccionado(pos:Int)
    }

}

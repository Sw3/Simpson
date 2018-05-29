package co.edu.uniquindio.android.electiva.proyecto.fragment.Solicitud


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.util.AdaptadorDeSolicitud
import co.edu.uniquindio.android.electiva.proyecto.util.Utilidades
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud
import kotlinx.android.synthetic.main.fragment_lista_de_solicitud.*
import java.util.*

/**
 * Fragmento que contiene la Lista de Solicituds
 * @author caflorezvi
 */
class ListaDeSolicitudsFragment : Fragment(), AdaptadorDeSolicitud.OnClickAdaptadorDeSolicitud, AgregarSolicitudFragment.SolicitudCreado, ManagerFireBase.ActualizarAdaptadorSolicitud {


    lateinit var managerFB : ManagerFireBase

    override fun onActualizarAdaptador(solicitud: Solicitud) {
        lista.add(0, solicitud)
        adaptador.notifyItemInserted(0)
    }

    override fun onSolicitudCreadoListener(solicitud: Solicitud) {
        managerFB!!.insertarSolicitud(solicitud)
    }

    /**
     * Método que le notifica al listener que hubo un click
     */
    override fun onClickPosition(pos: Int) {
        listener.onSolicitudSeleccionado(pos)
    }

    lateinit var adaptador: AdaptadorDeSolicitud
    lateinit var lista:ArrayList<Solicitud>
    lateinit var listener: OnSolicitudSeleccionadoListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_solicitud, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //intancia serviciolistener
        ManagerFireBase.instanciar(this)
        managerFB = ManagerFireBase.instant!!
        managerFB.listenerSolicitud =  this
        managerFB.escucharFireBaseSolicitud()

        adaptador = AdaptadorDeSolicitud(this, lista)
        listaSolicituds.adapter = adaptador
        listaSolicituds.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnSolicitudSeleccionadoListener
    }


    /**
     * Interface que sirve como listener para los eventos del dialogo
     */
    interface OnSolicitudSeleccionadoListener{
        fun onSolicitudSeleccionado(pos:Int)
    }

}

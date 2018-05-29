package co.edu.uniquindio.android.electiva.proyecto.fragment.CSolicitud


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.util.AdaptadorDeCsolicitud
import co.edu.uniquindio.android.electiva.proyecto.vo.Csolicitud
import kotlinx.android.synthetic.main.fragment_lista_de_csolicitud.*
import java.util.*

/**
 * Fragmento que contiene la Lista de CSolicituds
 * @author caflorezvi
 */
class ListaDeCSolicitudsFragment : Fragment(), AdaptadorDeCsolicitud.OnClickAdaptadorDeCSolicitud, AgregarCsolicitudFragment.CSolicitudCreado {

    lateinit var managerFB : ManagerFireBase


    override fun onCSolicitudCreadoListener(csolicitud: Csolicitud) {
        lista.add(0, csolicitud)
        adaptador.notifyItemInserted(0)
    }

    /**
     * Método que le notifica al listener que hubo un click
     */
    override fun onClickPosition(pos: Int) {
        listener.onCSolicitudSeleccionado(pos)
    }

    lateinit var adaptador: AdaptadorDeCsolicitud
    lateinit var lista:ArrayList<Csolicitud>
    lateinit var listener: OnCSolicitudSeleccionadoListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_csolicitud, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adaptador = AdaptadorDeCsolicitud(this, lista)
        listaCSolicituds.adapter = adaptador
        listaCSolicituds.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnCSolicitudSeleccionadoListener
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){

            R.id.menu_agregar -> {

                var dialogo = AgregarCsolicitudFragment()
                dialogo.listener = this
                dialogo.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogoTitulo)
                dialogo.show(fragmentManager, "AgregarCSolicitud")

                //lista.add(0, CSolicitud("Ayudante de Santa", Date()))
                //adaptador.notifyItemInserted(0)
            }



        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Interface que sirve como listener para los eventos del dialogo
     */
    interface OnCSolicitudSeleccionadoListener{
        fun onCSolicitudSeleccionado(pos:Int)
    }

}

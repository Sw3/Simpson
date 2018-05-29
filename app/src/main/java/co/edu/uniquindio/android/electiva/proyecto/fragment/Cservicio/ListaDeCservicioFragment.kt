package co.edu.uniquindio.android.electiva.proyecto.fragment.CServicio


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.util.AdaptadorDeCservicio
import co.edu.uniquindio.android.electiva.proyecto.util.Utilidades
import co.edu.uniquindio.android.electiva.proyecto.vo.Cservicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.fragment_lista_de_cservicio.*
import java.util.*

/**
 * Fragmento que contiene la Lista de CServicios
 * @author caflorezvi
 */
class ListaDeCServiciosFragment : Fragment(), AdaptadorDeCservicio.OnClickAdaptadorDeCServicio, AgregarCservicioFragment.CServicioCreado, ManagerFireBase.ActualizarAdaptadorServicio {
    override fun onActualizarAdaptador(servicio: Servicio) {
        lista.add(0, Utilidades.ConvertirServToCServ(servicio))
        adaptador.notifyItemInserted(0)
    }



    //Firebase
    lateinit var managerFB : ManagerFireBase


    override fun onCServicioCreadoListener(cservicio: Cservicio) {
        lista.add(0, cservicio)
        adaptador.notifyItemInserted(0)
    }

    /**
     * Método que le notifica al listener que hubo un click
     */
    override fun onClickPosition(pos: Int) {
        listener.onCServicioSeleccionado(pos)
    }

    lateinit var adaptador: AdaptadorDeCservicio
    lateinit var lista:ArrayList<Cservicio>
    lateinit var listener: OnCServicioSeleccionadoListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_cservicio, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //intancia serviciolistener
        ManagerFireBase.instanciar(this)
        managerFB = ManagerFireBase.instant!!
        managerFB.listenerServicio =  this
        managerFB.escucharFireBaseServicio()
        //
        adaptador = AdaptadorDeCservicio(this, lista)
        listaCServicios.adapter = adaptador
        listaCServicios.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnCServicioSeleccionadoListener
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){

            R.id.menu_agregar -> {

                var dialogo = AgregarCservicioFragment()
                dialogo.listener = this
                dialogo.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogoTitulo)
                dialogo.show(fragmentManager, "AgregarCServicio")

                //lista.add(0, CServicio("Ayudante de Santa", Date()))
                //adaptador.notifyItemInserted(0)
            }



        }

        return super.onOptionsItemSelected(item)
    }

    /**
     * Interface que sirve como listener para los eventos del dialogo
     */
    interface OnCServicioSeleccionadoListener{
        fun onCServicioSeleccionado(pos:Int)
    }

}

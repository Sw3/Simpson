package co.edu.uniquindio.android.electiva.proyecto.fragment.Servicios


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*

import co.edu.uniquindio.android.electiva.simpson.R
import co.edu.uniquindio.android.electiva.proyecto.util.AdaptadorDeServicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.fragment_lista_de_servicios.*
import java.util.*

/**
 * Fragmento que contiene la Lista de Personajes
 * @author caflorezvi
 */
class ListaDeServiciosFragment : Fragment(), AdaptadorDeServicio.OnClickAdaptadorDePersonaje, AgregarServicioFragment.PersonajeCreado {

    override fun onPersonajeCreadoListener(personaje: Servicio) {
        lista.add(0, personaje)
        adaptador.notifyItemInserted(0)
    }

    /**
     * Método que le notifica al listener que hubo un click
     */
    override fun onClickPosition(pos: Int) {
        listener.onPersonajeSeleccionado(pos)
    }

    lateinit var adaptador: AdaptadorDeServicio
    lateinit var lista:ArrayList<Servicio>
    lateinit var listener: OnPersonajeSeleccionadoListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_servicios, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adaptador = AdaptadorDeServicio(this, lista)
        listaPersonajes.adapter = adaptador
        listaPersonajes.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = context as OnPersonajeSeleccionadoListener
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when(item?.itemId){

            R.id.menu_agregar -> {

                var dialogo = AgregarServicioFragment()
                dialogo.listener = this
                dialogo.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogoTitulo)
                dialogo.show(fragmentManager, "AgregarPersonaje")

                //lista.add(0, Servicio("Ayudante de Santa", Date()))
                //adaptador.notifyItemInserted(0)
            }

            R.id.menu_eliminar -> {
                lista.removeAt(1)
                adaptador.notifyItemRemoved(1)
            }

            R.id.menu_modificar -> {
                var aux: Servicio = lista.get(1)
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
    interface OnPersonajeSeleccionadoListener{
        fun onPersonajeSeleccionado(pos:Int)
    }

}

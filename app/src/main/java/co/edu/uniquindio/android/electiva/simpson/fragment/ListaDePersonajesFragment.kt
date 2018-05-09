package co.edu.uniquindio.android.electiva.simpson.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.*

import co.edu.uniquindio.android.electiva.simpson.R
import co.edu.uniquindio.android.electiva.simpson.util.AdaptadorDePersonaje
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje
import kotlinx.android.synthetic.main.fragment_lista_de_personajes.*
import java.util.*

/**
 * Fragmento que contiene la Lista de Personajes
 * @author caflorezvi
 */
class ListaDePersonajesFragment : Fragment(), AdaptadorDePersonaje.OnClickAdaptadorDePersonaje, AgregarPersonajeFragment.PersonajeCreado {

    override fun onPersonajeCreadoListener(personaje: Personaje) {
        lista.add(0, personaje)
        adaptador.notifyItemInserted(0)
    }

    /**
     * Método que le notifica al listener que hubo un click
     */
    override fun onClickPosition(pos: Int) {
        listener.onPersonajeSeleccionado(pos)
    }

    lateinit var adaptador: AdaptadorDePersonaje
    lateinit var lista:ArrayList<Personaje>
    lateinit var listener:OnPersonajeSeleccionadoListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_de_personajes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adaptador = AdaptadorDePersonaje(this, lista)
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

                var dialogo = AgregarPersonajeFragment()
                dialogo.listener = this
                dialogo.setStyle(DialogFragment.STYLE_NORMAL, R.style.DialogoTitulo)
                dialogo.show(fragmentManager, "AgregarPersonaje")

                //lista.add(0, Personaje("Ayudante de Santa", Date()))
                //adaptador.notifyItemInserted(0)
            }

            R.id.menu_eliminar -> {
                lista.removeAt(1)
                adaptador.notifyItemRemoved(1)
            }

            R.id.menu_modificar -> {
                var aux:Personaje = lista.get(1)
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

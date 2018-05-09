package co.edu.uniquindio.android.electiva.proyecto.fragment.Servicios

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.android.electiva.proyecto.fragment.CalendarioFragment
import co.edu.uniquindio.android.electiva.simpson.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.fragment_agregar_servicio.view.*
import java.util.*

/**
 * Fragmento de diálogo que muestra el formulario para crear un personaje nuevo
 * @author caflorezvi
 */
class AgregarServicioFragment : DialogFragment(), View.OnClickListener, CalendarioFragment.FechaSeleccionada {

    lateinit var vista:View
    lateinit var fecha:Date
    lateinit var listener: PersonajeCreado

    /**
     * Método que devuelve la fecha seleccionada en el diálogo del calendario
     */
    override fun onFechaSeleccionada(anio: Int, mes: Int, dia: Int) {
        fecha = GregorianCalendar(anio, mes, dia).time
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        vista = inflater?.inflate(R.layout.fragment_agregar_servicio, container, false)

        vista.calendario.setOnClickListener(this)
        vista.agregar_personaje.setOnClickListener(this)

        dialog.setTitle("Agregar Servicio")
        return vista
    }

    override fun onClick(v: View?) {

        if(v?.id == vista.calendario.id){
            var calen = CalendarioFragment()
            calen.listener = this
            calen.show(fragmentManager, "Calendario")
        }

        if(v?.id == vista.agregar_personaje.id){

            val nombre:String = vista.nombre_formulario.text.toString()
            val descripcion:String = vista.descripcion_formulario.text.toString()
            val url:String = vista.url_formulario.text.toString()

            if(fecha!=null && !nombre.isEmpty() && !descripcion.isEmpty() && !url.isEmpty()){

                var personaje = Servicio(nombre, fecha, "", descripcion, url)
                listener.onPersonajeCreadoListener(personaje)
                dismiss()
            }

        }

    }

    /**
     * Interface que sirve como listener para la creación de un personaje
     */
    interface PersonajeCreado{
        fun onPersonajeCreadoListener(personaje: Servicio)
    }

}
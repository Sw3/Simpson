package co.edu.uniquindio.android.electiva.proyecto.fragment.Servicio

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.CalendarioFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.fragment_agregar_servicio.view.*
import kotlinx.android.synthetic.main.fragment_detalle_de_servicio.view.*
import java.util.*

/**
 * Fragmento de diálogo que muestra el formulario para crear un servicio nuevo
 * @author caflorezvi
 */
class AgregarServicioFragment : DialogFragment(), View.OnClickListener, CalendarioFragment.FechaSeleccionada {

    lateinit var vista:View
    lateinit var fecha:Date
    lateinit var listener: ServicioCreado

    /**
     * Método que devuelve la fecha seleccionada en el diálogo del calendario
     */
    override fun onFechaSeleccionada(anio: Int, mes: Int, dia: Int) {
        fecha = GregorianCalendar(anio, mes, dia).time
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        vista = inflater?.inflate(R.layout.fragment_agregar_servicio, container, false)

        //vista.servicio_agregar_calendario.setOnClickListener(this)
        vista.agregar_servicio.setOnClickListener(this)

        dialog.setTitle("Agregar Servicio")
        return vista
    }

    override fun onClick(v: View?) {



        if(v?.id == vista.agregar_servicio.id){

            val nombre:String = vista.servicio_detalle_titulo.text.toString()
            val descripcion:String = vista.servicio_detalle_titulo.text.toString()


            if(fecha!=null && !nombre.isEmpty() && !descripcion.isEmpty()){
               //implementacion
                //listener.onServicioCreadoListener(servicio)
                dismiss()
            }

        }

    }

    /**
     * Interface que sirve como listener para la creación de un servicio
     */
    interface ServicioCreado{
        fun onServicioCreadoListener(servicio: Servicio)
    }

}
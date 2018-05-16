package co.edu.uniquindio.android.electiva.proyecto.fragment.CServicio

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.CalendarioFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Cservicio
import kotlinx.android.synthetic.main.fragment_agregar_cservicio.view.*
import kotlinx.android.synthetic.main.fragment_detalle_de_cservicio.view.*
import java.util.*

/**
 * Fragmento de diálogo que muestra el formulario para crear un cservicio nuevo
 * @author caflorezvi
 */
class AgregarCservicioFragment : DialogFragment(), View.OnClickListener, CalendarioFragment.FechaSeleccionada {

    lateinit var vista:View
    lateinit var fecha:Date
    lateinit var listener: CServicioCreado

    /**
     * Método que devuelve la fecha seleccionada en el diálogo del calendario
     */
    override fun onFechaSeleccionada(anio: Int, mes: Int, dia: Int) {
        fecha = GregorianCalendar(anio, mes, dia).time
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        vista = inflater?.inflate(R.layout.fragment_agregar_cservicio, container, false)

        vista.cservicio_agregar_calendario.setOnClickListener(this)
        vista.agregar_cservicio.setOnClickListener(this)

        dialog.setTitle("Agregar CServicio")
        return vista
    }

    override fun onClick(v: View?) {

        if(v?.id == vista.cservicio_agregar_calendario.id){
            var calen = CalendarioFragment()
            calen.listener = this
            calen.show(fragmentManager, "Calendario")
        }

        if(v?.id == vista.agregar_cservicio.id){

            val nombre:String = vista.cservicio_detalle_nombre.text.toString()
            val descripcion:String = vista.cservicio_detalle_titulo.text.toString()
            val url:String = vista.url_formulario.text.toString()

            if(fecha!=null && !nombre.isEmpty() && !descripcion.isEmpty() && !url.isEmpty()){
/**
                var cservicio = Cservicio(nombre, fecha, "", descripcion, url)
                listener.onCServicioCreadoListener(cservicio)
                **/
                dismiss()
            }

        }

    }

    /**
     * Interface que sirve como listener para la creación de un cservicio
     */
    interface CServicioCreado{
        fun onCServicioCreadoListener(cservicio: Cservicio)
    }

}
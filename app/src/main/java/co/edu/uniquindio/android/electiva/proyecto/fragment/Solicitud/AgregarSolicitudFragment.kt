package co.edu.uniquindio.android.electiva.proyecto.fragment.Solicitud

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.CalendarioFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud
import kotlinx.android.synthetic.main.fragment_agregar_solicitud.view.*
import kotlinx.android.synthetic.main.fragment_detalle_de_solicitud.view.*
import java.util.*

/**
 * Fragmento de diálogo que muestra el formulario para crear un solicitud nuevo
 * @author caflorezvi
 */
class AgregarSolicitudFragment : DialogFragment(), View.OnClickListener, CalendarioFragment.FechaSeleccionada {

    lateinit var vista:View
    lateinit var fecha:Date
    lateinit var listener: SolicitudCreado

    /**
     * Método que devuelve la fecha seleccionada en el diálogo del calendario
     */
    override fun onFechaSeleccionada(anio: Int, mes: Int, dia: Int) {
        fecha = GregorianCalendar(anio, mes, dia).time
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        vista = inflater?.inflate(R.layout.fragment_agregar_solicitud, container, false)

        vista.solicitud_agregar_calendario.setOnClickListener(this)
        vista.agregar_solicitud.setOnClickListener(this)

        dialog.setTitle("Agregar Solicitud")
        return vista
    }

    override fun onClick(v: View?) {
        if(v?.id == vista.solicitud_agregar_calendario.id){
            var calen = CalendarioFragment()
            calen.listener = this
            calen.show(fragmentManager, "Calendario")
        }

        if(v?.id == vista.agregar_solicitud.id){
            val nombre:String = vista.solicitud_detalle_solicitante.text.toString()
            val descripcion:String = vista.solicitud_detalle_titulo.text.toString()
            val url:String = vista.url_formulario.text.toString()
            if(fecha!=null && !nombre.isEmpty() && !descripcion.isEmpty() && !url.isEmpty()){
                var solicitud = Solicitud(Date(),"","")
                listener.onSolicitudCreadoListener(solicitud)
                dismiss()
            }
        }
    }

    /**
     * Interface que sirve como listener para la creación de un solicitud
     */
    interface SolicitudCreado{
        fun onSolicitudCreadoListener(solicitud: Solicitud)
    }

}
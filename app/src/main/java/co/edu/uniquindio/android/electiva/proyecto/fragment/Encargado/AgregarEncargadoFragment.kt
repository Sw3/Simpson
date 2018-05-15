package co.edu.uniquindio.android.electiva.proyecto.fragment.Encargado

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.CalendarioFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import kotlinx.android.synthetic.main.fragment_agregar_encargado.view.*
import kotlinx.android.synthetic.main.fragment_detalle_de_encargado.view.*
import java.util.*

/**
 * Fragmento de diálogo que muestra el formulario para crear un encargado nuevo
 * @author caflorezvi
 */
class AgregarEncargadoFragment : DialogFragment(), View.OnClickListener, CalendarioFragment.FechaSeleccionada {

    lateinit var vista:View
    lateinit var fecha:Date
    lateinit var listener: EncargadoCreado

    /**
     * Método que devuelve la fecha seleccionada en el diálogo del calendario
     */
    override fun onFechaSeleccionada(anio: Int, mes: Int, dia: Int) {
        fecha = GregorianCalendar(anio, mes, dia).time
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        vista = inflater?.inflate(R.layout.fragment_agregar_encargado, container, false)

        //vista.encargado_agregar_calendario.setOnClickListener(this)
        vista.agregar_encargado.setOnClickListener(this)

        dialog.setTitle(R.string.addAdmin)
        return vista
    }

    override fun onClick(v: View?) {


        if(v?.id == vista.agregar_encargado.id){
            val nombre:String = vista.encargado_agregar_nombre.text.toString()
            val cedula:String = vista.encargado_agregar_cedula.text.toString()
            val tel:String = vista.encargado_agregar_telefono.text.toString()
            //val url:String = vista.url_formulario.text.toString()

            if(!nombre.isEmpty() && !cedula.isEmpty() && !tel.isEmpty()){

                var encargado = Encargado(nombre, cedula, tel)
                listener.onEncargadoCreadoListener(encargado)
                dismiss()
            }

        }

    }

    /**
     * Interface que sirve como listener para la creación de un encargado
     */
    interface EncargadoCreado{
        fun onEncargadoCreadoListener(encargado: Encargado)
    }

}
package co.edu.uniquindio.android.electiva.proyecto.fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.widget.DatePicker
import java.util.*

/**
 * Fragmento de diálogo que muestra un calendario por defecto
 * @author caflorezvi
 */
class CalendarioFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {

    lateinit var listener: FechaSeleccionada

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        var calendario:Calendar = Calendar.getInstance()
        var anio = calendario.get(Calendar.YEAR)
        var mes = calendario.get(Calendar.MONTH)
        var dia = calendario.get(Calendar.DAY_OF_MONTH)

        var dialogo = DatePickerDialog(activity, this, anio, mes, dia)

        return dialogo
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener.onFechaSeleccionada(year, month, dayOfMonth)
    }

    /**
     * Interface que sirve como listener para los eventos del calendario
     */
    interface FechaSeleccionada{
        fun onFechaSeleccionada(anio:Int, mes:Int, dia:Int)
    }

}
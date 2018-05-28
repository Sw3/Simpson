package co.edu.uniquindio.android.electiva.proyecto.fragment.Servicio


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.activity.Servicio.EditarServicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.fragment_detalle_de_servicio.*

/**
 * Fragmento que muestra el detalle de un servicio
 * @author caflorezvi
 */
class DetalleDeServicioFragment : Fragment(), View.OnClickListener {

    lateinit var servicio:Servicio

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_servicio, container, false)
    }

    /**
     * Escucha el evento del click del botón y hace un intent a youtube
     */
    override fun onClick(v: View?) {
        //var intent:Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=hP3fmnMuZZU"))
        //startActivity(intent)

        val intent= Intent(this.context, EditarServicio::class.java)
        intent.putExtra("servicio", servicio)
        startActivity(intent)


    }

    /**
     * Obtiene los atributos de un servicio y los muestra en la pantalla
     */
    fun darDetalle(servicio: Servicio) {
        this.servicio = servicio
        servicio_detalle_titulo.text = servicio.nombre
        servicio_detalle_recursos.text = "recursos"
        servicio_detalle_descripcion.text = getString(R.string.descripcion) + ": "+servicio.descripcion
        servicio_detalle_horario.text = getString(R.string.horario) + ": "+servicio.horario
        servicio_detalle_ubicacion.text = getString(R.string.ubicacion) + ": "+servicio.ubicacion
        servicio_detalle_tipo.text = getString(R.string.tipo) + ": "+servicio.tipoServicio


        btnEditarServicio.setOnClickListener(this)
    }

}

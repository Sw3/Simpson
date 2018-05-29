package co.edu.uniquindio.android.electiva.proyecto.fragment.CServicio


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.activity.CSolicitud.CSolicitudsActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.Encargado.EncargadosActivity
import co.edu.uniquindio.android.electiva.proyecto.util.Sesion
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import co.edu.uniquindio.android.electiva.proyecto.vo.Cservicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud
import kotlinx.android.synthetic.main.fragment_detalle_de_cservicio.*
import kotlinx.android.synthetic.main.fragment_detalle_de_servicio.*
import java.util.*

/**
 * Fragmento que muestra el detalle de un cservicio
 * @author caflorezvi
 */
class DetalleDeCservicioFragment : Fragment(), View.OnClickListener {

    lateinit var cservicio:Cservicio
    lateinit var managerFB : ManagerFireBase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_cservicio, container, false)
    }

    /**
     * Escucha el evento del click del botón y hace un intent a youtube
     */
    override fun onClick(v: View?) {
        managerFB = ManagerFireBase.instant!!
        val cli : Cliente = Sesion.clienteSesion!!
        managerFB.insertarSolicitud(Solicitud(Date(), cli.id, cservicio.id))

        var intent = Intent(this.context, CSolicitudsActivity::class.java)
        startActivity(intent)
    }

    /**
     * Obtiene los atributos de un cservicio y los muestra en la pantalla
     */
    fun darDetalle(cservicio: Cservicio) {
        this.cservicio = cservicio
        cservicio_detalle_titulo.text = cservicio.nombre
        cservicio_detalle_recursos.text = "recursos"
        cservicio_detalle_descripcion.text = getString(R.string.descripcion) + ": "+cservicio.descripcion
        cservicio_detalle_horario.text = getString(R.string.horario) + ": "+cservicio.horario
        cservicio_detalle_ubicacion.text = getString(R.string.ubicacion) + ": "+cservicio.ubicacion
        cservicio_detalle_tipo.text = getString(R.string.tipo) + ": "+cservicio.tipoServicio

        btnReservarServicio.setOnClickListener(this)
    }

}

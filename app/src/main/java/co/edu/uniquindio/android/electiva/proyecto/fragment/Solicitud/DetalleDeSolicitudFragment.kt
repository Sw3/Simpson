package co.edu.uniquindio.android.electiva.proyecto.fragment.Solicitud


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.activity.Servicio.EditarServicio
import co.edu.uniquindio.android.electiva.proyecto.activity.Servicio.ServiciosActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.Solicitud.SolicitudsActivity
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud
import kotlinx.android.synthetic.main.fragment_detalle_de_solicitud.*

/**
 * Fragmento que muestra el detalle de un solicitud
 * @author caflorezvi
 */
class DetalleDeSolicitudFragment : Fragment(), View.OnClickListener, ManagerFireBase.ActualizarAdaptadorCliente, ManagerFireBase.ActualizarAdaptadorServicio {

    override fun onActualizarAdaptador(servicio: Servicio) {
        if(servicio.id == solicitud.servicio){
            solicitud_detalle_servicioSolicitado.text = servicio.nombre
        }
    }

    override fun onActualizarAdaptador(cliente: Cliente) {
        if(cliente.id == solicitud.solicitante){
            solicitud_detalle_solicitante.text = cliente.nombre
        }
    }

    lateinit var solicitud:Solicitud
    lateinit var managerFB : ManagerFireBase


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        managerFB = ManagerFireBase.instant!!
        managerFB.listenerCliente = this
        managerFB.listenerServicio= this
        managerFB.escucharFireBaseCliente()
        managerFB.escucharFireBaseServicio()
        return inflater.inflate(R.layout.fragment_detalle_de_solicitud, container, false)
    }

    /**
     * Escucha el evento del click del botón y hace un intent a youtube
     */
    override fun onClick(v: View?) {
        if(v?.id == btn_solicitud_borrar.id){
            managerFB.borrarSolicitud(solicitud)

            var intent = Intent(this.context, SolicitudsActivity::class.java)
            startActivity(intent)
        }else{
            val intent= Intent(this.context, EditarServicio::class.java)
            intent.putExtra("solicitud", solicitud)
            startActivity(intent)
        }
    }

    /**
     * Obtiene los atributos de un solicitud y los muestra en la pantalla
     */
    fun darDetalle(solicitud: Solicitud) {
        this.solicitud = solicitud
        solicitud_detalle_fecha.text = solicitud.fecha.toString()
        btn_solicitud_editar.setOnClickListener(this)
        btn_solicitud_borrar.setOnClickListener(this)
    }
}

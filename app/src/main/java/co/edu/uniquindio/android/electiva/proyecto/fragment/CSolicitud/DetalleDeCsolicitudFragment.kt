package co.edu.uniquindio.android.electiva.proyecto.fragment.CSolicitud


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Csolicitud
import kotlinx.android.synthetic.main.fragment_detalle_de_csolicitud.*

/**
 * Fragmento que muestra el detalle de un csolicitud
 * @author caflorezvi
 */
class DetalleDeCsolicitudFragment : Fragment(), View.OnClickListener {

    lateinit var csolicitud:Csolicitud

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_csolicitud, container, false)
    }

    /**
     * Escucha el evento del click del botón y hace un intent a youtube
     */
    override fun onClick(v: View?) {
        var intent:Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=hP3fmnMuZZU"))
        startActivity(intent)
    }

    /**
     * Obtiene los atributos de un csolicitud y los muestra en la pantalla
     */
    fun darDetalle(csolicitud: Csolicitud) {
        this.csolicitud = csolicitud
        csolicitud_detalle_titulo.text = csolicitud.servicio
        btnIrAVideo.setOnClickListener(this)
    }

}

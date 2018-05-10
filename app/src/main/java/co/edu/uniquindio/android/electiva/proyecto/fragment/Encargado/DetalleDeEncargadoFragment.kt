package co.edu.uniquindio.android.electiva.proyecto.fragment.Encargado


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import kotlinx.android.synthetic.main.fragment_detalle_de_encargado.*

/**
 * Fragmento que muestra el detalle de un encargado
 * @author caflorezvi
 */
class DetalleDeEncargadoFragment : Fragment(), View.OnClickListener {

    lateinit var encargado:Encargado

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_encargado, container, false)
    }

    /**
     * Escucha el evento del click del botón y hace un intent a youtube
     */
    override fun onClick(v: View?) {
        var intent:Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=hP3fmnMuZZU"))
        startActivity(intent)
    }

    /**
     * Obtiene los atributos de un encargado y los muestra en la pantalla
     */
    fun darDetalle(encargado: Encargado) {
        this.encargado = encargado
        encargado_detalle_titulo.text = encargado.nombre
        btnIrAVideo.setOnClickListener(this)
    }

}
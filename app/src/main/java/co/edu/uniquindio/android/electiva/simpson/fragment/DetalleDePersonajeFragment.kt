package co.edu.uniquindio.android.electiva.simpson.fragment


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import co.edu.uniquindio.android.electiva.simpson.R
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje
import kotlinx.android.synthetic.main.fragment_detalle_de_personaje.*

/**
 * Fragmento que muestra el detalle de un personaje
 * @author caflorezvi
 */
class DetalleDePersonajeFragment : Fragment(), View.OnClickListener {

    lateinit var personaje:Personaje

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_personaje, container, false)
    }

    /**
     * Escucha el evento del click del botón y hace un intent a youtube
     */
    override fun onClick(v: View?) {
        var intent:Intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=hP3fmnMuZZU"))
        startActivity(intent)
    }

    /**
     * Obtiene los atributos de un personaje y los muestra en la pantalla
     */
    fun darDetalle(personaje: Personaje) {
        this.personaje = personaje
        txtTituloDetalle.text = personaje.nombre
        btnIrAVideo.setOnClickListener(this)
    }

}

package co.edu.uniquindio.android.electiva.proyecto.activity.CSolicitud

import co.edu.uniquindio.android.electiva.proyecto.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.electiva.proyecto.fragment.CSolicitud.DetalleDeCsolicitudFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Csolicitud

/**
 * Actividad destinada a mostrar el detalle de un CSolicitud a través de un fragmento
 * @author caflorezvi
 */
class DetalleCsolicitudActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_csolicitud)

        val csolicitud:Csolicitud = intent.getParcelableExtra("csolicitud") as Csolicitud

        val fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleCSolicitud) as DetalleDeCsolicitudFragment
        fragmentoDetalle.darDetalle(csolicitud)
    }
}

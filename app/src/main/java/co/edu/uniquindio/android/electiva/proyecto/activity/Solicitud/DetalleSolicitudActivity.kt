package co.edu.uniquindio.android.electiva.proyecto.activity.Solicitud

import co.edu.uniquindio.android.electiva.proyecto.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.electiva.proyecto.fragment.Solicitud.DetalleDeSolicitudFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud

/**
 * Actividad destinada a mostrar el detalle de un Solicitud a través de un fragmento
 * @author caflorezvi
 */
class DetalleSolicitudActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_solicitud)

        val solicitud:Solicitud = intent.getParcelableExtra("solicitud") as Solicitud

        val fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleSolicitud) as DetalleDeSolicitudFragment
        fragmentoDetalle.darDetalle(solicitud)
    }
}

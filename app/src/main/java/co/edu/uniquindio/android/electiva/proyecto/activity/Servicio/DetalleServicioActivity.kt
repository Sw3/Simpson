package co.edu.uniquindio.android.electiva.proyecto.activity.Servicio

import co.edu.uniquindio.android.electiva.proyecto.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicio.DetalleDeServicioFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio

/**
 * Actividad destinada a mostrar el detalle de un Servicio a través de un fragmento
 * @author caflorezvi
 */
class DetalleServicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_servicio)

        val servicio:Servicio = intent.getParcelableExtra("servicio") as Servicio

        val fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleServicio) as DetalleDeServicioFragment
        fragmentoDetalle.darDetalle(servicio)
    }
}

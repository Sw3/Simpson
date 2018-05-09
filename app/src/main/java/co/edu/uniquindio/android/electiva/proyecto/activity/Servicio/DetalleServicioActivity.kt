package co.edu.uniquindio.android.electiva.proyecto.activity.Servicio

import co.edu.uniquindio.android.electiva.simpson.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicios.DetalleDeServicioFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio

/**
 * Actividad destinada a mostrar el detalle de un Servicio a través de un fragmento
 * @author caflorezvi
 */
class DetalleServicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_servicio)

        val personaje: Servicio = intent.getParcelableExtra("personaje") as Servicio

        val fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetallePersonaje) as DetalleDeServicioFragment
        fragmentoDetalle.darDetalle(personaje)
    }
}

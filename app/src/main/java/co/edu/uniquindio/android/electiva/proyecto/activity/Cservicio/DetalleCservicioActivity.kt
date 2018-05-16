package co.edu.uniquindio.android.electiva.proyecto.activity.CServicio

import co.edu.uniquindio.android.electiva.proyecto.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.electiva.proyecto.fragment.CServicio.DetalleDeCservicioFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Cservicio

/**
 * Actividad destinada a mostrar el detalle de un CServicio a través de un fragmento
 * @author caflorezvi
 */
class DetalleCservicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_cservicio)

        val cservicio:Cservicio = intent.getParcelableExtra("cservicio") as Cservicio

        val fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleCServicio) as DetalleDeCservicioFragment
        fragmentoDetalle.darDetalle(cservicio)
    }
}

package co.edu.uniquindio.android.electiva.simpson.activity

import co.edu.uniquindio.android.electiva.simpson.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.electiva.simpson.fragment.DetalleDePersonajeFragment
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje
import kotlinx.android.synthetic.main.activity_detalle.*

/**
 * Actividad destinada a mostrar el detalle de un Personaje a través de un fragmento
 * @author caflorezvi
 */
class DetalleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle)

        val personaje:Personaje = intent.getParcelableExtra("personaje") as Personaje

        val fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetallePersonaje) as DetalleDePersonajeFragment
        fragmentoDetalle.darDetalle(personaje)
    }
}

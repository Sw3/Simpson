package co.edu.uniquindio.android.electiva.proyecto.activity.Encargado

import co.edu.uniquindio.android.electiva.proyecto.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.electiva.proyecto.fragment.Encargado.DetalleDeEncargadoFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado

/**
 * Actividad destinada a mostrar el detalle de un Cliente a través de un fragmento
 * @author caflorezvi
 */
class DetalleClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_encargado)

        val encargado:Encargado = intent.getParcelableExtra("encargado") as Encargado

        val fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleEncargado) as DetalleDeEncargadoFragment
        fragmentoDetalle.darDetalle(encargado)
    }
}

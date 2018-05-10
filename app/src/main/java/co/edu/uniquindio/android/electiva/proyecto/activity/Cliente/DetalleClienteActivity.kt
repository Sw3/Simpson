package co.edu.uniquindio.android.electiva.proyecto.activity.Cliente

import co.edu.uniquindio.android.electiva.proyecto.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.electiva.proyecto.fragment.Cliente.DetalleDeClienteFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente

/**
 * Actividad destinada a mostrar el detalle de un Cliente a través de un fragmento
 * @author caflorezvi
 */
class DetalleClienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_cliente)

        val cliente:Cliente = intent.getParcelableExtra("cliente") as Cliente

        val fragmentoDetalle = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleCliente) as DetalleDeClienteFragment
        fragmentoDetalle.darDetalle(cliente)
    }
}

package co.edu.uniquindio.android.electiva.proyecto.activity.Solicitud

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.Solicitud.DetalleDeSolicitudFragment
import co.edu.uniquindio.android.electiva.proyecto.fragment.Solicitud.ListaDeSolicitudsFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud
import java.util.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de Solicituds
 * @author caflorezvi
 */
class SolicitudsActivity : AppCompatActivity(), ListaDeSolicitudsFragment.OnSolicitudSeleccionadoListener {

    lateinit var lista:ArrayList<Solicitud>
    var fragment:Fragment? = null

    /**
     * Método que devuelve la posición que se seleccionó en el recyclerview
     */
    override fun onSolicitudSeleccionado(pos: Int) {

        if (fragment != null) {
            (fragment as DetalleDeSolicitudFragment).darDetalle(lista[pos])
        }else{
            var intent:Intent = Intent(this, DetalleSolicitudActivity::class.java)
            intent.putExtra("solicitud", lista.get(pos))
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitud)

        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleSolicitud)

        lista = ArrayList()
        lista.add( Solicitud("Solicitud 1", Date()) )
        lista.add( Solicitud("Solicitud 2", Date()) )


        val fragmentLista = supportFragmentManager.findFragmentById(R.id.fragmentoListaSolicituds) as ListaDeSolicitudsFragment
        fragmentLista.lista = lista

        if (fragment != null) {
            (fragment as DetalleDeSolicitudFragment).darDetalle(lista.get(0))
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }
}

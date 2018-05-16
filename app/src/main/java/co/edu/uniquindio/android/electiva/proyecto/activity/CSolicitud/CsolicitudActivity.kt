package co.edu.uniquindio.android.electiva.proyecto.activity.CSolicitud

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.CSolicitud.DetalleDeCsolicitudFragment
import co.edu.uniquindio.android.electiva.proyecto.fragment.CSolicitud.ListaDeCSolicitudsFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Csolicitud
import java.util.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de CSolicituds
 * @author caflorezvi
 */
class CSolicitudsActivity : AppCompatActivity(), ListaDeCSolicitudsFragment.OnCSolicitudSeleccionadoListener {

    lateinit var lista:ArrayList<Csolicitud>
    var fragment:Fragment? = null

    /**
     * Método que devuelve la posición que se seleccionó en el recyclerview
     */
    override fun onCSolicitudSeleccionado(pos: Int) {

        if (fragment != null) {
            (fragment as DetalleDeCsolicitudFragment).darDetalle(lista[pos])
        }else{
            var intent:Intent = Intent(this, DetalleCsolicitudActivity::class.java)
            intent.putExtra("csolicitud", lista.get(pos))
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_csolicitud)

        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleCSolicitud)

        lista = ArrayList()
        lista.add( Csolicitud("CSolicitud 1", Date()) )
        lista.add( Csolicitud("CSolicitud 2", Date()) )


        val fragmentLista = supportFragmentManager.findFragmentById(R.id.fragmentoListaCSolicituds) as ListaDeCSolicitudsFragment
        fragmentLista.lista = lista

        if (fragment != null) {
            (fragment as DetalleDeCsolicitudFragment).darDetalle(lista.get(0))
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

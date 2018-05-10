package co.edu.uniquindio.android.electiva.proyecto.activity.Servicio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicio.DetalleDeServicioFragment
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicio.ListaDeServiciosFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import java.util.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de Servicios
 * @author caflorezvi
 */
class ServiciosActivity : AppCompatActivity(), ListaDeServiciosFragment.OnServicioSeleccionadoListener {

    lateinit var lista:ArrayList<Servicio>
    var fragment:Fragment? = null

    /**
     * Método que devuelve la posición que se seleccionó en el recyclerview
     */
    override fun onServicioSeleccionado(pos: Int) {

        if (fragment != null) {
            (fragment as DetalleDeServicioFragment).darDetalle(lista[pos])
        }else{
            var intent:Intent = Intent(this, DetalleServicioActivity::class.java)
            intent.putExtra("servicio", lista.get(pos))
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicio)

        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleServicio)

        lista = ArrayList()
        lista.add( Servicio("Servicio 1", Date()) )
        lista.add( Servicio("Servicio 2", Date()) )


        val fragmentLista = supportFragmentManager.findFragmentById(R.id.fragmentoListaServicios) as ListaDeServiciosFragment
        fragmentLista.lista = lista

        if (fragment != null) {
            (fragment as DetalleDeServicioFragment).darDetalle(lista.get(0))
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

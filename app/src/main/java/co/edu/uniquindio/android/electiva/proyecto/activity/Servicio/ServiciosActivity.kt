package co.edu.uniquindio.android.electiva.proyecto.activity.Servicio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.android.electiva.simpson.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicios.DetalleDeServicioFragment
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicios.ListaDeServiciosFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import java.util.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de Personajes
 * @author caflorezvi
 */
class ServiciosActivity : AppCompatActivity(), ListaDeServiciosFragment.OnPersonajeSeleccionadoListener {

    lateinit var lista:ArrayList<Servicio>
    var fragment:Fragment? = null

    /**
     * Método que devuelve la posición que se seleccionó en el recyclerview
     */
    override fun onPersonajeSeleccionado(pos: Int) {

        if (fragment != null) {
            (fragment as DetalleDeServicioFragment).darDetalle(lista[pos])
        }else{
            var intent:Intent = Intent(this, DetalleServicioActivity::class.java)
            intent.putExtra("personaje", lista.get(pos))
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_servicio)

        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetallePersonaje)

        lista = ArrayList()
        lista.add(Servicio("Nelson", Date()))
        lista.add(Servicio("Bart", Date()))
        lista.add(Servicio("Homero", Date()))
        lista.add(Servicio("Lisa", Date()))
        lista.add(Servicio("Skinner", Date()))
        lista.add(Servicio("Milhouse", Date()))
        lista.add(Servicio("Apu", Date()))
        lista.add(Servicio("Krusty", Date()))
        lista.add(Servicio("Flanders", Date()))
        lista.add(Servicio("Maggie", Date()))
        lista.add(Servicio("Carl", Date()))
        lista.add(Servicio("Moe", Date()))

        val fragmentLista = supportFragmentManager.findFragmentById(R.id.fragmentoListaPersonajes) as ListaDeServiciosFragment
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

package co.edu.uniquindio.android.electiva.simpson.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.android.electiva.simpson.R
import co.edu.uniquindio.android.electiva.simpson.fragment.DetalleDePersonajeFragment
import co.edu.uniquindio.android.electiva.simpson.fragment.ListaDePersonajesFragment
import co.edu.uniquindio.android.electiva.simpson.util.AdaptadorDePersonaje
import co.edu.uniquindio.android.electiva.simpson.vo.Personaje
import kotlinx.android.synthetic.main.activity_simpson.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de Personajes
 * @author caflorezvi
 */
class SimpsonActivity : AppCompatActivity(), ListaDePersonajesFragment.OnPersonajeSeleccionadoListener {

    lateinit var lista:ArrayList<Personaje>
    var fragment:Fragment? = null

    /**
     * Método que devuelve la posición que se seleccionó en el recyclerview
     */
    override fun onPersonajeSeleccionado(pos: Int) {

        if (fragment != null) {
            (fragment as DetalleDePersonajeFragment).darDetalle(lista[pos])
        }else{
            var intent:Intent = Intent(this, DetalleActivity::class.java)
            intent.putExtra("personaje", lista.get(pos))
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_simpson)

        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetallePersonaje)

        lista = ArrayList()
        lista.add( Personaje("Nelson", Date()) )
        lista.add( Personaje("Bart", Date()) )
        lista.add( Personaje("Homero", Date()) )
        lista.add( Personaje("Lisa", Date()) )
        lista.add( Personaje("Skinner", Date()) )
        lista.add( Personaje("Milhouse", Date()) )
        lista.add( Personaje("Apu", Date()) )
        lista.add( Personaje("Krusty", Date()) )
        lista.add( Personaje("Flanders", Date()) )
        lista.add( Personaje("Maggie", Date()) )
        lista.add( Personaje("Carl", Date()) )
        lista.add( Personaje("Moe", Date()) )

        val fragmentLista = supportFragmentManager.findFragmentById(R.id.fragmentoListaPersonajes) as ListaDePersonajesFragment
        fragmentLista.lista = lista

        if (fragment != null) {
            (fragment as DetalleDePersonajeFragment).darDetalle(lista.get(0))
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

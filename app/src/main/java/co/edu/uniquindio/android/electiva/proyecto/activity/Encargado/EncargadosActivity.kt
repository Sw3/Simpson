package co.edu.uniquindio.android.electiva.proyecto.activity.Encargado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.Encargado.DetalleDeEncargadoFragment
import co.edu.uniquindio.android.electiva.proyecto.fragment.Encargado.ListaDeEncargadosFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import java.util.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de Encargados
 * @author caflorezvi
 */
class EncargadosActivity : AppCompatActivity(), ListaDeEncargadosFragment.OnEncargadoSeleccionadoListener {

    lateinit var lista:ArrayList<Encargado>
    var fragment:Fragment? = null

    /**
     * Método que devuelve la posición que se seleccionó en el recyclerview
     */
    override fun onEncargadoSeleccionado(pos: Int) {

        if (fragment != null) {
            (fragment as DetalleDeEncargadoFragment).darDetalle(lista[pos])
        }else{
            var intent:Intent = Intent(this, DetalleClienteActivity::class.java)
            intent.putExtra("encargado", lista.get(pos))
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_encargado)

        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleEncargado)

        lista = ArrayList()
        lista.add( Encargado("Encargado 1", Date()) )
        lista.add( Encargado("Encargado 2", Date()) )


        val fragmentLista = supportFragmentManager.findFragmentById(R.id.fragmentoListaEncargados) as ListaDeEncargadosFragment
        fragmentLista.lista = lista

        if (fragment != null) {
            (fragment as DetalleDeEncargadoFragment).darDetalle(lista.get(0))
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

package co.edu.uniquindio.android.electiva.proyecto.activity.CServicio

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.CServicio.DetalleDeCservicioFragment
import co.edu.uniquindio.android.electiva.proyecto.fragment.CServicio.ListaDeCServiciosFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Cservicio
import java.util.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de CServicios
 * @author caflorezvi
 */
class CServiciosActivity : AppCompatActivity(), ListaDeCServiciosFragment.OnCServicioSeleccionadoListener {

    lateinit var lista:ArrayList<Cservicio>
    var fragment:Fragment? = null

    /**
     * Método que devuelve la posición que se seleccionó en el recyclerview
     */
    override fun onCServicioSeleccionado(pos: Int) {

        if (fragment != null) {
            (fragment as DetalleDeCservicioFragment).darDetalle(lista[pos])
        }else{
            var intent:Intent = Intent(this, DetalleCservicioActivity::class.java)
            intent.putExtra("cservicio", lista.get(pos))
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cservicio)

        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleCServicio)

        lista = ArrayList()
        lista.add( Cservicio("CServicio 1", Date()) )
        lista.add( Cservicio("CServicio 2", Date()) )


        val fragmentLista = supportFragmentManager.findFragmentById(R.id.fragmentoListaCServicios) as ListaDeCServiciosFragment
        fragmentLista.lista = lista

        if (fragment != null) {
            (fragment as DetalleDeCservicioFragment).darDetalle(lista.get(0))
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

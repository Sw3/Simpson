package co.edu.uniquindio.android.electiva.proyecto.activity.Cliente

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.fragment.Cliente.DetalleDeClienteFragment
import co.edu.uniquindio.android.electiva.proyecto.fragment.Cliente.ListaDeClientesFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import java.util.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de Clientes
 * @author caflorezvi
 */
class ClientesActivity : AppCompatActivity(), ListaDeClientesFragment.OnClienteSeleccionadoListener {

    lateinit var lista:ArrayList<Cliente>
    var fragment:Fragment? = null

    /**
     * Método que devuelve la posición que se seleccionó en el recyclerview
     */
    override fun onClienteSeleccionado(pos: Int) {

        if (fragment != null) {
            (fragment as DetalleDeClienteFragment).darDetalle(lista[pos])
        }else{
            var intent:Intent = Intent(this, DetalleClienteActivity::class.java)
            intent.putExtra("cliente", lista.get(pos))
            startActivity(intent)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)

        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleCliente)

        lista = ArrayList()
        lista.add( Cliente("Cliente 1", Date()) )
        lista.add( Cliente("Cliente 2", Date()) )


        val fragmentLista = supportFragmentManager.findFragmentById(R.id.fragmentoListaClientes) as ListaDeClientesFragment
        fragmentLista.lista = lista

        if (fragment != null) {
            (fragment as DetalleDeClienteFragment).darDetalle(lista.get(0))
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

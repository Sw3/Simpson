package co.edu.uniquindio.android.electiva.proyecto.activity.Cliente

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.activity.Encargado.EncargadosActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.Login.LoginActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.Servicio.ServiciosActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.Solicitud.SolicitudsActivity
import co.edu.uniquindio.android.electiva.proyecto.fragment.Cliente.DetalleDeClienteFragment
import co.edu.uniquindio.android.electiva.proyecto.fragment.Cliente.ListaDeClientesFragment
import co.edu.uniquindio.android.electiva.proyecto.util.Sesion
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import kotlinx.android.synthetic.main.activity_encargado.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de Clientes
 * @author caflorezvi
 */
class ClientesActivity : AppCompatActivity(), ListaDeClientesFragment.OnClienteSeleccionadoListener, NavigationView.OnNavigationItemSelectedListener {

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

        //navigation view

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        val toggle = ActionBarDrawerToggle(this, drawer_layout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        navview.itemIconTintList = null
        navview.setNavigationItemSelectedListener(this)

        //finNavigation
        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleCliente)

        lista = ArrayList()


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

    /**
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }
**/
    //metodos navigationView
    fun reemplazarFragmento(act: Activity) {
        var intent:Intent = Intent(this, act::class.java)
        startActivity(intent)
    }
    fun mostrarMensaje(mensaje:String){
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_seccion_1 -> reemplazarFragmento(ClientesActivity())
            R.id.menu_seccion_2 -> reemplazarFragmento(EncargadosActivity())
            R.id.menu_seccion_3 -> reemplazarFragmento(ServiciosActivity())
            R.id.menu_seccion_4 -> reemplazarFragmento(SolicitudsActivity())
            R.id.menu_opcion_1 -> {
                Sesion.cerrarSesion()
                var intent:Intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
        item.isChecked = true
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> {
                drawer_layout.openDrawer(GravityCompat.START)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    //fin navview
}

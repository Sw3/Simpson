package co.edu.uniquindio.android.electiva.proyecto.activity.Servicio

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
import co.edu.uniquindio.android.electiva.proyecto.Dao.Repository
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.activity.Cliente.ClientesActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.Encargado.EncargadosActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.Solicitud.SolicitudsActivity
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicio.DetalleDeServicioFragment
import co.edu.uniquindio.android.electiva.proyecto.fragment.Servicio.ListaDeServiciosFragment
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.activity_encargado.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Actividad principal de la aplicación, contiene un recycler view de Servicios
 * @author caflorezvi
 */
class ServiciosActivity : AppCompatActivity(), ListaDeServiciosFragment.OnServicioSeleccionadoListener,  NavigationView.OnNavigationItemSelectedListener {

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
        fragment = supportFragmentManager.findFragmentById(R.id.fragmentoDetalleServicio)

        lista = Repository().ListServicios()

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

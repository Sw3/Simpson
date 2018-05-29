package co.edu.uniquindio.android.electiva.proyecto.activity.Login

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.Toast
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.activity.CServicio.CServiciosActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.CSolicitud.CSolicitudsActivity
import co.edu.uniquindio.android.electiva.proyecto.util.Sesion
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import kotlinx.android.synthetic.main.activity_cli_bienvenido.*


class CliBienvenidoActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var sesion : Sesion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cli_bienvenido)

        //navigation view

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        val toggle = ActionBarDrawerToggle(this, drawer_layout,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        navview.itemIconTintList = null
        navview.setNavigationItemSelectedListener(this)
        //Sesion.clienteSesion
        val cli : Cliente = Sesion.clienteSesion!!
        textView2.text = cli.nombre

        //finNavigation
    }

    //metodos navigationView
    fun reemplazarFragmento(act: Activity) {
        var intent: Intent = Intent(this, act::class.java)
        startActivity(intent)
    }
    fun mostrarMensaje(mensaje:String){
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_seccion_5 -> reemplazarFragmento(CServiciosActivity())
            R.id.menu_seccion_6 -> reemplazarFragmento(CSolicitudsActivity())
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

package co.edu.uniquindio.android.electiva.proyecto.activity.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import kotlinx.android.synthetic.main.activity_registrarse.*
import kotlinx.android.synthetic.main.fragment_agregar_cliente.view.*

class RegistrarseActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var managerFB : ManagerFireBase


    override fun onClick(p0: View?) {

        val nombre:String = cliente_registro_nombre.text.toString()
        val cedula:String = cliente_registro_cedula.text.toString()
        val email:String = cliente_registro_email.text.toString()
        val dependencia:String = cliente_registro_dependencia.text.toString()
        val telefono:String = cliente_registro_telefono.text.toString()

        managerFB = ManagerFireBase.instant!!
        managerFB!!.insertarCliente(Cliente(nombre,cedula,"cli",email,dependencia,telefono, ""))

        var intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        btn_registro_cliente.setOnClickListener(this)
    }
}

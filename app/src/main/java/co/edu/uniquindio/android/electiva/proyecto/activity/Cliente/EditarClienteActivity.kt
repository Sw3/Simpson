package co.edu.uniquindio.android.electiva.proyecto.activity.Cliente

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import kotlinx.android.synthetic.main.activity_editar_cliente.*

class EditarClienteActivity : AppCompatActivity(), View.OnClickListener {


    lateinit var managerFB : ManagerFireBase
    lateinit var cliente: Cliente

    override fun onClick(p0: View?) {

        cliente.cedula = cliente_editar_cedula.text.toString()
        cliente.telefono = cliente_editar_telefono.text.toString()
        cliente.dependencia = cliente_editar_dependencia.text.toString()
        cliente.nombre = cliente_editar_nombre.text.toString()
        cliente.email = cliente_editar_email.text.toString()

        managerFB = ManagerFireBase.instant!!
        managerFB.editarCliente(cliente)

        var intent: Intent = Intent(this, ClientesActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_cliente)

        cliente = intent.getParcelableExtra<Cliente>("cliente")

        cliente_editar_cedula.setText(cliente.cedula)
        cliente_editar_telefono.setText(cliente.telefono)
        cliente_editar_dependencia.setText(cliente.dependencia)
        cliente_editar_nombre.setText(cliente.nombre)
        cliente_editar_email.setText(cliente.email)

        btn_editar_cliente.setOnClickListener(this)
    }
}

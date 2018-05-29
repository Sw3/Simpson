package co.edu.uniquindio.android.electiva.proyecto.activity.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.util.Sesion
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import com.facebook.internal.Utility.arrayList
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), View.OnClickListener, ManagerFireBase.ActualizarAdaptadorCliente {
    override fun onActualizarAdaptador(cliente: Cliente) {
        clientes.add(cliente)
    }

    lateinit var clientes : ArrayList<Cliente>
    lateinit var managerFB : ManagerFireBase



    override fun onClick(v: View?) {
        if(v?.id == registrarse.id){
            var intent = Intent(this, RegistrarseActivity::class.java)
            startActivity(intent)
        }
        else{
            clientes.forEach{
                if(it.email == email.text.toString() && it.cedula == password.text.toString()){
                    Sesion.instanciar(it)
                    if(it.tipo == "cli"){
                        var intent = Intent(this, CliBienvenidoActivity::class.java)
                        startActivity(intent)
                    }else{
                        var intent = Intent(this, AdmBienvenidoActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        }

    }

    fun crearCliente(){
        managerFB.insertarCliente(Cliente("usr2", "123", "adm", "1@1.com","ing","123",""))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        clientes = arrayList()
        ManagerFireBase.instanciar(Fragment())
        managerFB = ManagerFireBase.instant!!
        //crearCliente()
        managerFB.listenerCliente = this
        managerFB.escucharFireBaseCliente()
        Sesion.clienteSesion = null
        email_sign_in_button.setOnClickListener(this)
        registrarse.setOnClickListener(this)

    }
}

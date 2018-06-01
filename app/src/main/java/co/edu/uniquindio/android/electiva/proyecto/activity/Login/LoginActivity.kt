package co.edu.uniquindio.android.electiva.proyecto.activity.Login

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.util.Sesion
import co.edu.uniquindio.android.electiva.proyecto.util.Utilidades
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.internal.Utility.arrayList
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity(), View.OnClickListener, ManagerFireBase.ActualizarAdaptadorCliente, ManagerFireBase.ActualizarAdaptadorServicio {
    override fun onActualizarAdaptador(servicio: Servicio) {
        Sesion.addServicio(servicio)
    }


    override fun onActualizarAdaptador(cliente: Cliente) {
        Sesion.addCliente(cliente)
    }


    lateinit var managerFB : ManagerFireBase
    lateinit var callbackManager: CallbackManager


    override fun onClick(v: View?) {
        if(v?.id == registrarse.id){
            var intent = Intent(this, RegistrarseActivity::class.java)
            startActivity(intent)
        }
        else{
            Sesion.clientes.forEach{
                if(it.email == email.text.toString() && it.cedula == password.text.toString()){
                    Sesion.instanciar(it)
                    //inicia escuchadores
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        ManagerFireBase.instanciar(Fragment())
        managerFB = ManagerFireBase.instant!!
        //crearCliente()
        managerFB.listenerCliente = this
        managerFB.listenerServicio = this
        managerFB.escucharFireBaseCliente()
        managerFB.escucharFireBaseServicio()
        Sesion.clienteSesion = null
        email_sign_in_button.setOnClickListener(this)
        registrarse.setOnClickListener(this)
        //Twitter
        Utilidades.inicializarTwitter(this)
        //Facebook
        callbackManager = CallbackManager.Factory.create()
        LoginManager.getInstance().registerCallback( callbackManager ,
                object : FacebookCallback<LoginResult> {
                    override fun onSuccess (loginResult: LoginResult) {
                        // App code
                    }
                    override fun onCancel () {
                        // App code
                    }
                    override fun onError (exception: FacebookException) {
                        // App code
                    }
                })
    }
}

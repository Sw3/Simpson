package co.edu.uniquindio.android.electiva.proyecto.activity.Encargado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.activity.Servicio.ServiciosActivity
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import kotlinx.android.synthetic.main.activity_editar_encargado.*


class EditarEncargado : AppCompatActivity(), View.OnClickListener {

    lateinit var managerFB : ManagerFireBase
    lateinit var encargado : Encargado

    override fun onClick(p0: View?) {
        managerFB = ManagerFireBase.instant!!
        encargado.nombre = encargado_editar_nombre.text.toString()
        encargado.telefono = encargado_editar_telefono.text.toString()
        encargado.cedula = encargado_editar_cedula.text.toString()
        managerFB!!.editarEncargado(encargado)

        var intent: Intent = Intent(this,EncargadosActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_encargado)

        encargado = intent.getParcelableExtra<Encargado>("encargado")
        encargado_editar_nombre.setText(encargado.nombre)
        encargado_editar_cedula.setText(encargado.cedula)
        encargado_editar_telefono.setText(encargado.telefono)
        btn_edicion_encargado.setOnClickListener(this)
    }
}

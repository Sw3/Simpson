package co.edu.uniquindio.android.electiva.proyecto.activity.Servicio

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import kotlinx.android.synthetic.main.activity_editar_servicio.*

class EditarServicio : AppCompatActivity(), View.OnClickListener {

    lateinit var servicio : Servicio
    lateinit var managerFB : ManagerFireBase


    override fun onClick(p0: View?) {
        managerFB = ManagerFireBase.instant!!
        servicio.nombre = servicio_editar_nombre.text.toString()
        servicio.descripcion = servicio_editar_descripcion.text.toString()
        servicio.horario = servicio_editar_horario.text.toString()
        servicio.tipoServicio=servicio_editar_tipo.text.toString()
        servicio.ubicacion = servicio_editar_ubicacion.text.toString()

        managerFB!!.editarServicio(servicio)
        var intent: Intent = Intent(this, ServiciosActivity::class.java)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_servicio)


        servicio = intent.getParcelableExtra<Servicio>("servicio")
        servicio_editar_nombre.setText(servicio.nombre)
        servicio_editar_descripcion.setText(servicio.descripcion)
        servicio_editar_horario.setText(servicio.horario)
        servicio_editar_tipo.setText(servicio.tipoServicio)
        servicio_editar_ubicacion.setText(servicio.ubicacion)
        btn_edicion_servicio.setOnClickListener(this)
    }

}

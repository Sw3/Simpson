package co.edu.uniquindio.android.electiva.proyecto.activity.Servicio

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio

import kotlinx.android.synthetic.main.activity_editar_servicio.*
import kotlinx.android.synthetic.main.content_editar_servicio.*

class EditarServicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_servicio)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        var servicio = intent.getParcelableExtra<Servicio>("servicio")
        servicio_editar_nombre.setText(servicio.nombre)
        servicio_editar_descripcion.setText(servicio.descripcion)
        servicio_editar_horario.setText(servicio.horario)
        servicio_editar_tipo.setText(servicio.tipoServicio)
        servicio_editar_ubicacion.setText(servicio.ubicacion)
    }

}

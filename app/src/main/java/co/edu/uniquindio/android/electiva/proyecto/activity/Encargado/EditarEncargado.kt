package co.edu.uniquindio.android.electiva.proyecto.activity.Encargado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import kotlinx.android.synthetic.main.activity_editar_encargado.*


class EditarEncargado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_encargado)

        var encargado = intent.getParcelableExtra<Encargado>("encargado")
        encargado_editar_nombre.setText(encargado.nombre)
        encargado_editar_cedula.setText(encargado.cedula)
        encargado_editar_telefono.setText(encargado.telefono)
    }
}

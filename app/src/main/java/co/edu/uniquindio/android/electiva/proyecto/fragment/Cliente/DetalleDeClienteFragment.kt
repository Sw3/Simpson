package co.edu.uniquindio.android.electiva.proyecto.fragment.Cliente


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.activity.Cliente.ClientesActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.Cliente.EditarClienteActivity
import co.edu.uniquindio.android.electiva.proyecto.activity.Encargado.EditarEncargado
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import kotlinx.android.synthetic.main.fragment_detalle_de_cliente.*

/**
 * Fragmento que muestra el detalle de un cliente
 * @author caflorezvi
 */
class DetalleDeClienteFragment : Fragment(), View.OnClickListener {

    lateinit var cliente:Cliente
    lateinit var managerFB : ManagerFireBase

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_cliente, container, false)
    }

    /**
     * Escucha el evento del click del botón y hace un intent a youtube
     */
    override fun onClick(v: View?) {
        if(v?.id == btnIrAVideo.id){
            val intent= Intent(this.context, EditarClienteActivity::class.java)
            intent.putExtra("cliente", cliente)
            startActivity(intent)
        }else{
            managerFB = ManagerFireBase.instant!!
            managerFB.borrarCliente(cliente)

            var intent = Intent(this.context, ClientesActivity::class.java)
            startActivity(intent)
        }
    }

    /**
     * Obtiene los atributos de un cliente y los muestra en la pantalla
     */
    fun darDetalle(cliente: Cliente) {
        this.cliente = cliente
        cliente_detalle_titulo.text = getString(R.string.nombre)+": "+ cliente.nombre
        cliente_detalle_cedula.text = getString(R.string.cedula)+": "+ cliente.cedula
        cliente_detalle_dependencia.text = getString(R.string.dependencia)+": "+ cliente.dependencia
        cliente_detalle_email.text =getString(R.string.mail)+": "+  cliente.email
        cliente_detalle_tipo.text =getString(R.string.tipo)+": "+ cliente.tipo
        cliente_detalle_telefono.text =getString(R.string.telefono)+": "+ cliente.telefono
        btnIrAVideo.setOnClickListener(this)
        btnEliminarCliente.setOnClickListener(this)
    }

}

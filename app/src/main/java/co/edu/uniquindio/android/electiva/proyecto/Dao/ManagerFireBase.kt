package co.edu.uniquindio.android.electiva.proyecto.Dao

import android.support.v4.app.Fragment
import android.util.Log
import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud
import com.google.firebase.database.*

object ManagerFireBase {

    //Variables globales
    var database: FirebaseDatabase? = null
    var dataRef: DatabaseReference? = null
    var instant: ManagerFireBase? = null
    var fragment: Fragment? = null
    var listenerServicio: ActualizarAdaptadorServicio? = null
    var listenerCliente: ActualizarAdaptadorCliente? = null
    var listenerEncargado: ActualizarAdaptadorEncargado? = null
    var listenerSolicitud: ActualizarAdaptadorSolicitud? = null

    //inicializador
    private fun inicializar(fragment: Fragment): ManagerFireBase {
        val instant = ManagerFireBase
        instant!!.database = FirebaseDatabase.getInstance()
        instant!!.dataRef = database!!.reference
        instant!!.fragment = fragment
        return instant!!
    }

    fun instanciar(fragment: Fragment) {
        if (instant == null) {
            instant = inicializar(fragment)
        }
    }

    //insertores
    fun insertarServicio(servicio: Servicio) {
        dataRef!!.child("servicio").push().setValue(servicio)
    }

    fun insertarEncargado(encargado: Encargado) {
        dataRef!!.child("encargado").push().setValue(encargado)
    }

    fun insertarCliente(cliente: Cliente) {
        dataRef!!.child("cliente").push().setValue(cliente)
    }

    fun insertarSolicitud(solicitud: Solicitud) {
        dataRef!!.child("solicitud").push().setValue(solicitud)
    }

    //editores

    fun editarCliente(cliente: Cliente) {
        dataRef!!.child("cliente").child(cliente.id.toString()).setValue(cliente)
    }

    fun editarSolicitud(solicitud: Solicitud) {
        dataRef!!.child("solicitud").child(solicitud.id.toString()).setValue(solicitud)
    }

    fun editarEncargado(encargado: Encargado) {
        dataRef!!.child("encargado").child(encargado.id.toString()).setValue(encargado)
    }
    fun editarServicio(servicio: Servicio) {
        dataRef!!.child("servicio").child(servicio.id.toString()).setValue(servicio)
    }

    //eliminadores
    fun borrarEncargado(encargado: Encargado){
        dataRef!!.child("encargado").child(encargado.id).removeValue()
    }
    fun borrarServicio(servicio: Servicio){
        dataRef!!.child("servicio").child(servicio.id).removeValue()
    }

    fun borrarSolicitud(solicitud: Solicitud) {
        dataRef!!.child("solicitud").child(solicitud.id).removeValue()
    }
    fun borrarCliente(cliente: Cliente) {
        dataRef!!.child("cliente").child(cliente.id).removeValue()
    }


    //Ecuchadores de objetos
    fun escucharFireBaseServicio() {
        dataRef!!.child("servicio").addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                Log.v("ManagerFire", "onChildChanged")
            }

            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val servicio: Servicio =
                        p0!!.getValue(Servicio::class.java)!!
                servicio.id = p0!!.key
                listenerServicio!!.onActualizarAdaptador(servicio)
            }

            override fun onChildRemoved(p0: DataSnapshot?) {
            }
        })
    }

    fun escucharFireBaseCliente() {
        dataRef!!.child("cliente").addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                Log.v("ManagerFire", "onChildChanged")
            }
            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val cliente: Cliente =
                        p0!!.getValue(Cliente::class.java)!!
                cliente.id = p0!!.key
                listenerCliente!!.onActualizarAdaptador(cliente)
            }

            override fun onChildRemoved(p0: DataSnapshot?) {
            }
        })
    }

    fun escucharFireBaseEncargado() {
        dataRef!!.child("encargado").addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                Log.v("ManagerFire", "onChildChanged")
            }

            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val encargado: Encargado =
                        p0!!.getValue(Encargado::class.java)!!
                encargado.id = p0!!.key
                listenerEncargado!!.onActualizarAdaptador(encargado)
            }

            override fun onChildRemoved(p0: DataSnapshot?) {
            }
        })
    }

    fun escucharFireBaseSolicitud() {
        dataRef!!.child("solicitud").addChildEventListener(object : ChildEventListener {
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                Log.v("ManagerFire", "onChildChanged")
            }

            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val solicitud: Solicitud =
                        p0!!.getValue(Solicitud::class.java)!!
                solicitud.id = p0!!.key
                listenerSolicitud!!.onActualizarAdaptador(solicitud)
            }

            override fun onChildRemoved(p0: DataSnapshot?) {

            }
        })
    }

    //Interfaces de escucha
    interface ActualizarAdaptadorServicio {
        fun onActualizarAdaptador(servicio: Servicio)
    }

    interface ActualizarAdaptadorCliente {
        fun onActualizarAdaptador(cliente: Cliente)
    }

    interface ActualizarAdaptadorEncargado {
        fun onActualizarAdaptador(encargado: Encargado)
    }

    interface ActualizarAdaptadorSolicitud {
        fun onActualizarAdaptador(solicitud: Solicitud)
    }
}
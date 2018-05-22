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
    var listenerServicio: ActualizarAdaptadorServicio?= null
    var listenerCliente: ActualizarAdaptadorCliente?= null
    var listenerEncargado: ActualizarAdaptadorEncargado?= null
    var listenerSolicitud: ActualizarAdaptadorSolicitud?= null

    //inicializador
    private fun inicializar(fragment: Fragment):ManagerFireBase{
        val instant = ManagerFireBase
        instant!!.database= FirebaseDatabase.getInstance()
        instant!!.dataRef = database!!.reference
        instant!!.fragment = fragment
        return instant!!
    }
    fun instanciar(fragment: Fragment){
        if( instant == null ){
            instant = inicializar(fragment)
        }
    }
    fun insertarServicio(servicio:Servicio){
        dataRef!!.push().setValue(servicio)
    }
    fun insertarEncargado(encargado: Encargado){
        dataRef!!.push().setValue(encargado)
    }
    fun insertarCliente(cliente: Cliente){
        dataRef!!.push().setValue(cliente)
    }
    fun insertarSolicitud(solicitud: Solicitud){
        dataRef!!.push().setValue(solicitud)
    }


    //Ecuchadores de objetos
    fun escucharFireBaseServicio(){
        dataRef!!.addChildEventListener(object: ChildEventListener {
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                Log.v("ManagerFire", "onChildChanged")
            }
            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val servicio:Servicio =
                        p0!!.getValue(Servicio::class.java)!!
                servicio.id = p0!!.key
                listenerServicio!!.onActualizarAdaptador(servicio)
            }
            override fun onChildRemoved(p0: DataSnapshot?) {
            }
        })
    }
    fun escucharFireBaseCliente(){
        dataRef!!.addChildEventListener(object: ChildEventListener {
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                Log.v("ManagerFire", "onChildChanged")
            }
            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val cliente : Cliente=
                        p0!!.getValue(Cliente::class.java)!!
                cliente.id = p0!!.key
                listenerCliente!!.onActualizarAdaptador(cliente)
            }
            override fun onChildRemoved(p0: DataSnapshot?) {
            }
        })
    }

    fun escucharFireBaseEncargado(){
        dataRef!!.addChildEventListener(object: ChildEventListener {
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                Log.v("ManagerFire", "onChildChanged")
            }
            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val encargado : Encargado=
                        p0!!.getValue(Encargado::class.java)!!
                encargado.id = p0!!.key
                listenerEncargado!!.onActualizarAdaptador(encargado)
            }
            override fun onChildRemoved(p0: DataSnapshot?) {
            }
        })
    }

    fun escucharFireBaseSolicitud(){
        dataRef!!.addChildEventListener(object: ChildEventListener {
            override fun onCancelled(p0: DatabaseError?) {}
            override fun onChildMoved(p0: DataSnapshot?, p1: String?) {}
            override fun onChildChanged(p0: DataSnapshot?, p1: String?) {
                Log.v("ManagerFire", "onChildChanged")
            }
            override fun onChildAdded(p0: DataSnapshot?, p1: String?) {
                val  solicitud : Solicitud =
                        p0!!.getValue(Solicitud::class.java)!!
                solicitud.id = p0!!.key
                listenerSolicitud!!.onActualizarAdaptador(solicitud)
            }
            override fun onChildRemoved(p0: DataSnapshot?) {

            }
        })
    }

    //Interfaces de escucha
    interface ActualizarAdaptadorServicio{
        fun onActualizarAdaptador(servicio: Servicio)
    }
    interface ActualizarAdaptadorCliente{
        fun onActualizarAdaptador(cliente : Cliente)
    }
    interface ActualizarAdaptadorEncargado{
        fun onActualizarAdaptador(encargado: Encargado)
    }
    interface ActualizarAdaptadorSolicitud{
        fun onActualizarAdaptador(solicitud: Solicitud)
    }

}
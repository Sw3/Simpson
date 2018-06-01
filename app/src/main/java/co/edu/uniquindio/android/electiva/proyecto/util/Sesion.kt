package co.edu.uniquindio.android.electiva.proyecto.util

import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud

object Sesion {
    var clientes : ArrayList<Cliente> = ArrayList()
    var solicitudes : ArrayList<Solicitud> = ArrayList()
    var servicios : ArrayList<Servicio> = ArrayList()
    var encargados : ArrayList<Encargado> = ArrayList()

    var clienteSesion : Cliente? = null
    var sesion : Sesion? =null

    private fun inicializar(cliente: Cliente):Sesion{
        val sesion = Sesion
        sesion.clienteSesion = cliente
        return sesion!!
    }
    fun instanciar(cliente: Cliente){
        if(sesion==null){
            inicializar(cliente)
        }
    }
    fun cerrarSesion(){
        sesion = null
        clienteSesion = null
    }
    fun addCliente(cliente: Cliente){
        if(!clientes.contains(cliente)){
            clientes.add(cliente)
        }
    }

    fun addSolicitud(solicitud: Solicitud){
        if(!solicitudes.contains(solicitud)){
            solicitudes.add(solicitud)
        }
    }

    fun addServicio(servicio: Servicio){
        if(!servicios.contains(servicio)){
            servicios.add(servicio)
        }
    }

    fun addEncargado(encargado: Encargado){
        if(!encargados.contains(encargado)){
            encargados.add(encargado)
        }
    }
    fun buscarServicio(id:String):String{
        servicios.forEach { if(it.id==id){
        return it.nombre}
        }
        return ""
    }
    fun buscarUsuario(id:String):String{
        clientes.forEach { if(it.id==id){
            return it.nombre}
        }
        return ""
    }

}
package co.edu.uniquindio.android.electiva.proyecto.Dao

import co.edu.uniquindio.android.electiva.proyecto.vo.*
import java.util.*
import kotlin.collections.ArrayList

class Dao {

    companion object {
        /**
         * Seccion de variables
         */
        lateinit var clientes : ArrayList<Cliente>
        lateinit var encargados : ArrayList<Encargado>
        lateinit var servicios : ArrayList<Servicio>
        lateinit var solicitudes: ArrayList<Solicitud>
            private set
    }

    constructor(){
        clientes = ArrayList()
        encargados = ArrayList()
        servicios = ArrayList()
        solicitudes = ArrayList()
        fillLists()
    }
    fun fillLists(){
        clientes.add(Cliente("cliente 1", Date()))
        clientes.add(Cliente("cliente 2", Date()))

        encargados.add(Encargado("encargado 1", Date()))
        encargados.add(Encargado("encargado 2", Date()))

        servicios.add(Servicio("servicio 1", Date()))
        servicios.add(Servicio("servicio 2", Date()))

        solicitudes.add(Solicitud("solicitud 1", Date()))
        solicitudes.add(Solicitud("solicitud 2", Date()))
    }

    /**
     * Getters y setters
     */
    fun addCliente(cliente: Cliente){
        clientes.add(cliente)
    }
    fun addEncargado(encargado: Encargado){
        encargados.add(encargado)
    }
    fun addServicio(servicio: Servicio){
        servicios.add(servicio)
    }
    fun addSolicitudes(solicitud: Solicitud){
        solicitudes.add(solicitud)
    }

    fun ListClientes():ArrayList<Cliente>{
        return clientes
    }
    fun ListEncargados():ArrayList<Encargado>{
        return encargados
    }
    fun ListServicios():ArrayList<Servicio>{
        return servicios
    }
    fun ListSolicitudes():ArrayList<Solicitud>{
        return solicitudes
    }
}
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
        lateinit var csolicitudes: ArrayList<Csolicitud>
        lateinit var cservicios : ArrayList<Cservicio>
            private set
    }

    constructor(){
        clientes = ArrayList()
        encargados = ArrayList()
        servicios = ArrayList()
        solicitudes = ArrayList()
        csolicitudes = ArrayList()
        cservicios = ArrayList()
        fillLists()
    }
    fun fillLists(){
        clientes.add(Cliente("cliente 1","123","estudiante","mail@mail.com","ingenieria", "7444444",""))
        clientes.add(Cliente("cliente 2","456","profesor","mail2@mail.com","educacion", "7444444",""))


        encargados.add(Encargado("encargado 1", "123","123"))
        encargados.add(Encargado("encargado 2", "233","1273"))

        servicios.add(Servicio("servicio 1", "servicio 1", "descripcion 1", "","descripcion de servicio 1", "lunes a viernes"))
        servicios.add(Servicio("servicio 2", "servicio 2", "descripcion 2", "","descripcion de servicio 2", "solo fines de semana"))

        solicitudes.add(Solicitud("solicitud 1", Date()))
        solicitudes.add(Solicitud("solicitud 2", Date()))

        cservicios.add(Cservicio("servicio 1", "servicio 1", "descripcion 1", "","descripcion de servicio 1", "lunes a viernes"))
        cservicios.add(Cservicio("servicio 2", "servicio 2", "descripcion 2", "","descripcion de servicio 2", "solo fines de semana"))

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
    fun ListCServicios():ArrayList<Cservicio>{
        return cservicios
    }
    fun ListSolicitudes():ArrayList<Solicitud>{
        return solicitudes
    }
}
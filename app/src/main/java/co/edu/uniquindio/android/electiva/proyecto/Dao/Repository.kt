package co.edu.uniquindio.android.electiva.proyecto.Dao

import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente
import co.edu.uniquindio.android.electiva.proyecto.vo.Encargado
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud

class Repository {
    lateinit var daoImplementation : Dao

    constructor(){
        daoImplementation = Dao()
    }

    /**
     * Getters y setters
     */
    fun addCliente(cliente: Cliente){
        daoImplementation.addCliente(cliente)
    }
    fun addEncargado(encargado: Encargado){
        daoImplementation.addEncargado(encargado)
    }
    fun addServicio(servicio: Servicio){
        daoImplementation.addServicio(servicio)
    }
    fun addSolicitudes(solicitud: Solicitud){
        daoImplementation.addSolicitudes(solicitud)
    }

    fun ListClientes():ArrayList<Cliente>{
        return daoImplementation.ListClientes()
    }
    fun ListEncargados():ArrayList<Encargado>{
        return daoImplementation.ListEncargados()
    }
    fun ListServicios():ArrayList<Servicio>{
        return daoImplementation.ListServicios()
    }
    fun ListSolicitudes():ArrayList<Solicitud>{
        return daoImplementation.ListSolicitudes()
    }
}
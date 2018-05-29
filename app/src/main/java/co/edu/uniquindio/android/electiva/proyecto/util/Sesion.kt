package co.edu.uniquindio.android.electiva.proyecto.util

import co.edu.uniquindio.android.electiva.proyecto.vo.Cliente

object Sesion {
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

}
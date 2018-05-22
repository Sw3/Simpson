package co.edu.uniquindio.android.electiva.proyecto.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Clase que representa un Cliente de tipo Parcelable
 * @author caflorezvi
 */
class Encargado () : Parcelable {

    var id:String = ""
    var servicio_id = ""
    var nombre:String= ""
    var cedula: String= ""
    var telefono : String = ""

    constructor(nombre:String, cedula: String, telefono : String) : this() {
        this.nombre = nombre
        this.cedula = cedula
        this.telefono = telefono
    }
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
        id = parcel.readString()
        servicio_id = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(cedula)
        parcel.writeString(telefono)
        parcel.writeString(id)
        parcel.writeString(servicio_id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Encargado> {
        override fun createFromParcel(parcel: Parcel): Encargado {
            return Encargado(parcel)
        }

        override fun newArray(size: Int): Array<Encargado?> {
            return arrayOfNulls(size)
        }
    }


}
package co.edu.uniquindio.android.electiva.proyecto.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Clase que representa un Cliente de tipo Parcelable
 * @author caflorezvi
 */
class Cliente (var nombre:String, var cedula:String,var tipo:String,var email:String,var dependencia:String,var telefono:String,var foto:String) : Parcelable {

    var id:String = ""

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
        id = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(cedula)
        parcel.writeString(tipo)
        parcel.writeString(email)
        parcel.writeString(dependencia)
        parcel.writeString(telefono)
        parcel.writeString(foto)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cliente> {
        override fun createFromParcel(parcel: Parcel): Cliente {
            return Cliente(parcel)
        }

        override fun newArray(size: Int): Array<Cliente?> {
            return arrayOfNulls(size)
        }
    }


}
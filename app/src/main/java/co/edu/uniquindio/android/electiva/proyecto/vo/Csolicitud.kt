package co.edu.uniquindio.android.electiva.proyecto.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Clase que representa un CSolicitud de tipo Parcelable
 * @author caflorezvi
 */
class Csolicitud (var persona:String, var fecha:Date, var servicio : String, var hora : String) : Parcelable {

    var id:String = ""

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readSerializable() as Date,
            parcel.readString(),
            parcel.readString()) {
        id = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(persona)
        parcel.writeString(servicio)
        parcel.writeString(hora)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Csolicitud> {
        override fun createFromParcel(parcel: Parcel): Csolicitud {
            return Csolicitud(parcel)
        }

        override fun newArray(size: Int): Array<Csolicitud?> {
            return arrayOfNulls(size)
        }
    }


}
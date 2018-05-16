package co.edu.uniquindio.android.electiva.proyecto.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Clase que representa un CServicio de tipo Parcelable
 * @author caflorezvi
 */
class Cservicio (var nombre:String, var foto: String, var ubicacion : String, var tipoServicio : String, var descripcion:String, var horario : String ) : Parcelable {

    var id:String = ""

    constructor(parcel: Parcel) : this(
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
        parcel.writeString(foto)
        parcel.writeString(ubicacion)
        parcel.writeString(tipoServicio)
        parcel.writeString(descripcion)
        parcel.writeString(horario)
        parcel.writeString(id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Cservicio> {
        override fun createFromParcel(parcel: Parcel): Cservicio {
            return Cservicio(parcel)
        }

        override fun newArray(size: Int): Array<Cservicio?> {
            return arrayOfNulls(size)
        }
    }


}
package co.edu.uniquindio.android.electiva.proyecto.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Clase que representa un Servicio de tipo Parcelable
 * @author caflorezvi
 */
class Servicio ( ) : Parcelable {

    var id:String = ""
    var nombre: String = ""
    var foto: String = ""
    var ubicacion : String = ""
    var tipoServicio : String = ""
    var descripcion:String = ""
    var horario : String = ""

    constructor(nombre: String, foto: String, ubicacion : String,tipoServicio : String, descripcion:String, horario : String ) : this() {
        this.nombre=nombre
        this.foto=foto
        this.ubicacion=ubicacion
        this.tipoServicio = tipoServicio
        this.descripcion=descripcion
        this.horario = horario
    }
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

    companion object CREATOR : Parcelable.Creator<Servicio> {
        override fun createFromParcel(parcel: Parcel): Servicio {
            return Servicio(parcel)
        }

        override fun newArray(size: Int): Array<Servicio?> {
            return arrayOfNulls(size)
        }
    }


}
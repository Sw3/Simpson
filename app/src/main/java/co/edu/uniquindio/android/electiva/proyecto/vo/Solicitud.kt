package co.edu.uniquindio.android.electiva.proyecto.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Clase que representa un Solicitud de tipo Parcelable
 * @author caflorezvi
 */
class Solicitud () : Parcelable {

    var fecha:Date = Date()
    var id:String = ""
    var solicitante = ""
    var servicio = ""


    constructor(parcel: Parcel) : this() {
        parcel.readSerializable() as Date
        id = parcel.readString()
        solicitante = parcel.readString()
        servicio = parcel.readString()

    }

    constructor(fecha:Date, solicitante : String, servicio : String  ) : this(){
        this.fecha =fecha
        this.solicitante = solicitante
        this.servicio = servicio
    }
    constructor(fecha:Date, id: String, solicitante : String, servicio : String  ) : this(){
        this.fecha =fecha
        this.id = id
        this.solicitante = solicitante
        this.servicio = servicio
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeSerializable(fecha)
        parcel.writeString(id)
        parcel.writeString(solicitante)
        parcel.writeString(servicio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Solicitud> {
        override fun createFromParcel(parcel: Parcel): Solicitud {
            return Solicitud(parcel)
        }

        override fun newArray(size: Int): Array<Solicitud?> {
            return arrayOfNulls(size)
        }
    }

}
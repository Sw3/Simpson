package co.edu.uniquindio.android.electiva.proyecto.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Clase que representa un Cliente de tipo Parcelable
 * @author caflorezvi
 */
class Encargado (var nombre:String, var fecha:Date) : Parcelable {

    var id:String = ""
    var descripcion:String = "Descripción"
    var urlVideo:String = ""

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readSerializable() as Date) {
        id = parcel.readString()
        descripcion = parcel.readString()
        urlVideo = parcel.readString()
    }

    constructor( nombre:String, fecha:Date, id:String, descripcion:String, urlVideo:String ) : this(nombre, fecha){
        this.id = id
        this.descripcion = descripcion
        this.urlVideo = urlVideo
    }

    override fun toString(): String {
        return "[${nombre}, ${fecha.toString()}]"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeSerializable(fecha)
        parcel.writeString(id)
        parcel.writeString(descripcion)
        parcel.writeString(urlVideo)
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
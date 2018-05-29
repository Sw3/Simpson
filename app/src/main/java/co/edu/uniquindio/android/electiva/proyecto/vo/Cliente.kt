package co.edu.uniquindio.android.electiva.proyecto.vo

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Clase que representa un Cliente de tipo Parcelable
 * @author caflorezvi
 */
class Cliente () : Parcelable {

    var id:String = ""
    var nombre:String = ""
    var cedula:String = ""
    var tipo:String = ""
    var email:String = ""
    var dependencia:String = ""
    var telefono:String = ""
    var foto:String = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        nombre= parcel.readString()
        cedula= parcel.readString()
        tipo= parcel.readString()
        email= parcel.readString()
        dependencia= parcel.readString()
        telefono= parcel.readString()
        foto= parcel.readString()
    }
    constructor(nombre:String, cedula:String, tipo:String, email:String, dependencia:String, telefono:String, foto:String):this(){
        this.nombre= nombre
        this.cedula=cedula
        this.tipo=tipo
        this.email=email
        this.dependencia=dependencia
        this.telefono= telefono
        this.foto=foto
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(nombre)
        parcel.writeString(cedula)
        parcel.writeString(tipo)
        parcel.writeString(email)
        parcel.writeString(dependencia)
        parcel.writeString(telefono)
        parcel.writeString(foto)
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
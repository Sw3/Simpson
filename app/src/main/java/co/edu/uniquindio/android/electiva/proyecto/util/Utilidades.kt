package co.edu.uniquindio.android.electiva.proyecto.util

import android.content.Context
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.vo.Cservicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Csolicitud
import co.edu.uniquindio.android.electiva.proyecto.vo.Servicio
import co.edu.uniquindio.android.electiva.proyecto.vo.Solicitud
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class Utilidades {
    companion object {

        fun inicializarTwitter(context: Context){
            val conf: TwitterConfig = TwitterConfig.Builder(context)
                    .logger(DefaultLogger(Log.DEBUG))
                    .twitterAuthConfig(TwitterAuthConfig(
                            context.resources.getString(R.string.com_twitter_sdk_android_CONSUMER_KEY),
                            context.resources.getString(R.string.com_twitter_sdk_android_CONSUMER_SECRET)))
                    .debug(true).build()
            Twitter.initialize(conf)
        }

        fun getKeyHash(context: Context) {
            try {
                val info =
                        context.getPackageManager().getPackageInfo(context.getPackageName(),
                                PackageManager.GET_SIGNATURES)
                for (signature in info.signatures) {
                    val md = MessageDigest.getInstance("SHA")
                    md.update(signature.toByteArray())
                    val sign = Base64.encodeToString(md.digest(), Base64.DEFAULT)
                    Log.e("Mi clave HASH:", sign)
                }
            } catch (e: PackageManager.NameNotFoundException) {
                Log.d("prueba", "1 KeyHash Error: " + e.message)
            } catch (e: NoSuchAlgorithmException) {
                Log.d("prueba", "2 KeyHash Error: " + e.message)
            }
        }

        fun ConvertirServToCServ(servicio: Servicio): Cservicio {
            return Cservicio(servicio.nombre, servicio.foto, servicio.ubicacion, servicio.tipoServicio, servicio.descripcion, servicio.horario,servicio.id)
        }
        fun convertirSolicToCsolic(solicitud: Solicitud):Csolicitud{
            return Csolicitud(solicitud.fecha, solicitud.id, solicitud.solicitante, solicitud.servicio)
        }
    }


}
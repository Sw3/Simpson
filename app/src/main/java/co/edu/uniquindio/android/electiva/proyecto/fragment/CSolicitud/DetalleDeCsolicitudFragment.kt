package co.edu.uniquindio.android.electiva.proyecto.fragment.CSolicitud

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.edu.uniquindio.android.electiva.proyecto.Dao.ManagerFireBase
import co.edu.uniquindio.android.electiva.proyecto.R
import co.edu.uniquindio.android.electiva.proyecto.activity.CSolicitud.CSolicitudsActivity
import co.edu.uniquindio.android.electiva.proyecto.vo.Csolicitud
import com.facebook.share.widget.ShareDialog
import com.twitter.sdk.android.core.*
import com.twitter.sdk.android.tweetcomposer.TweetComposer
import kotlinx.android.synthetic.main.fragment_detalle_de_csolicitud.*
import java.net.URL

/**
 * Fragmento que muestra el detalle de un csolicitud
 * @author caflorezvi
 */
class DetalleDeCsolicitudFragment : Fragment(), View.OnClickListener {

    lateinit var csolicitud:Csolicitud
    lateinit var managerFB : ManagerFireBase
    lateinit var shareDialog: ShareDialog

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detalle_de_csolicitud, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        shareDialog = ShareDialog( activity )

        btnTuitear.setOnClickListener(this)
        twitterLoginButton.callback = object : Callback<TwitterSession>() {
            override fun success(result: Result<TwitterSession>?) {
                val session = result?.data
                Log.v("TwitterKit","${session?.userName} ${session?.userId}")
                twitterLoginButton.visibility = View.INVISIBLE
            }
            override fun failure(exception: TwitterException?) {
                Log.d("TwitterKit", "Login with Twitter failure", exception);
            }
        }

        val session = TwitterCore.getInstance().getSessionManager().getActiveSession()
        if ( session != null ){
            twitterLoginButton.visibility = View.INVISIBLE
        }

    }

    /**
     * Escucha el evento del click del botón y hace un intent a youtube
     */
    override fun onClick(v: View?) {
        if(v?.id == btnIrAVideo.id){
            managerFB = ManagerFireBase.instant!!
            managerFB.borrarCsolicitud(csolicitud)

            var intent = Intent(this.context, CSolicitudsActivity::class.java)
            startActivity(intent)
        }
        if(v?.id == btnTuitear.id ){
            try {
                val url = URL("https://www.youtube.com/watch?v=VV9IRQSxx6w")
                val builder:TweetComposer.Builder = TweetComposer.Builder(context)
                        .text(csolicitud.servicio).url(url);
                builder.show()
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        twitterLoginButton.onActivityResult(requestCode, resultCode, data)
    }

    /**
     * Obtiene los atributos de un csolicitud y los muestra en la pantalla
     */
    fun darDetalle(csolicitud: Csolicitud) {
        this.csolicitud = csolicitud
        csolicitud_detalle_titulo.text = csolicitud.servicio
        btnIrAVideo.setOnClickListener(this)
    }

}

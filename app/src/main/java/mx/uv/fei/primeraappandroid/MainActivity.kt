package mx.uv.fei.primeraappandroid

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barraProgreso = findViewById<ProgressBar>(R.id.progreso)
        barraProgreso.progress = 75
    }

    fun clickBtnEnviar(view: View?) {
        var etNombre = findViewById<EditText>(R.id.editText);
        var tvResultado = findViewById<TextView>(R.id.resultado);

        var nombreIngresado = etNombre.text;

        if (nombreIngresado.trim().isEmpty()) {
            var tvMensajeError = findViewById<TextView>(R.id.errorTexto);
            tvMensajeError.visibility = View.VISIBLE;
        }
        else {
            var saludoCompleto = "Hola mi nombre es: " + nombreIngresado;
            tvResultado.text = saludoCompleto;
            tvResultado.visibility = View.VISIBLE;

            var ivImagen = findViewById<ImageView>(R.id.imagenDinamicaDesdeDrawable);
            ivImagen.setImageResource(R.drawable.play);

            var ivImagenDesdeUrl = findViewById<ImageView>(R.id.imagenDinamicaUrl);
            Picasso.get().load("https://maxcdn.icons8.com/Share/icon/Media_Controls/play1600.png").into(ivImagenDesdeUrl);
        }
    }


    fun clickIrALista(view: View?) {
        val intent = Intent(this, EjemploListViewActivity::class.java)
        intent.putExtra("nombre", "XD")
        intent.putExtra("edad", 23)
        startActivity(intent)
    }

}

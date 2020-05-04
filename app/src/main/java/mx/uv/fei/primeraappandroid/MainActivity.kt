package mx.uv.fei.primeraappandroid

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

            var ivImagen = findViewById<ImageView>(R.id.imagen);

            ivImagen.setImageDrawable(resources.getDrawable(R.drawable.play));
        }
    }

    fun obtenerImagen(url: String): Bitmap {
        var bitmap: Bitmap;
        var imagen = khttp.get(
            url = url,
            stream = true
        );
        bitmap = BitmapFactory.decodeStream(imagen.raw);
        return bitmap;
    }
}

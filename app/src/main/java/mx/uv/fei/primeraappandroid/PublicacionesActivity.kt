package mx.uv.fei.primeraappandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray

class PublicacionesActivity : AppCompatActivity() {

    lateinit var lvPublicaciones : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_publicaciones)

        lvPublicaciones = findViewById(R.id.lvPublicaciones)

        var listaPublicaciones = arrayListOf<Publicacion>()

        doAsync {
            val (request, response, result) = "https://jsonplaceholder.typicode.com/posts"
                .httpGet()
                .responseString()

            when(result) {
                is Result.Failure -> {
                    val ex = result.getException()
                    uiThread {
                        val toast = Toast.makeText(applicationContext, ex.toString(), Toast.LENGTH_LONG)
                        toast.show()
                    }
                }
                is Result.Success -> {
                    val datos = result.get()
                    var arreglo = JSONArray(datos)
                    for (i in 0 until arreglo.length()) {
                        var cadena = arreglo[i].toString()
                        var publicacion = Publicacion(cadena)
                        listaPublicaciones.add(publicacion)
                    }
                }
            }

            uiThread {
                val adaptador = PublicacionAdaptador(applicationContext, listaPublicaciones)
                lvPublicaciones.adapter = adaptador
            }
        }


    }
}

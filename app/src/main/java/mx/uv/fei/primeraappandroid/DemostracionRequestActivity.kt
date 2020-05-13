package mx.uv.fei.primeraappandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray

class DemostracionRequestActivity : AppCompatActivity() {

    private lateinit var lvPosts : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demostracion_request)
        lvPosts = findViewById(R.id.lvPosts)
        var listaPosts = arrayListOf<Post>()

        doAsync {
            val (request, response, result) = "https://jsonplaceholder.typicode.com/posts"
                .httpGet()
                .responseString()

            when (result) {
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
                        listaPosts.add(Post(arreglo[i].toString()))
                    }
                }
            }
            uiThread {
                val adapter = PostAdapter(applicationContext, listaPosts)
                lvPosts.adapter = adapter
            }
        }


    }

}

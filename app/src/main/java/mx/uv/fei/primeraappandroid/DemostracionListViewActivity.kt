package mx.uv.fei.primeraappandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.text.DateFormatSymbols

class DemostracionListViewActivity : AppCompatActivity() {

    lateinit var lvMeses: ListView
    lateinit var meses: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demostracion_list_view)
        lvMeses = findViewById(R.id.lvMeses)
        meses = DateFormatSymbols().months
        var adaptadorMeses = ArrayAdapter(this, android.R.layout.simple_list_item_1, meses)
        lvMeses.adapter = adaptadorMeses
        lvMeses.setOnItemClickListener { parent, view, position, id ->
            val toastPadre = Toast.makeText(applicationContext, "Padre: " + parent.toString(), Toast.LENGTH_LONG)
            toastPadre.show()

            val toastVista = Toast.makeText(applicationContext, "Vista: " + view.toString(), Toast.LENGTH_LONG)
            toastVista.show()

            val toastPosicion = Toast.makeText(applicationContext, "Posicion: " + position.toString(), Toast.LENGTH_LONG)
            toastPosicion.show()

            val toastId = Toast.makeText(applicationContext, "Id: " + id.toString(), Toast.LENGTH_LONG)
            toastId.show()

            val mesPresionado = parent.getItemAtPosition(position).toString()
            val toastMes = Toast.makeText(applicationContext, "Mes presionado: " + mesPresionado, Toast.LENGTH_LONG)
            toastMes.show()

            val vista = view as TextView
            val toastMesView = Toast.makeText(applicationContext, "Mes presionado desde vista: " + vista.text, Toast.LENGTH_LONG)
            toastMesView.show()
        }
    }
}

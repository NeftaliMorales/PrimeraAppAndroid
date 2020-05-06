package mx.uv.fei.primeraappandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import java.text.DateFormatSymbols

class EjemploListViewActivity : AppCompatActivity() {

    lateinit var lvMeses: ListView
    lateinit var meses: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ejemplo_list_view)

        lvMeses = findViewById(R.id.lvMeses)
        meses = DateFormatSymbols().months

        var adaptadorMeses = ArrayAdapter(this, android.R.layout.simple_list_item_1, meses)
        lvMeses.adapter = adaptadorMeses
    }
}

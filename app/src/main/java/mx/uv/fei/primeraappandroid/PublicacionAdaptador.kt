package mx.uv.fei.primeraappandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PublicacionAdaptador(private val context: Context, private val dataSource: ArrayList<Publicacion>) : BaseAdapter() {

    lateinit var tvTitulo : TextView
    lateinit var tvContenido : TextView

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return dataSource[position].id.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vista = inflater.inflate(R.layout.adaptador_publicacion, parent, false)

        tvTitulo = vista.findViewById(R.id.tvTituloPublicacion)
        tvContenido = vista.findViewById(R.id.tvContenidoPublicacion)

        val publicacion = getItem(position) as Publicacion

        tvTitulo.text = publicacion.titulo
        tvContenido.text = publicacion.cuerpo

        return vista
    }
}
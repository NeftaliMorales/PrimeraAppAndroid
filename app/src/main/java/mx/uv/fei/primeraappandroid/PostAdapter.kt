package mx.uv.fei.primeraappandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PostAdapter(private val context: Context, private val dataSource: ArrayList<Post>) : BaseAdapter() {
    lateinit var tvTitulo : TextView
    lateinit var tvContenido : TextView

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return dataSource[position].id.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.adapter_post, parent, false)

        tvTitulo = rowView.findViewById(R.id.tvTitulo)
        tvContenido = rowView.findViewById(R.id.tvContenido)

        val post = getItem(position) as Post

        tvTitulo.text = post.title
        tvContenido.text = post.body

        return rowView
    }
}
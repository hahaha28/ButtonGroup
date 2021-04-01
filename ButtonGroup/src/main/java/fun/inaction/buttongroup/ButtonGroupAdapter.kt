package `fun`.inaction.buttongroup

import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text

class ButtonGroupAdapter(val list:List<ButtonGroup.Item>): RecyclerView.Adapter<ButtonGroupAdapter.ViewHolder>() {

    var itemClickListener: (Int)->Unit = {}

    var labelTextSize: Float? = null
    var labelTextColor: Int? = null
    var labelTextMarginTop: Int? = null
    var labelTextMarginBottom: Int? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView
        val textView:TextView
        init {
            imageView = itemView.findViewById(R.id.imageView)
            textView = itemView.findViewById(R.id.textView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_button_group,parent,false)
        val holder = ViewHolder(view)
        view.setOnClickListener {
            itemClickListener(holder.adapterPosition)
        }
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        item.loadImage(holder.imageView)
        holder.textView.text = item.text

        // 设置TextView的样式
        with(holder.textView){
            labelTextSize?.let { textSize = it }
            labelTextColor?.let { setTextColor(it) }
            labelTextMarginTop?.let { setPadding(paddingLeft,it,paddingRight,paddingBottom)  }
            labelTextMarginBottom?.let { setPadding(paddingLeft,paddingTop,paddingRight,it) }
//            Log.e("tag","padding top = ${paddingTop}")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setOnItemClickListener(listener:(Int)->Unit){
        itemClickListener = listener
    }

}
package `fun`.inaction.sample

import `fun`.inaction.buttongroup.ButtonGroup
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGroup = findViewById<ButtonGroup>(R.id.buttonGroup)
//        val imageView = findViewById<ImageView>(R.id.imageView2)
//        imageView.setImageResource(R.drawable.default_avatar)
//        var i = 1;
//        imageView.setOnClickListener {
//            when(i%3){
//                0 -> imageView.setImageResource(R.drawable.default_avatar)
//                1 -> imageView.setImageResource(R.drawable.s)
//                2 -> imageView.setImageResource(R.drawable.ss)
//            }
//            i++
//        }
        buttonGroup.setData(listOf(
            ButtonGroup.Item(R.drawable.ic_collect, "收藏"),
            ButtonGroup.Item(R.drawable.ic_mark, "标记"),
            ButtonGroup.Item(R.drawable.ic_history, "历史"),
            ButtonGroup.Item(R.drawable.ic_near, "附近"),
            ButtonGroup.Item(R.drawable.ic_report, "上报"),

            ))
        buttonGroup.setOnItemClickListener {
            Log.e("tag","click ${it}")
        }

    }
}
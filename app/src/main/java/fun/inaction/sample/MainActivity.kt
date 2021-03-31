package `fun`.inaction.sample

import `fun`.inaction.buttongroup.ButtonGroup
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            ButtonGroup.Item(R.drawable.default_avatar,"风车"),
            ButtonGroup.Item(R.drawable.default_avatar,"风车"),
            ButtonGroup.Item(R.drawable.default_avatar,"风车"),
            ButtonGroup.Item(R.drawable.icon,"风车"),
            ButtonGroup.Item(R.drawable.icon,"风车"),
            ButtonGroup.Item(R.drawable.icon,"风车"),
            ButtonGroup.Item(R.drawable.icon,"风车")

            ))

    }
}
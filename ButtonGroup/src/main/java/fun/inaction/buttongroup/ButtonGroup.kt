package `fun`.inaction.buttongroup

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ButtonGroup : FrameLayout {

    private lateinit var recyclerView: RecyclerView

    /**
     * 一行有几个子项
     */
    var spanCount :Int = 5
        set(value) {
            field = value
            itemDecoration.spanCount = value
        }

    /**
     * 子项的水平间距（等间距）
     */
    var horizontalSpace: Int = 0
        set(value) {
            field = value
            itemDecoration.horizontalSpace = value
        }

    /**
     * 子项的垂直间距（等间距）
     */
    var verticalSpace = 0
        set(value) {
            field = value
            itemDecoration.verticalSpace = value
        }

    /**
     * 标签文字大小，单位为 sp
     */
    var labelTextSize:Float = 18f
        set(value) {
            field = value
            adapter.labelTextSize = 18f
        }

    /**
     * 标签文字颜色
     */
    var labelTextColor: Int = Color.parseColor("#000000")
        set(value) {
            field = value
            adapter.labelTextColor = value
        }

    /**
     * 标签距离顶部的距离
     */
    var labelTextMarginTop:Int = dp2px(18f).toInt()
        set(value){
            field = value
            adapter.labelTextMarginTop = value
        }

    /**
     * 标签距离底部的距离
     */
    var labelTextMarginBottom:Int = 0
        set(value) {
            field = value
            adapter.labelTextMarginBottom = value
        }

    /**
     * 实现等间距的东西
     */
    private val itemDecoration = GridLayoutSpaceItemDecoration(0, 0, spanCount)

    private var dataList: MutableList<Item> = mutableListOf()
    private var adapter = ButtonGroupAdapter(dataList)

    constructor(context: Context):this(context,null)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {

        // 获取xml属性值
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ButtonGroup)
        spanCount = typedArray.getInteger(R.styleable.ButtonGroup_spanCount, 5)
        horizontalSpace = typedArray.getDimension(R.styleable.ButtonGroup_horizontalSpace, 0f).toInt()
        verticalSpace = typedArray.getDimension(R.styleable.ButtonGroup_verticalSpace, 0f).toInt()
        labelTextMarginTop = typedArray.getDimension(R.styleable.ButtonGroup_labelMarginTop,dp2px(16f)).toInt()
//        Log.e("tag","marginTop = ${labelTextMarginTop}")
        labelTextMarginBottom = typedArray.getDimension(R.styleable.ButtonGroup_labelMarginBottom,0f).toInt()

        init(context)
    }

    /**
     * 初始化
     */
    private fun init(context: Context) {
        recyclerView = RecyclerView(context)
        recyclerView.overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        addView(recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, spanCount)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(itemDecoration)
    }

    /**
     * 设置数据
     */
    fun setData(itemList: List<Item>){
        dataList.addAll(itemList)
        adapter.notifyDataSetChanged()
    }


    /**
     * 子项数据类
     */
    class Item{
        var resourceId:Int? = null
        var url:String? = null
        var text:String = ""

        constructor(url: String, text: String) {
            this.url = url
            this.text = text
        }

        constructor(resourceId: Int, text: String) {
            this.resourceId = resourceId
            this.text = text
        }

        fun loadImage(imageView: ImageView){
            if(url != null){
                Glide.with(imageView)
                    .load(url)
                    .into(imageView)
            }else if(resourceId != null){
                Glide.with(imageView)
                    .load(resourceId)
                    .into(imageView)
            }
        }

    }

    fun dp2px(dp: Float):Float{

        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dp,
            resources.displayMetrics
        )
    }



}
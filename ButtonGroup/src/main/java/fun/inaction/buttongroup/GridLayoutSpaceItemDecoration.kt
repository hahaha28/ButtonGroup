package `fun`.inaction.buttongroup

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class GridLayoutSpaceItemDecoration(
    var horizontalSpace: Int,
    var verticalSpace: Int,
    var spanCount: Int
) : RecyclerView.ItemDecoration() {

    private val horizontalMarginSum:Float
        get() = horizontalSpace + horizontalSpace.toFloat()/spanCount


    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        // 设置水平间距
        val position = parent.getChildAdapterPosition(view)
        val column = position%spanCount+1

        outRect.left = (column*horizontalSpace-(column-1)*horizontalMarginSum).toInt();
        outRect.right = (column*(horizontalMarginSum-horizontalSpace)).toInt()

        // 设置垂直间距
        if(position < spanCount){
            // 顶部一排
            outRect.top = verticalSpace
        }
        outRect.bottom = verticalSpace
    }
}
package com.scookie.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class GridSpacingItemDecoration(
    private val spanCount: Int,
    private val spacing: Int,
    private val includeEdge: Boolean = false
) : ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        val column = position % spanCount

        if (includeEdge) {
            outRect.updateIncludingEdge(position, column)
        } else {
            outRect.updateNotIncludingEdge(position, column)
        }
    }

    private fun Rect.updateIncludingEdge(position: Int, column: Int) {
        left = spacing - column * spacing / spanCount
        right = (column + 1) * spacing / spanCount

        if (position < spanCount) {
            top = spacing
        }
    }

    private fun Rect.updateNotIncludingEdge(position: Int, column: Int) {
        left = column * spacing / spanCount
        right = spacing - (column + 1) * spacing / spanCount

        if (position >= spanCount) {
            top = spacing
        }
    }
}
package com.example.hamburgermenu.decorator;
import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class HorizontalCardPaddingDecoration extends RecyclerView.ItemDecoration {
    private final int horizontalSpaceWidth;

    public HorizontalCardPaddingDecoration(int horizontalSpaceWidth) {
        this.horizontalSpaceWidth = horizontalSpaceWidth;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        // Apply horizontal spacing to all items except the first item
        if (parent.getChildAdapterPosition(view) != 0) {
            outRect.left = horizontalSpaceWidth;
        }
    }
}

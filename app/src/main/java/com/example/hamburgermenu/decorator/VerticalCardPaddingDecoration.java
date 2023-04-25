package com.example.hamburgermenu.decorator;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class VerticalCardPaddingDecoration extends RecyclerView.ItemDecoration {
    private final int nPadding;

    public VerticalCardPaddingDecoration(int Padding) {
        this.nPadding = Padding;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(nPadding, nPadding, nPadding, nPadding);
    }
}

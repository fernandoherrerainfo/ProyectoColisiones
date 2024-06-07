package mx.fca.aviones;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class GridItemDecoration extends RecyclerView.ItemDecoration{

    private final int size;
    private final Paint paint;

    public GridItemDecoration(int size, int color) {
        this.size = size;
        paint = new Paint();
        paint.setColor(color);
        paint.setStrokeWidth(size);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.set(size, size, size, size);
    }

    @Override
    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        int childCount = parent.getChildCount();
        int width = parent.getWidth();
        int height = parent.getHeight();
        int numColumns = ((GridLayoutManager) parent.getLayoutManager()).getSpanCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            int left = child.getLeft();
            int top = child.getTop() - 10;
            int right = child.getRight();
            int bottom = child.getBottom();

            // Draw the bottom line
            canvas.drawLine(left, bottom, right, bottom, paint);
            // Draw the right line
            canvas.drawLine(right, top, right, bottom, paint);

            // If first row, draw the top line
            //if (i < numColumns) {
             //   canvas.drawLine(left, top, right, top, paint);
           // }
            // If first column, draw the left line
           // if (i % numColumns == 0) {
                canvas.drawLine(left, top, left, bottom, paint);
            //}
        }
    }


}

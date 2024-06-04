package mx.fca.aviones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class AvionAdapter extends RecyclerView.Adapter<AvionHolder> {
    //Ningun cambio

    Plano plano;

    private int gridSize;

    public AvionAdapter(Plano plano, int gridSize) {

        this.plano = plano;
        this.gridSize = gridSize;
    }

    @NonNull
    @Override
    public AvionHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.avion_view, parent, false);
        return new AvionHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AvionHolder holder, int position) {
        // Calcular la fila y columna basadas en la posición
        int row = position / gridSize;
        int col = position % gridSize;

        boolean collision = false;

        // Verificar si hay un avión en la posición actual y si hay colisión
        for (Avion avion : plano.getAviones()) {
            if (avion.getX() == col && avion.getY() == row) {
                holder.imgAvion.setImageResource(avion.getImage());
                holder.imgAvion.setVisibility(View.VISIBLE);

                // Verificar colisión
                for (Avion otherAvion : plano.getAviones()) {
                    if (avion != otherAvion && avion.getX() == otherAvion.getX() && avion.getY() == otherAvion.getY()) {
                        collision = true;
                        break;
                    }
                }

                if (collision) {
                    holder.imgCollision.setVisibility(View.VISIBLE);
                    holder.imgAvion.setVisibility(View.GONE);
                } else {
                    holder.imgCollision.setVisibility(View.GONE);
                }

                return;
            }
        }

        holder.imgAvion.setVisibility(View.INVISIBLE);
        holder.imgCollision.setVisibility(View.GONE);
    }

    @Override
    public int getItemCount() {
        return gridSize * gridSize;
    }
}

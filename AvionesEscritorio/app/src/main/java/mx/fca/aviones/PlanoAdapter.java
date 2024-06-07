package mx.fca.aviones;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlanoAdapter extends RecyclerView.Adapter<AvionHolder> {
    //Ningun cam

    Plano plano;

    public PlanoAdapter(Plano plano) {
        this.plano = plano;
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
        // Verificar si hay un avión en la posición actual y si hay colisión

        int maxCol = plano.col;
        int maxRow = plano.row;

        int x = (position % maxRow) - 1;
        int y = (position / maxCol);

        Avion avion = plano.getAvion(x,y);
        if (avion == null) {
            // Aqui pones imagen en blanco
            holder.imgAvion.setBackgroundColor(Color.BLACK);
            holder.imgAvion.setImageResource(0);

        } else {
            holder.imgAvion.setImageResource(avion.getImage());
        }
    }

    @Override
    public int getItemCount() {
        Plano plano = Analizador.memoria.get(0);
        assert plano != null;
        return plano.gridSize();
    }
}

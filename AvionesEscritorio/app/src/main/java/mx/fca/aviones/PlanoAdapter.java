package mx.fca.aviones;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PlanoAdapter extends RecyclerView.Adapter<AvionHolder> {
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
        int max = Analizador.maximo();

        int x = (position % (max));
        int y = (position / (max));
        if (x < 0) { x = 0; }
        if (y < 0) { y = 0; }
        if (x > (max-1)) { x = (max-1); }
        if (y > (max-1)) { y = (max-1); }

        Avion avion = plano.getAvion(x,y);
        Colision colision = plano.getColision(x, y);
        if (avion != null) {
            holder.imgAvion.setImageResource(avion.getImage());
            return;
        }
        if (colision != null){
            holder.imgAvion.setImageResource(colision.getImage());
            return;
        }
        holder.imgAvion.setImageResource(R.mipmap.ic_launcher);

    }

    @Override
    public int getItemCount() {
        // Obtiene el grid original
        Plano plano = Analizador.memoria.get(0);
        if (plano == null) { return 0; }
        return plano.gridSize();
    }
}

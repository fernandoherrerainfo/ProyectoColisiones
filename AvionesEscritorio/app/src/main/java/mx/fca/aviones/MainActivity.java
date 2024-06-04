package mx.fca.aviones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnNext, btnPrev;
    Plano plano;
    RecyclerView listaAviones;
    AvionAdapter adapter;
    TextView txvcolisiones, txvpasos;
    int pasos;
    int gridSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAviones = findViewById(R.id.listaAviones);
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        txvcolisiones = findViewById(R.id.txvcolisiones);
        txvpasos = findViewById(R.id.txvpasos);

        plano = Planificador.crearRutaInicial();
        /*adapter = new AvionAdapter(plano.aviones);
        listaAviones.setAdapter(adapter);
        listaAviones.setLayoutManager(new GridLayoutManager(this, 5));*/

        gridSize = 6;
        adapter = new AvionAdapter(plano.aviones, gridSize);
        listaAviones.setAdapter(adapter);
        listaAviones.setLayoutManager(new GridLayoutManager(this, gridSize));

        int lineColor = getResources().getColor(android.R.color.black);
        int lineSize = 2;
        listaAviones.addItemDecoration(new GridItemDecoration(lineSize, lineColor));


        pasos = 0;
        actualizarUI();

        btnNext.setOnClickListener(v -> {
            avanzar();
        });

        btnPrev.setOnClickListener(v -> {
            retroceder();
        });
    }

    private void avanzar() {
        plano = plano.next();
        pasos++;
        actualizarUI();
    }

    private void retroceder() {
        plano = plano.prev();
        if (pasos > 0) {
            pasos--;
        }
        actualizarUI();
    }

    /*private void actualizarUI() {
        adapter.aviones = plano.getAviones();
        adapter.notifyDataSetChanged();
        txvcolisiones.setText("Colisiones: " + contarColisiones(plano));
        txvpasos.setText("Pasos: " + pasos);
    }*/
    /*private void actualizarUI() {
        Planificador planificador = new Planificador(); // Crear una instancia de Planificador
        int colisiones = planificador.contarColisiones(plano); // Llamar al método en la instancia creada
        adapter.aviones = plano.getAviones();
        adapter.notifyDataSetChanged();
        txvcolisiones.setText("Colisiones: " + colisiones); // Utilizar el valor de colisiones
        txvpasos.setText("Pasos: " + pasos);
    }*/
    private void actualizarUI() {
        adapter.aviones = plano.getAviones();
        adapter.notifyDataSetChanged();
        txvcolisiones.setText("Colisiones: " + contarColisiones(plano));
        txvpasos.setText("Pasos: " + pasos);
    }
    private int contarColisiones(Plano plano) {
        /*Planificador planificador = new Planificador(); // Crear una instancia de Planificador
        return planificador.contarColisiones(plano); // Llamar al método en la instancia creada*/

        int colisiones = 0;
        ArrayList<Avion> aviones = plano.aviones;
        for (int i = 0; i < aviones.size(); i++) {
            for (int j = i + 1; j < aviones.size(); j++) {
                if (aviones.get(i).getX() == aviones.get(j).getX() && aviones.get(i).getY() == aviones.get(j).getY()) {
                    colisiones++;
                }
            }
        }
        return colisiones;
    }
}

package mx.fca.aviones;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnNext, btnPrev, btnReset;
    Plano plano;
    RecyclerView listaAviones;
    PlanoAdapter adapter;
    TextView txvcolisiones, txvpasos;
    int pasos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaAviones = findViewById(R.id.listaAviones);

        //Activity main
        btnNext = findViewById(R.id.btnNext);
        btnPrev = findViewById(R.id.btnPrev);
        btnReset = findViewById(R.id.btnReset);
        txvcolisiones = findViewById(R.id.txvcolisiones);
        txvpasos = findViewById(R.id.txvpasos);

        plano = Planificador.crearRutaInicial();
        adapter = new PlanoAdapter(plano);
        listaAviones.setAdapter(adapter);
        listaAviones.setLayoutManager(new GridLayoutManager(this, plano.col));

        int lineColor = getResources().getColor(android.R.color.black);
        int lineSize = 6;
        //listaAviones.addItemDecoration(new GridItemDecoration(lineSize, lineColor));

        pasos = 0;
        actualizarUI();

        btnNext.setOnClickListener(v -> {
            avanzar();
        });

        btnPrev.setOnClickListener(v -> {
            retroceder();
        });

        btnReset.setOnClickListener(v ->{
                reset();

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

    private void reset(){
        pasos = 0;
        plano = Analizador.memoria.get(0);
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
        adapter.plano = plano;
        adapter.notifyDataSetChanged();
        txvcolisiones.setText("Colisiones: " + Analizador.contarColisiones(plano));
        txvpasos.setText("Pasos: " + pasos);
    }

}

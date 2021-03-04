package tutoriales.codictados.mvp.iu;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import dagger.ObjectGraph;
import tutoriales.codictados.mvp.R;
import tutoriales.codictados.mvp.contratos.Contrato;
import tutoriales.codictados.mvp.dagger.ModuloApp;

public class MainActivity extends AppCompatActivity implements Contrato.Vista {


    @Inject Contrato.Presentador presentador;

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inyecta las clases con Dagger
        ObjectGraph objectGraph = ObjectGraph.create(new ModuloApp());
        objectGraph.inject(this);

        // Le dice al presenter cuál es su vista
        presentador.setVista(this);

        cargarVista();
    }


    public void cargarVista(){

        button = (Button) findViewById(R.id.button);

        // Ante un evento se llama al presenter para solicitar un texto.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presentador.solicitarTexto();
            }
        });
    }


    // El presentador obtiene el texto solicitado y hace una llamada a este método para dárselo.
    @Override
    public void mostrarTexto(String texto){
        Snackbar.make(button, texto, Snackbar.LENGTH_SHORT).show();
    }
}

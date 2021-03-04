package tutoriales.codictados.mvp.presentadores;

import tutoriales.codictados.mvp.contratos.Contrato;

public class Presentador implements Contrato.Presentador {

    private Contrato.Vista vista;

    // El presentador recibe su vista para poder llamar a sus métodos.
    @Override
    public void setVista(Contrato.Vista vista) {
        this.vista = vista;
    }

    // Cuando la vista pride al presentador el texto que necesita mostrar, llama a este método.
    @Override
    public void solicitarTexto(){
        // Se llama a un método de la vista para devolverle el texto.
        vista.mostrarTexto("Muestra este texto.");
    }
}

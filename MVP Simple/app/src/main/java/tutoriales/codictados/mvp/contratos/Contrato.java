package tutoriales.codictados.mvp.contratos;

public interface Contrato {

    interface Vista {

        void mostrarTexto(String texto);
    }

    interface Presentador {

        void setVista(Vista vista);
        void solicitarTexto();

    }
}

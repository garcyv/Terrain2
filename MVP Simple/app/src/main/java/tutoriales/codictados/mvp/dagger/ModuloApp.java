package tutoriales.codictados.mvp.dagger;

import dagger.Module;
import dagger.Provides;
import tutoriales.codictados.mvp.iu.MainActivity;
import tutoriales.codictados.mvp.contratos.Contrato;
import tutoriales.codictados.mvp.presentadores.Presentador;

@Module(injects = {MainActivity.class})
public class ModuloApp {

    @Provides
    public Contrato.Presentador provideMainActivityPresenter(){
        return new Presentador();
    }
}

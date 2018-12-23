import pkginterface.MenuInicial;
import pkgdados.DadosFacade;
//import configurafacil.ConfiguraFacil;

public class Main {
    public static void main(String[] args) {
        String user = args[1];
        String password = args[2];

        DadosFacade dados = new DadosFacade(user, password);

        //ConfiguraFacil cf = new ConfiguraFacil(dados);

        //MenuInicial menu = new MenuInicial(cf);

        // TODO: iniciar GUI
        // ...
    }
}

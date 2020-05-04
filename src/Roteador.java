import java.util.ArrayList;

public class Roteador {

    String ipv6, macAddress;
    ArrayList<Barramento> listaDeBarramentos;
    Pacote pacoteIpv6;
    String idBarramento;

    public Roteador(String macAddress, String ipv6) {
        this.macAddress = macAddress;
        this.ipv6 = ipv6;
        listaDeBarramentos = new ArrayList<>();
    }

    public void recebeMensagem(Object o, String barramento) {


    }

    public void encaminharPacote(Pacote pacoteIpv6) {


    }

    public void inserirBarramento(Barramento barramento){

        this.listaDeBarramentos.add(barramento);
    }


}

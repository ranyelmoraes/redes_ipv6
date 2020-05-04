import java.util.ArrayList;

public class Barramento implements Observable {


    ArrayList<Observer> observadores;
    ArrayList<Maquina> maquinasBarramento;
    String id;


    public Barramento(String id) {
        observadores = new ArrayList<>();
        this.id = id;
    }


    public void sendMensagemRoteador(Mensagem msg) {


    }

    public ArrayList<Maquina> getMaquinasBarramento() {

        return maquinasBarramento;
    }

    public void setMaquinasBarramento(ArrayList<Maquina> maquina) {

        this.maquinasBarramento = maquina;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public void notificar(Object msg) throws InterruptedException {

        Pacote ipv6;
        Maquina m;
        for (Observer o : observadores) {
            m = (Maquina) o;
            if (msg instanceof Pacote) {
                o.receberMensagem(msg,m.camadaRede.getNdp());
            }
        }
    }

    @Override
    public void removerMaquina(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void adicionarMaquina(Observer o) {
        observadores.add(o);
    }
}

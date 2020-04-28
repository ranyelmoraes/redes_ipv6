import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Barramento extends Observable {

    ArrayList<Maquina> maquinasBarramento;
    String id;

    public Barramento(String id) {
        maquinasBarramento = new ArrayList<>();
        this.id = id;
    }

    public void adicionarBarramento(Maquina o) {

        maquinasBarramento.add(o);
    }

    public void removerBarramento(Maquina o) {
        maquinasBarramento.remove(o);
    }


    public ArrayList<Maquina> getObservadores() {
        return maquinasBarramento;
    }

    public void setObservadores(ArrayList<Maquina> maquina) {
        this.maquinasBarramento = maquina;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    List<Maquina> maquina = new ArrayList<>();
    Maquina hostAtual;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Pacote pacote = null;
        Barramento barramento = new Barramento("m1");
        Mensagem msg = new Mensagem("TESTE", "fe80::200:5aee:feaa:20a2");
        Maquina computador1 = new Maquina("2001:0DB8:AD1F:25E2:CADE:CAFE:F0CA:32C1","00:E0:4C:24:DB:D7", barramento);
        Maquina computador2 = new Maquina("fe80::200:5aee:feaa:20a2","00:E0:4C:5A:0E:C4", barramento);

        barramento.adicionarMaquina(computador1);
        barramento.adicionarMaquina(computador2);

        computador1.enviarMensagem(msg);

    }
}

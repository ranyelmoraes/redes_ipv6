import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class CamadaRede {

    int msgID;
    String endereco;
    String gateway;
    String netID;
    NDP ndp = new NDP("00:E0:4C:5A:0E:C4");
    Roteador r1 = new Roteador(" 00:E0:4C:0B:39:21  ","2001:0DB8:0000:0000:130F:0000:0000:140B");
    ArrayList<TabelaDeRoteamento> tabelaDeRoteamento;
    Barramento barramento;

    public String getNetID() {
        return netID;
    }

    public void setNetID(String netID) {
        this.netID = netID;
    }

    public CamadaRede(String endereco,Barramento br) {
        this.barramento = br;
        this.endereco = endereco;
        this.netID = "22";

    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway;
    }


    String calcularNetID(String IPDestino) throws InterruptedException {
        System.out.println("=======================================");
        System.out.println("Realizando Operacao AND entre MASCARA e ENDERECO de ORIGEM...");
        Thread.sleep(4000);
        System.out.println("=======================================");
        System.out.println("Relizando Operacao AND entre MASCARA e ENDERECO de DESTINO...");
        Thread.sleep(4000);
        System.out.println("=======================================");
        System.out.println("Comparando resultados de Operacao...");
        Thread.sleep(4000);

        return  "22";

    }


    public String getNdp() {
        return ndp.getNeighborSolicitation();
    }


    public void enviarMensagem(Object mensagem) throws InterruptedException, ExecutionException { // Colocar essa mensagem em um pacote
        System.out.println("Camada de rede recebeu a mensagem");
        Pacote packet = new Pacote();
        String resultado;
        int i = 1;
        msgID++;

            Mensagem m = (Mensagem) mensagem;
            Boolean fazerArp = true;
            String solicitacaoNDP = "";

        if (fazerArp) {

            resultado = calcularNetID( m.getIpv6Destino());
            if (resultado.compareTo(this.netID) == 0) { // Mesma rede
                System.out.println("=======================================");
                System.out.println("ENTREGA DIRETA POIS ESTAO NA MESMA REDE");
                System.out.println("VERIFICANDO MAC ADRESS VIA ICMP PELO NDP... ");
                Thread.sleep(4000);
                solicitacaoNDP = ndp.getNeighborSolicitation();
                packet.setMACDestino(solicitacaoNDP);
                System.out.println("=======================================");

            }

            else { // Esta em outra rede (Verificar a tabela de roteamento) para pegar o ipv4 do roteador

                System.out.println("ENTREGA INDIRETA");

                for (TabelaDeRoteamento item : tabelaDeRoteamento) {

                    resultado = calcularNetID(m.getIpv6Destino());

                    if (resultado.compareTo(item.getEnderecoDeRede()) == 0) {


                    }
                }
            }

            System.out.println("Neighbor Solicitation Recebida");
            packet = criarPacote(m);
            System.out.println("=======================================");
            System.out.println("MENSAGEM A SER ENVIADA :" + packet.getMensagem());
            System.out.println("ORIGEM DO PACOTE: " + packet.getIP_Origem());
            System.out.println("DESTINO DO PACOTE: " + packet.getIP_Destino());
            System.out.println("MAC ADDRESS DESTINO: " + solicitacaoNDP);
            Thread.sleep(4000);
            barramento.notificar(packet);
        }

    }

    private Pacote criarPacote(Mensagem mensagem) {

        Pacote packet = new Pacote();
        Mensagem msg = (Mensagem) mensagem;
        packet.setCabeçalho_ipv6(mensagem,this.endereco);
        return  packet;
    }
}

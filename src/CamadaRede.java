import javax.xml.bind.SchemaOutputResolver;
import java.util.concurrent.ExecutionException;

public class CamadaRede {

    int msgID;
    String endereco;
    String gateway;
    String netID;
    NDP ndp = new NDP("00:E0:4C:5A:0E:C4");
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
        Pacote packet = new Pacote();
        String resultado;
        int i = 1;
        msgID++;

            Mensagem m = (Mensagem) mensagem;
            Boolean fazerArp = true;
            String solicitacaoNDP = "";

        if (fazerArp) { // Se arpResquest == true preciso fazer arp

            resultado = calcularNetID( m.getIpv6Destino());
            if (resultado.compareTo(this.netID) == 0) { // Mesma rede
                System.out.println("=======================================");
                System.out.println("ENTREGA DIRETA POIS ESTAO NA MESMA REDE");
                System.out.println("VERIFICANDO MAC ADRESS VIA ICMP PELO NDP...: ");
                Thread.sleep(4000);
                solicitacaoNDP = ndp.getNeighborSolicitation();
                System.out.println("=======================================");

            }

     /*       else { // Esta em outra rede (Verificar a tabela de roteamento) para pegar o ipv4 do roteador

                System.out.println("ENTREGA INDIRETA");
                System.out.println("CRIANDO PACOTE ARP: ");

                for (ItensDaTabela item : tabelaDeRoteamento) {

                    resultado = pegarNetid(item.getMascara(), m.getIpv4Destino());

                    if (resultado.compareTo(item.getEnderecoDeRede()) == 0) {

                        this.ipv4Roteador = item.getProximoSalto();
                        this.criarPacoteArp(1, ipv4, ipv4Roteador, this.enlace.getMacAddress(), "0");
                    }
                }
            }
*/
            System.out.println("Neighbor Solicitation Recebida");
            packet = criarPacote(m);
            System.out.println("MENSAGEM A SER ENVIADA :" + packet.getMensagem());
            System.out.println("ORIGEM DO PACOTE: " + packet.getIP_Origem());
            System.out.println("DESTINO DO PACOTE: " + packet.getIP_Destino());
            System.out.println("MAC ADDRESS DESTINO: " + solicitacaoNDP);
            Thread.sleep(4000);
            barramento.notificar(packet);
        }

  /*      else {       // Se a operacao for diferente de request == true , ela é repy tenho ja o macAddress do destino

            if (this.pacoteArp.getIpV4Origem().equals(this.ipv4)) {

                System.out.println("CRIANDO O PACOTE IPV4");
                ArrayList<PacoteIpv4> p = new ArrayList<>();
                PacoteIpv4 pacote = new PacoteIpv4(numeroDaMensagem, mensagemOriginal, this.ipv4, ipv4Destino, 1, this.enlace.getMtu());
                pacote.PreencherComprimentoTotal();
                pacote.setEndereçoRoteador(this.ipv4Roteador);

                p = pacote.Fragmentar();

                for (PacoteIpv4 pack : p) {
                    if (i == 0) {

                        System.out.println("");
                        System.out.println("ENVIANDO O PACOTE IPV4 " + i + " PARA O BARRAMENTO ");
                        System.out.println("--------------------------------------------------------");
                    } else {

                        System.out.println("");
                        System.out.println("");
                        System.out.println("ENVIANDO O PACOTE IPV4 " + i + " PARA O BARRAMENTO ");
                        System.out.println("--------------------------------------------------------");
                    }

                    this.SendEnlace(pack);
                    i++;
                }
            }
        }


        // UDP, TCP/IP protocolos que vem da camda de transporte
        // E passar para o pacote

   */
    }

    private Pacote criarPacote(Mensagem mensagem) {

        Pacote packet = new Pacote();
        Mensagem msg = (Mensagem) mensagem;
        packet.setCabeçalho_ipv6(mensagem,this.endereco);
        return  packet;
    }
}

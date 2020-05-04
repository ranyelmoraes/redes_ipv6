

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Maquina implements Observer {

    public CamadaRede camadaRede;
    private String Hostname;
    private String end;
    private String mac;
    private List<String> mensagens = new ArrayList<>();
    private Barramento barramentoMaquina;

    public Maquina(String end, String mac, Barramento barramentoMaquina) {
        this.end = end;
        this.mac = mac;
        this.barramentoMaquina = barramentoMaquina;
        this.camadaRede = new CamadaRede(end,barramentoMaquina);
        camadaRede.setEndereco("2001:0DB8:AD1F:25E2:CADE:CAFE:F0CA:84C1");
        camadaRede.setNetID("22");
        System.out.println("===========================================================");
        System.out.println("Computador criado:");
        System.out.println("Endereço IPV6 : " + this.end);
        System.out.println("MAC ADRESS : " + this.mac);
        System.out.println("Barramento que esta ligado : " + this.barramentoMaquina.getId());
        System.out.println("===========================================================");
    }

    public List<String> getMensagens() {

        return mensagens;
    }

    public void setMensagens(String mensagens) {
        this.mensagens.add(mensagens);
    }




    public String getHostname() {
        return Hostname;
    }

    public void setHostname(String hostname) {
        Hostname = hostname;
    }


    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }


    @Override
    public void enviarMensagem(Object msg) throws InterruptedException, ExecutionException {

        System.out.println("Enviando pacote para camada de transporte...");
        Thread.sleep(4000);
        System.out.println("==============================================");
        camadaRede.enviarMensagem(msg);



    }

    @Override
    public void receberMensagem(Object msg, String MAC) throws InterruptedException {
        Pacote m = (Pacote) msg;
        if(m.getIP_Destino().equals(this.end)) {
            System.out.println("=======================================");
            System.out.println("Mensagem Recebida!! Esse Pacote tem meu endereco");
            Thread.sleep(2000);
            System.out.println("Recebi essa mensagem de: " + m.getIP_Origem());
            Thread.sleep(2000);
            System.out.println("Mensagem : " + m.getMensagem());
            Thread.sleep(2000);
            mensagens.add(m.getMensagem());

        }else{
            System.out.println("=======================================");
            System.out.println("Esse pacote nao tem meu endereco!!!");
            System.out.println("Meu endereço é : " + this.end);
            Thread.sleep(4000);
            System.out.println("=======================================");
        }


    }
}



import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Maquina {

    private String Hostname;
    private String end;
    private String mac;
    private List<String> mensagens = new ArrayList<>();
    private Barramento barramentoMaquina;

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

    public Maquina(){
     //   end = "fe80::200:5aee:feaa:20a2";
    //    mac = "F4-B5-20-17-B0-7C";
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

    public Pacote sendMensagem(Mensagem mensagem) {

        Pacote msg = new Pacote();

        msg.cabeçalho_ipv6  = "6";
        msg.camada_superior = "rede";
        msg.IP_R = mensagem.getIpv6Destino();
        msg.versao = 6;
        msg.Mensagem = mensagem.getMensagem();
        return msg;

    }
}

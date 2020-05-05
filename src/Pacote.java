

public class Pacote {

    int versao;  // Para pacote IPV6, valor é 6
    String traffic_Class;
    String flow_Label;
    int nextHeader; //ICMPV6
    String payLoad_extensao;
    String hop_Limit;
    public String IP_Origem;
    public String IP_Destino;

    public String getMACOrigem() {
        return MACOrigem;
    }

    public void setMACOrigem(String MACOrigem) {
        this.MACOrigem = MACOrigem;
    }

    public String getMACDestino() {
        return MACDestino;
    }

    public void setMACDestino(String MACDestino) {
        this.MACDestino = MACDestino;
    }

    public String MACOrigem;
    public String MACDestino;
    public String Mensagem;

    public String getIP_Origem() {
        return IP_Origem;
    }

    public void setIP_Origem(String IP_Origem) {
        this.IP_Origem = IP_Origem;
    }

    public String getIP_Destino() {
        return IP_Destino;
    }

    public void setIP_Destino(String IP_Destino) {
        this.IP_Destino = IP_Destino;
    }

    public void setCabeçalho_ipv6(Mensagem msg, String origem) {
        this.versao = 6;
        this.Mensagem = msg.getMensagem();
        this.IP_Destino = msg.ipv6Destino;
        this.IP_Origem = origem;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }
}

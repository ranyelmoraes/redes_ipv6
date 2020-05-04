public class Mensagem {


    String mensagem;
    String ipv6Destino;
    boolean fazerArp;


    public Mensagem(String mensagem, String ipv6Destino) {
        this.mensagem = mensagem;
        this.ipv6Destino = ipv6Destino;

    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getIpv6Destino() {
        return ipv6Destino;
    }

    public void setIpv6Destino(String ipv4Destino) {
        this.ipv6Destino = ipv6Destino;
    }


}

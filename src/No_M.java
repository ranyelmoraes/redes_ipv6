

import java.util.ArrayList;
import java.util.List;

public class No_M {

    public String Hostname;
    public String end;
    public String mac;
    public List<String> mensagens = new ArrayList<>();

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

    public No_M(){
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
    
}

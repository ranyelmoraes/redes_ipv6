
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    List<No_M> maquina = new ArrayList<>();
    No_M hostAtual;
    public static void main(String[] args) {
        int op = 0;
        Main main = new Main();
        Pacote msg = new Pacote();

        No_M a = new No_M();
        No_M b = new No_M();
        No_M c = new No_M();

        main.criaMaquinas(a, b, c);


        main.logarUsuario();


        while (true) {
            System.out.println("Usuário Logado: " + main.hostAtual.getHostname());
            System.out.println("\n1 - Ver Maquinas da Rede");
            System.out.println("2 - Enviar Mensagem para Maquina");
            System.out.println("3 - Ver Mensagens Recebidas");
            System.out.println("4 - Logar com outro usuario");
            System.out.println("5 - Sair");

            Scanner x = new Scanner(System.in);
            op = x.nextInt();


            switch (op) {
                case 1:
                    main.listarMaquinas();
                    break;
                case 2:
                    main.enviarMensagem();
                    break;
                case 3:
                    main.listarMensagens();
                    break;
                case 4:
                    main.logarUsuario();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("opcao invalida!!!");


            }


        }

    }

    private void logarUsuario(){
        while (true){

            System.out.println("Informe seu hostname para logar no sistema");
            Scanner x = new Scanner(System.in);
            String hostName = x.nextLine();
            hostAtual = BuscaMaquina(hostName);
            if(hostAtual != null){
                break;
            }
        }
    }

    private void listarMensagens() {

        for (No_M aux : maquina) {
            if (!aux.getMensagens().isEmpty() && aux == hostAtual) {
                System.out.println("\n");
                System.out.println(aux.getHostname());
                System.out.println(aux.getMensagens().toString());
                System.out.println("\n");
            }
        }

    }

    private void enviarMensagem() {
        listarMaquinas();

        for (No_M aux : maquina) {
            System.out.println(aux.getHostname());
            System.out.println("");
        }


        System.out.println("Para quem deseja enviar a mensagem ?");

        Scanner x = new Scanner(System.in);
        String hostName = x.nextLine();

        No_M hostdestino = BuscaMaquina(hostName);

        while(hostdestino == hostAtual){
            listarMaquinas();
            System.out.println("Voce nao pode enviar mensagem para si mesmo \n");
            System.out.println("Para quem deseja enviar a mensagem ?");
            hostName = x.nextLine();
            hostdestino = BuscaMaquina(hostName);
        }
        System.out.println("Digite a mensagem");
        String msg = x.nextLine();

        hostdestino.setMensagens(msg);

    }

    private No_M BuscaMaquina(String hostName) {
        for (No_M aux : maquina) {

            if (aux.getHostname().equals(hostName)) {
                return aux;
            }


        }
        return null;

    }

    private void listarMaquinas() {

        for (No_M aux : maquina) {
            System.out.println(aux.getHostname());
            System.out.println(aux.getEnd());
            System.out.println(aux.getMac());
            System.out.println("");
        }

    }

    private void criaMaquinas(No_M a, No_M b, No_M c) {

        a.setEnd("fe80::200:5aee:feaa:20a2");
        a.setMac("MAC RANYEL");
        a.setHostname("Ranyel Moraes");

        b.setEnd("2001:0DB8:AD1F:25E2:CADE:CAFE:F0CA:84C1");
        b.setMac("MAC WALTER");
        b.setHostname("Walter Porfirio");

        c.setEnd("2001:0DB8:AD1F:25E2:CADE:CAFE:F0CA:32C1");
        c.setMac("MAC DANIEL");
        c.setHostname("Daniel Moura");

        maquina.add(a);
        maquina.add(b);
        maquina.add(c);

    }
}
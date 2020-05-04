import java.util.concurrent.ExecutionException;

public interface Observer {

    void enviarMensagem(Object msg) throws InterruptedException, ExecutionException;
    void receberMensagem(Object msg, String MAC) throws InterruptedException;

}

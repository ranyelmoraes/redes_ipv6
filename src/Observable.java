public interface Observable {

    void notificar(Object mensagem) throws InterruptedException;
    void adicionarMaquina(Observer o);
    void removerMaquina(Observer o);





}

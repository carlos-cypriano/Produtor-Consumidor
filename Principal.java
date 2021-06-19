import java.util.concurrent.Semaphore; 

public class Principal {
    
    public static void main(String[] args) {
        /*Permite que apenas um consumidor consuma, enquanto não termina o consumo, o produtor não pode liberar o item
        numero de permissoes pode ser alterado*/
        int numeroPermissoes = 1;
        Semaforo mutex = new Semaforo(1);   //parecido com o semaforo, porém não há notificação e só permite uma thread por vez 
        Semaforo buffer_cheio = new Semaforo(0);    //inicia o buffer do zero
        Semaforo buffer_vazio = new Semaforo(numeroPermissoes);

        Buffer buffe = new Buffer(new int[5], mutex, buffer_cheio, buffer_vazio);
    }
}

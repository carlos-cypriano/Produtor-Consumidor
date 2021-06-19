import java.util.concurrent.Semaphore;  //Para caso eu fosse usar a biblioteca Semaphore e suas propriedades Acquire e Release.

public class Buffer{

    public static int NUM_ITENS = 5;
    private int[] buffer = new int[NUM_ITENS];
    private int bufferIndexAtualProdutor;
    private int bufferIndexAtualConsumidor;

    private Semaforo mutex, buffer_cheio, buffer_vazio; //referenciar classe semaforo e passar variáveis para o construtor Buffer;

    Buffer(int[] buffer, Semaforo cheio, Semaforo vazio, Semaforo mutex){
        this.buffer = buffer;
        this.buffer_cheio = cheio;
        this.buffer_vazio = vazio;
        this.mutex = mutex;
    }
}
import java.util.concurrent.Semaphore;  //Para caso eu fosse usar a biblioteca Semaphore e suas propriedades Acquire e Release.

public class Buffer{

    public static int NUM_ITENS = 5;
    public int[] buffer = new int[NUM_ITENS];
    private int bufferIndexAtualProdutor;
    private int bufferIndexAtualConsumidor;

    private Semaforo mutex, buffer_cheio, buffer_vazio; //referenciar classe semaforo e passar variáveis para o construtor Buffer;

    Buffer(int[] buffer, Semaforo cheio, Semaforo vazio, Semaforo mutex){
        this.buffer = buffer;
        this.buffer_cheio = cheio;
        this.buffer_vazio = vazio;
        this.mutex = mutex;
    }

    //Método responsável por verificar se está tudo ok para a liberação da tarefa de inserção de item 
    public void insert_item(String idThread, int item){
        buffer_vazio.Permitir();
        mutex.Permitir();

        this.buffer[bufferIndexAtualProdutor] = item;
        System.out.println("Produtor " + idThread + "\t produziu \t" + item);
        bufferIndexAtualProdutor = (bufferIndexAtualProdutor + 1)%buffer.length;    //Módulo % percorre o cumprimento do buffer e depois retorna ao início repetindo o processo
    
        mutex.Liberar();
        buffer_cheio.Liberar();
    }
    //Método responsável por verificar se está tudo ok para a liberação da tarefa de remoção do item
    public int remove_item(String idThread, int item){

        buffer_cheio.Permitir();
        mutex.Permitir();

        System.out.println("Consumidor " + idThread + "\t consumiu \t" + this.buffer[bufferIndexAtualConsumidor]);
        item = this.buffer[bufferIndexAtualConsumidor];
        bufferIndexAtualConsumidor = (bufferIndexAtualConsumidor + 1)%buffer.length; //Módulo % percorre o cumprimento do buffer e depois retorna ao início repetindo o processo

        mutex.Liberar();
        buffer_vazio.Liberar();

        return item;
    }

    public class Item{
        public int item;
    }
}
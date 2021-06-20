import java.util.Random;

public class Consumidor extends Thread {
    Buffer buffe;   //Utilizando para chamada da função remove_item

    public Consumidor(Buffer buffer){
        this.buffe = buffer;
    }

    @Override
    public void run(){

        //Consumidor pode comsumir até o limite de itens produzido caso o número de consumíveis fosse mais alto voltando assim para a fila
        for(int i = 0; i < buffe.buffer.length; i++){
            this.buffe.remove_item(this.getName(), (int) (Math.random() * buffe.buffer.length));    //Remove o item aleatório correspondente ao item produzido

            try {
                sleep((int) (Math.random() * 2000));        //Coloca a thread pra dormir entre um intervalo randômico de tempo de 0 a 2 segundos
                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block

                e.printStackTrace();
            }
        }
    }
}

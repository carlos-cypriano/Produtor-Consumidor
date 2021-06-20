import java.util.Random;

public class Produtor extends Thread {
    Buffer buffe;   //Utilizando para chamada da função remove_item

    public Produtor(Buffer buffer){
        this.buffe = buffer;
    }

    @Override
    public void run(){

        //Produtor pode comsumir até o limite de itens produzido caso o número de produtos fosse mais alto voltando assim para a fila de produção
        for(int i = 0; i < buffe.buffer.length; i++){
            this.buffe.insert_item(this.getName(), (int) (Math.random() * buffe.buffer.length));    //Remove o item aleatório correspondente ao item produzido

            try {
                sleep((int) (Math.random() * 3000));        //Coloca a thread pra dormir entre um intervalo randômico de tempo de 0 a 2 segundos
                
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block

                e.printStackTrace();
            }
        }
    }
}


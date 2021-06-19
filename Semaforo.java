//Criei a classe Semaforo para poder ilustrar melhor o funcionamento dos semáforos, mas poderia ter usado a biblioteca Semaphore também.

public class Semaforo {
   
    private int contador = 0;

    public Semaforo(int valorInicial){
        this.contador = valorInicial;
    }

    /*Método equivalente a propriedade Acquire que no inglês significa aquisição
    Responsável por permitir o acesso de apenas uma thread na area crítica através de um contador
    número de permissões pode ser alterado se usado apenas Semaforo*/
    public synchronized void Permitir(){
        if(contador <= 0){
            try {
                wait(); //Bloco de teste, que coloca a thread em espera até que seja liberada para prosseguir 
            } catch (InterruptedException e) {
                
            }
        }
        contador--;
    }

    /*Método equivalente a propriedade Release que no inglês significa lançamento
    Responsável por liberar e notificar a thread que está em espera para que possa prosseguir*/
    public synchronized void Liberar(){
        contador++;
        notify();   //Acorda a thread que estiver em espera
    }
}

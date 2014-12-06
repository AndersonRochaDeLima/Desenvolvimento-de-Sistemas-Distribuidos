/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicação;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Anderson
 */

//CLIENTE
public class Caixa {
    public static MyRemote impl;
    
    public void conecta() throws RemoteException, NotBoundException{
        
        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1099); //endereço servidor e porta
        impl = (MyRemote) myRegistry.lookup("MyMessage"); // call server's method //search for myMessage service
        
    }
    public static void main(String[] args) throws RemoteException, NotBoundException{
        Caixa c = new Caixa();
        c.conecta();
        Scanner entrada = new Scanner(System.in);
        int id = impl.gerarIdCaixa();
        int cont = 0;
        
        System.out.println("------------------------------------------------");
        System.out.println("|  Para realizar um atendimento aperte ENTER.   |");
        System.out.println("------------------------------------------------");
        
        while (entrada.hasNextLine()) {
            entrada.nextLine();
            boolean retorno = impl.removerSenha(id);
            
            cont  = 0;
            while (retorno == false) {                
                retorno = impl.verificaFilaDeSenha();  
                
                if(cont == 0){
                    System.out.println("------------------------------------------");
                    System.out.println("      Não existe senhas na fila: \n        Aguande nova senha. ");
                    System.out.println("------------------------------------------");
                    cont++;
                }
            }
            System.out.println("Aperte ENTER para remover senha.");    
        }   
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
 * @author TI
 */
public class Senha {
    public static MyRemote impl;
    
     public void conecta() throws RemoteException, NotBoundException{
        
        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1099); //endereço servidor e porta
        impl = (MyRemote) myRegistry.lookup("MyMessage"); // call server's method //search for myMessage service                
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException{
        Scanner entrada = new Scanner(System.in);
        Senha t = new Senha();
        t.conecta();
        
        boolean sair = true;
        String nome = "";
        
        while(sair){
            System.out.println("--------------------MENU-------------------- "
                + "\n|   [1] Gerar Senha \n|   [2] Gerar Senha Prioritária \n|   [3] Exibir \n|   [4] Sair \nOpção: ");
            int opt = entrada.nextInt();
            
            switch (opt){
                case 1:
                {
                    String aux = entrada.nextLine();
                    System.out.print("Digite seu nome: ");
                    nome = entrada.nextLine();
                    
                    impl.gerarSenha(nome);
                    break;
                }
                case 2:
                {
                    String aux = entrada.nextLine();
                    System.out.print("Digite seu nome: ");
                    nome = entrada.nextLine();
                    
                    impl.gerarSenhaPrioritaria(nome);
                    break;
                }
                case 3:{
                    impl.exibirLista();
                    break;
                }
                case 4:
                {
                    sair = false;
                    break;
                }
            }
        }   
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicação;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Anderson
 */
public class ServerPainel extends UnicastRemoteObject implements InterfacePainel{
    
    public ServerPainel() throws RemoteException{
        System.out.println("------------------------------------------------");
        System.out.println("|                   PAINEL                      |");
        System.out.println("------------------------------------------------");
    }
    
    public static void main(String[] args){
        
        try{
            Registry registry = LocateRegistry.createRegistry(1011);
            registry.rebind("MensagemPainel", new ServerPainel());
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void exibePainel(String nome, String senha, String tipoCliente, int idCaixa){
        System.out.println("============PAINEL============");
        System.out.println("  Senhor(a): " + nome);
        System.out.println("  Comparecer ao caixa: " + idCaixa);
        System.out.println("  Senha: " + senha);
        System.out.println("  Atendimento: " + tipoCliente);
        System.out.println("==============================");
        System.out.println("\n\n");
    }
}

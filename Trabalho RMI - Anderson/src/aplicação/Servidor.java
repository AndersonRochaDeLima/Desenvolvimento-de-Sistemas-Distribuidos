/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicação;

import static aplicação.Caixa.impl;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author labs
 */

// SERVIDOR
public class Servidor extends UnicastRemoteObject implements MyRemote{
    
    Scanner entrada = new Scanner(System.in);
    ArrayList<ObjCliente> listaPrioritaria = new ArrayList<ObjCliente>();
    ArrayList<ObjCliente> listaComum = new ArrayList<ObjCliente>();
    int id = 0, senha = 0;
    String nome = "";
    
    public void gerarSenha(String nome){
        senha++;
        ObjCliente ob = new ObjCliente(senha, nome);
        listaComum.add(ob);     
    }
    
    public void gerarSenhaPrioritaria(String nome){
        senha++;
        ObjCliente ob = new ObjCliente(senha, nome);
        listaPrioritaria.add(ob);
    }
    
    public boolean removerSenha(int idCaixa) throws RemoteException{
              
        if(listaPrioritaria.isEmpty()){ //Se lista prioritária esta VAZIA                            
            if(listaComum.isEmpty()){
                return false;
            }
            String nome = listaComum.get(0).getNome()+"";
            String senha = listaComum.get(0).getSenha()+"";
            
            impl.exibePainel(nome, senha, "comum", idCaixa);
            ObjCliente aux = listaComum.get(0);
            listaComum.remove(aux);
        }else{
            String nome = listaPrioritaria.get(0).getNome()+"";
            String senha = listaPrioritaria.get(0).getSenha()+"";
       
            impl.exibePainel(nome, senha, "prioritario", idCaixa);
            ObjCliente aux = listaPrioritaria.get(0);
            listaPrioritaria.remove(aux);
         }
        return true;
    }
    
    public void exibirLista(){
        System.out.println("\n\n==========Lista Comum==========");
        for (int i = 0; i < listaComum.size(); i++) {
            System.out.println("Nome: " + listaComum.get(i).getNome() + "\nSenha: " + listaComum.get(i).getSenha());
        }
        System.out.println("==========Lista Prioritaria==========");
        for (int j = 0; j < listaPrioritaria.size(); j++) {
            System.out.println("Nome: " + listaPrioritaria.get(j).getNome() + "\nSenha: " + listaPrioritaria.get(j).getSenha());
        }
    }
    
    public int gerarIdCaixa(){
        id++;
        
        return id;
    }
    
    public boolean verificaFilaDeSenha(){
        
        if(listaComum.isEmpty() && listaPrioritaria.isEmpty()){            
            return false;
        }else{
            return true;
        }    
    }
    
    //Alt+insert para criar o construtor
    public Servidor() throws RemoteException {
        System.out.println("Servidor Rodando...");
    }
    
    public static InterfacePainel impl;
    public void conecta() throws RemoteException, NotBoundException{
        
        Registry myRegistry = LocateRegistry.getRegistry("127.0.0.1", 1011); //endereço servidor e porta
        impl = (InterfacePainel) myRegistry.lookup("MensagemPainel"); 
        
    }
    
    public static void main(String[] args) throws RemoteException, NotBoundException{
        
        Servidor server  = new Servidor();
        server.conecta();
        
        try{
            Registry registry = LocateRegistry.createRegistry(1099);
            
            MyRemote servise = new Servidor();
            Naming.rebind("MyMessage", servise);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }  
    
}

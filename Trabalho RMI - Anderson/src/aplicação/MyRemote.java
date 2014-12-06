/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicação;

import java.rmi.RemoteException;

/**
 *
 * @author labs
 */

//INTERFACE 
public interface MyRemote extends java.rmi.Remote{
    
    public void gerarSenha(String nome) throws RemoteException;
    public void gerarSenhaPrioritaria(String nome) throws RemoteException;
    public boolean removerSenha(int idCaixa) throws RemoteException;
    public void exibirLista() throws RemoteException;
    public int gerarIdCaixa() throws RemoteException;
    public boolean verificaFilaDeSenha() throws RemoteException;
    //declaração dos metodos
    
}

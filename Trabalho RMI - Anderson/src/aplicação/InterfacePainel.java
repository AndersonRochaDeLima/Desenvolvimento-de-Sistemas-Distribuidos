/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicação;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Anderson
 */
public interface InterfacePainel extends Remote{
    public void exibePainel(String nome, String senha, String tipoCliente, int idCaixa) throws RemoteException;
}

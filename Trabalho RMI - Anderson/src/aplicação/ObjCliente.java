/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package aplicação;

import java.io.Serializable;

/**
 *
 * @author labs
 */
public class ObjCliente implements Serializable{
    private int senha;
    private String nome;

    public ObjCliente(int senha, String nome) {
        this.senha = senha;
        this.nome = nome;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
   
    
    
    
    
}

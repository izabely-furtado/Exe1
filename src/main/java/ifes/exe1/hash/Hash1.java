/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.exe1.hash;

import ifes.exe1.util.No;
import ifes.exe1.util.Lista;

/**
 *
 * @author IzabelyFurtado
 */
public class Hash1 {
    int limite;
    //vetor de listas
    Lista[] tabela;
    
    public Hash1(int limite) {
        this.limite = limite;
        this.tabela = new Lista[this.limite];
        for (Lista lst : this.tabela){
            lst = new Lista();
        }
    }
    
    //função hash para inteiros
    public int funcHash(long prop) throws Exception{
        Long valor = prop % this.limite;
        try {
            Integer retorno = Integer.valueOf(valor.toString());
            return retorno;
        }
        catch (Exception e) {
             throw new Exception("Capacidade do Integer estourou.");
        }
    }
    
    //função hash para strings
    public int funcHash(String prop) {
        int chave = 0;
        int tam = prop.length();
        for (int caract= 0; caract < tam; caract++){
            chave += prop.codePointAt(caract);
        }
        chave %= this.limite;
        return chave;
        
    }
    
    //insere a hash tendo como propriedade uma string
    public void setConteudo(String prop, No conteudo){
        if(this.tabela[this.funcHash(prop)].getTamanho()>0){
            System.out.println("Houve colisão");
        }
        this.tabela[this.funcHash(prop)].addNo(conteudo);
    }
    
    //insere a hash tendo como propriedade um inteiro
    public void setConteudo(long prop, No conteudo) throws Exception{
        if(this.tabela[this.funcHash(prop)].getTamanho()>0){
            System.out.println("Houve colisão com " + prop);
        }
        this.tabela[this.funcHash(prop)].addNo(conteudo);
        System.out.println(prop + "Foi inserido");
    }

    //retorna o conteudo de pessoa --> só de pessoa
    //pegando como propriedade o nome da mesma
    public No getConteudo(String prop) throws Exception{
        Lista lst = this.getPosicaoLst(prop);
        for (int conteudo = 0; conteudo <=lst.getTamanho(); conteudo++){
            Pessoa p = (Pessoa) lst.getNo(conteudo).getValorNo();
            if(p.nome == null ? prop == null : p.nome.equals(prop)){
                return lst.getNo(conteudo);
            }
        }
        throw new Exception("Conteúdo não encontrado");
    }
    
    //retorna o conteudo de pessoa --> só de pessoa
    //pegando como propriedade o cpf da mesma
    public No getConteudo(long prop) throws Exception{
        Lista lst = this.getPosicaoLst(prop);
        for (int conteudo = 0; conteudo <=lst.getTamanho(); conteudo++){
            Pessoa p = (Pessoa) lst.getNo(conteudo).getValorNo();
            if(p.cpf == prop){
                return lst.getNo(conteudo);
            }
        }
        throw new Exception("Conteúdo não encontrado");
    }
    
    //retorna a posição no vetor na qual se encontra --> só de pessoa
    
    //pegando como propriedade o cpf da mesma
    public int getPosicaoVet(long prop) throws Exception{
        return this.funcHash(prop);
    }
    //pegando como propriedade o nome da mesma
    public int getPosicaoVet(String prop) throws Exception{
        return this.funcHash(prop);
    }
    
    //retorna a lista na qual está inserida a pessoa, 
    
    //pegando como propriedade o cpf da mesma
    public Lista getPosicaoLst(long prop) throws Exception{
        return this.tabela[this.funcHash(prop)];
    }
    //pegando como propriedade o nome da mesma
    public Lista getPosicaoLst(String prop) throws Exception{
        return this.tabela[this.funcHash(prop)];
    }
    
}
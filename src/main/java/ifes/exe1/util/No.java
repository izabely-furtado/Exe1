/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.exe1.util;

/**
 *
 * @author IzabelyFurtado
 */
public  class No implements INo{

    private Object valor;
    private No proximo;
    private No anterior;

    public No() {
        this.valor = null;
        this.proximo = null;
        this.anterior = null;
    }

    public No(Object valor) {
        this.anterior = null;
        this.proximo = null;
        this.valor = valor;
    }

    public No(No proximo, Object valor) {
        this.proximo = proximo;
        this.valor = valor;
    }
    
    @Override
    public Object getValorNo(){
        return this.valor;
    }
    
    @Override
    public void setValorNo(Object valor){
        if (this.valor == null){
            
        }
        else{
            this.anterior.setValorNo(this.valor);
            this.setValorNo(valor);
            this.anterior.setNoProx(this);
        }
    }
    
    @Override
    public No getNoProx(){
        return this.proximo;
    }
    
    @Override
    public void setNoProx(No no){
        this.proximo = no;
    }
    
    @Override
    public No getNoAnt(){
        return this.anterior;
    }
    
    @Override
    public void setNoAnt(No no){
        this.anterior = no;
    }
    @Override
    public Object getValorProx(){
        return this.proximo.valor;
    }
    
    @Override
    public String toString(){
        return this.valor.toString();
    }
    
}

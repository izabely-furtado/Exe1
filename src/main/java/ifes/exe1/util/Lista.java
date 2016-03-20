/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.exe1.util;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author IzabelyFurtado
 */
public class Lista implements ILista {

    private No inicio;
    private No fim;
    private int tamanho;

    Lista() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    @Override
    public void addNo(Object elemento) {
        this.addNoInicio(elemento);
    }

    public void addNoInicio(Object elemento) {
        if (this.inicio != null) {
            this.inicio.setValorNo(elemento);
            this.fim.setValorNo(elemento);
        } 
        else {
            this.inicio.setNoProx(this.inicio);
            this.inicio.setValorNo(elemento);
        }
        this.tamanho += 1;
    }

    public void addNoFim(Object elemento) {
        this.fim.setValorNo(elemento);
        this.tamanho += 1;
    }
    
    //verifica se está vazia
    public boolean vazia(){
        return this.inicio == null && this.fim == null;
    }
    
    
    public Object removeFim() throws Exception {
        Object retirado;
        //com um elemento ou nenhum
        if (this.tamanho>1){
            throw new Exception("Não existe elementos na lista");
        }
        else if (this.tamanho == 1){
            retirado = this.inicio.getValorNo();
            this.inicio = null;
            this.fim = null;
            this.tamanho = 0;
        }
        //com mais d um elemento
        else{
            retirado = this.fim.getValorNo();
            No peNoUltimo = this.fim.getNoAnt();
            peNoUltimo.setNoProx(null);
            this.fim = peNoUltimo;
            this.tamanho -= 1;
        }
        return retirado;
    }

    
    public Object removeInicio() {
        Object retorno = this.inicio.getValorNo();
        this.inicio.setValorNo(this.inicio.getValorProx());
        return retorno;
    }

    @Override
    public No getNo(int posicao){
        // Percorrendo até o elemento.
        No atual = this.inicio;
        for (int cont = 0; cont < posicao - 1; cont++) {
            atual = atual.getNoProx();
        }
        return atual;
    }
    
    @Override
    public void addNo(int posicao, Object elemento) {
        if (posicao > this.tamanho){
            throw new IllegalArgumentException("Posição inexistente");
        }
        else if (tamanho == 0){
            this.addNoInicio(elemento);
        }
        else if (posicao == this.tamanho){
            this.addNoFim(elemento);
        }
        else{
            No anterior = this.getNo(posicao);
            No atual = new No();
            atual.setNoAnt(anterior);
            atual.setValorNo(elemento);
            atual.setNoProx(anterior.getNoProx());
            anterior.setNoProx(atual);
            this.inicio = anterior;
        }
        this.tamanho-= 1;
    }


    @Override
    public int getTamanho() {
        return this.tamanho;
    }

    @Override
    public Object removeNo(int posicao) {
        Object retorno = null;
        if (posicao > this.tamanho){
            throw new IllegalArgumentException("Posição inexistente");
        }
        else if(posicao == 0){
            retorno = this.removeInicio();
        }
        else if (posicao == this.tamanho){
            try {
                retorno = this.removeFim();
            } catch (Exception ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            No anterior = this.getNo(posicao);
            retorno = anterior;
            No realidade = anterior.getNoProx();
            No expectativa = realidade.getNoProx();
            anterior.setNoProx(expectativa);
            expectativa.setNoAnt(anterior);
            this.inicio = anterior;
        }
        this.tamanho-= 1;
        return retorno;
        
    }
    
}

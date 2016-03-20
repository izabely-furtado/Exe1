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
public interface ILista {
    
    public void addNo(Object elemento);
    
    public void addNo(int posicao, Object elemento);
    
    public Object getNo(int posicao);
    
    public Object removeNo(int posicao);
    
    public int getTamanho();
    
    
}

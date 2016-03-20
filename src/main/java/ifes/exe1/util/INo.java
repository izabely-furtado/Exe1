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
public interface INo {

    public Object getValorNo();

    public No getNoProx();
    
    public No getNoAnt();

    public Object getValorProx();
    
    public void setValorNo(Object valor);
    
    public void setNoProx(No no);
    
    public void setNoAnt(No no);

}

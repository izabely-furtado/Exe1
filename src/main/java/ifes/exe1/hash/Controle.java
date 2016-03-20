/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.exe1.hash;

import java.util.List;

/**
 *
 * @author IzabelyFurtado
 */
public class Controle {

    Hash1 pessoinhas;
    
    public Controle(int exe) throws Exception{
        this.pessoinhas = new Hash1(99);
        this.inserindoPessoinhasInt();
    }
    
    public Controle(String exe) throws Exception{
        this.pessoinhas = new Hash1(99);
        this.inserindoPessoinhasStr();
    }
    
    //inserindo conteudo considerando uma hash com propriedade em String
    public final void inserindoPessoinhasStr(){
        List<Pessoa> ps = Pessoa.criaPessoasAleatorias();
        for(Pessoa p : ps){
            this.pessoinhas.setConteudo(p.nome, p);
        }
    }
    //inserindo conteudo considerando uma hash com propriedade como inteiro
    public final void inserindoPessoinhasInt() throws Exception{
        List<Pessoa> ps = Pessoa.criaPessoasAleatorias();
        for(Pessoa p : ps){
            this.pessoinhas.setConteudo(p.cpf, p);
        }
    }
    
    public Pessoa encontrandoPessoinha(long cpf) throws Exception{
        return (Pessoa) this.pessoinhas.getConteudo(cpf);
    }
    
    public Pessoa encontrandoPessoinha(String nome) throws Exception{
        return (Pessoa) this.pessoinhas.getConteudo(nome);
    }
    
    public static void main(String[] coisasETals) throws Exception{
        Controle c = new Controle(666);
        
        //procurando cpf inexistente
        //c.encontrandoPessoinha(77777777777L);
        //procurando cpf existente sem conflito
        //c.encontrandoPessoinha(66666666666L);
        //procurando cpf existente com conflito
        //c.encontrandoPessoinha(11111111111L);
        
        c = new Controle("pessoinha feliz");
        //procurando pessoinha inexistente
        //c.encontrandoPessoinha("pessoinha feliz");
        //procurando nome existente com conflito
        //c.encontrandoPessoinha("Thanos");
        //procurando nome de pessoa sem conflito
        //c.encontrandoPessoinha("Vallen Drake");
    }
    
    
    
}

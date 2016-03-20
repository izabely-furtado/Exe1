/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifes.exe1.hash;

import ifes.exe1.util.No;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author IzabelyFurtado
 */
public class Pessoa extends No{
    long cpf;
    String nome;
    String email;
    long cep;
    long telefone;
    
    
    Pessoa(long cpf, String nome, String email, long cep, long telefone){
        this.cep = cep;
        this.cpf = cpf;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    Pessoa(long cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }
    
    public static List<Pessoa> criaPessoasAleatorias(){
        List<Pessoa> pessoinhas = new ArrayList<>();
        Pessoa p1 = new Pessoa(66666666666L, "Crowley");
        Pessoa p2 = new Pessoa(11111111111L, "Jimy");
        Pessoa p3 = new Pessoa(22222222222L, "Orion Drake");
        Pessoa p4 = new Pessoa(11111111113L, "Thanos");
        Pessoa p5 = new Pessoa(33333333333L, "Vanessa Drake");
        Pessoa p6 = new Pessoa(11111111112L, "Vallen Drake");
        Pessoa p7 = new Pessoa(44444444444L, "sanohT");
        
        pessoinhas.add(p7);
        pessoinhas.add(p6);
        pessoinhas.add(p5);
        pessoinhas.add(p4);
        pessoinhas.add(p3);
        pessoinhas.add(p2);
        pessoinhas.add(p1);
        
        return pessoinhas;
    }
    
    @Override
    public String toString(){
        return this.nome + " - " + this.cpf;
    }
}

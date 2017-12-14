package testes;


import arquivo.Arquivo;
import java.io.FileNotFoundException;
import lexico.AnalisadorLexico;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author brunoslima
 * @author leandroungari
 */
public class Analise {

    public static void main(String[] args) throws FileNotFoundException {

        AnalisadorLexico a = new AnalisadorLexico();
        a.gerarLexico();
        
    }
}

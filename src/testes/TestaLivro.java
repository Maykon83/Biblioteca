
package testes;

import DAO.binario.LivroDao;

import java.util.HashMap;
import modelo.Aluno;
import modelo.Aluno;
import modelo.Livro;
import modelo.Livro;

public class TestaLivro {
    public static void main(String[] args) {
        Livro livro = new Livro();
        Livro livro2 = new Livro();
        Livro livro3 = new Livro();
        
       livro.setCdBarra(123456);
       livro.setIdLivro(12345);
       //livro.setDataAquisicao.();
       livro.setDataCadastroSistema("12/11/2012");
       livro.setClassificacao("");
       livro.setExemplar(1);
       livro.setAreaConhecimento("");
       livro.setAutores("");
       livro.setTitulo("");
       livro.setAno("");
       livro.setIsbn("");
       livro.setEditora("");
       livro.setPaginas(12345);
       
       
        LivroDao livroDao = new LivroDao();
        HashMap salvar = new HashMap();
       
        
        
    }
    
}

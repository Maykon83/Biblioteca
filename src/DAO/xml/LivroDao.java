package DAO.xml;

import java.io.IOException;
import java.util.HashMap;
import modelo.Livro;
import DAO.interfaces.LivroDAOInterface;

public class LivroDao extends DAO_XML_Generico implements LivroDAOInterface {

    private String endereco = System.getProperty("C:\\Users\\Maykon\\Documents\\NetBeansProjects\\Nova_Biblioteca") + System.getProperty("\\Livros.xml") + "Livros.xml";

    @Override
    public HashMap<Integer, Livro> ler() throws IOException {
        return carregarArquivo(endereco);
    }

    @Override
    public <Integer, Livro> void salvar(HashMap<Integer, Livro> map) throws IOException {
        salvarArquivo(map, endereco);
    }

    @Override
    public Livro buscarLivro(int idLivro) throws IOException {
        HashMap<java.lang.Integer, modelo.Livro> livros = ler();
        return livros.get(idLivro);
    }

    @Override
    public void salvarLivro(Livro livro) throws IOException {
        HashMap<java.lang.Integer, modelo.Livro> livros = ler();
        livros.put(livro.getIdLivro(), livro);
        salvar(livros);
    }

    @Override
    public void removerLivro(Livro livro) throws IOException {
        HashMap<java.lang.Integer, modelo.Livro> livros = ler();
        livros.remove(livro.getIdLivro());
        salvar(livros);
    }

    @Override
    public void removerLivro(int idLivro) throws IOException {
        HashMap<java.lang.Integer, modelo.Livro> livros = ler();
        livros.remove(idLivro);
        salvar(livros);
    }
}

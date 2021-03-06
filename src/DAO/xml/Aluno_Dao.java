package DAO.xml;

import java.io.IOException;
import java.util.HashMap;
import modelo.Aluno;
import DAO.interfaces.AlunoDAOInterface;

public class Aluno_Dao extends DAO_XML_Generico implements AlunoDAOInterface {

    private final String endereco = System.getProperty("C:\\Users\\Maykon\\Documents\\NetBeansProjects\\Nova_Biblioteca") + System.getProperty("\\Aluno.xml")
            + "Alunos.xml";

    @Override
    public HashMap<Long, Aluno> ler() throws IOException {
        return carregarArquivo(endereco);
    }

    @Override
    public <Long, Aluno> void salvar(HashMap<Long, Aluno> map) throws IOException {
        salvarArquivo(map, endereco);
    }

    @Override
    public Aluno buscarAluno(long codAluno) throws IOException {
        HashMap<Long, Aluno> alunos = ler();
        return alunos.get(codAluno);
    }

    @Override
    public void salvarAluno(Aluno aluno) throws IOException {
        HashMap<Long, Aluno> alunos = ler();
        alunos.put(aluno.getCodAluno(), aluno);
        salvar(alunos);
    }

    @Override
    public void removerAluno(Aluno aluno) throws IOException {
        HashMap<Long, Aluno> alunos = ler();
        alunos.remove(aluno.getCodAluno());
        salvar(alunos);
    }

    @Override
    public void removerAluno(long codAluno) throws IOException {
        HashMap<Long, Aluno> alunos = ler();
        alunos.remove(codAluno);
        salvar(alunos);
    }

}

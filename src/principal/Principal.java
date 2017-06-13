package principal;

import DAO.binario.Aluno_Dao;
//import DAO.xml.Emprestimo_DAO;
import DAO.binario.Emprestimo_DAO;
import DAO.binario.LivroDao;
import DAO.interfaces.AlunoDAOInterface;
import DAO.interfaces.EmprestimoDAOInterface;
import DAO.interfaces.LivroDAOInterface;
import java.io.IOException;
import testes.TestesAluno;
import testes.TestesEmprestimo;
import testes.TestesLivro;

public class Principal {

    public static void main(String[] args) throws Exception {
        LivroDao daoLivro = new LivroDao();
        TestesLivro testesLivro = new TestesLivro((LivroDAOInterface) daoLivro);

        try {
            testesLivro.testeCriarSalvarLivro();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        try {
            testesLivro.testeBuscarLivro();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        Aluno_Dao daoAluno = new Aluno_Dao();
        TestesAluno testesAluno = new TestesAluno((AlunoDAOInterface) daoAluno);

        try {
            testesAluno.testeCriarSalvarAluno();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        try {
            testesAluno.testeBuscarAluno();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        Emprestimo_DAO emprestimoDao = new Emprestimo_DAO();
        TestesEmprestimo testesEmprestimo = new TestesEmprestimo((EmprestimoDAOInterface) emprestimoDao);

        try {
            testesEmprestimo.testeCriarEmprestimo();
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
        }

        try {
            testesEmprestimo.testeBuscaEmprestimo();
        } catch (IOException e) {
            System.out.println("ERRO: " + e.getMessage());
        }

    }
}

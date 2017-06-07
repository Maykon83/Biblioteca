package testes;

import DAO.xml.Aluno_Dao;
import java.util.HashMap;
import modelo.Aluno;

public class TestaAluno {
    public static void main(String[] args) {
        
        Aluno aluno = new Aluno();
        Aluno aluno2 = new Aluno();
        Aluno aluno3 = new Aluno();
        Aluno_Dao alunoDao = new Aluno_Dao();
        HashMap salvar = new HashMap();
       
        aluno.setNome("Maykon");
        aluno.setCpf("123456");
        aluno.setMatricula("987654");
        
        salvar.put(aluno.getMatricula(), aluno);
        alunoDao.saveAllAluno(salvar);
        
        
        aluno2.setNome("Maykon");
        aluno2.setCpf("123457");
        aluno2.setMatricula("987653");
        
        salvar.put(aluno2.getMatricula(), aluno2);
        alunoDao.saveAllAluno(salvar);
        
        aluno3.setNome("Maykon");
        aluno3.setCpf("123458");
        aluno3.setMatricula("987652");
        
        salvar.put(aluno3.getMatricula(), aluno3);
        alunoDao.saveAllAluno(salvar);
    }
}

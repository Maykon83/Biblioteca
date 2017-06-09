package DAO.xml;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import modelo.Aluno;
import modelo.Livro;

public class Aluno_Dao {
    
    public void saveAllAluno(HashMap<String, Aluno> aluno) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("C:\\Users\\Maykon\\Documents\\NetBeansProjects\\Nova_Biblioteca\\Aluno.xml");
            BufferedOutputStream bos = new BufferedOutputStream(fout);
            XMLEncoder xmlEncoder = new XMLEncoder(bos);
            xmlEncoder.writeObject(aluno);
            xmlEncoder.close();
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public HashMap<String, Aluno> loadAll() {
        HashMap<String, Aluno> aluno = new HashMap();
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\Maykon\\Documents\\NetBeansProjects\\Nova_Biblioteca\\Aluno.xml");
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            aluno = (HashMap<String, Aluno>) xmlDecoder.readObject();
        } catch (Exception e) {
            System.out.println("erro ao ler");
        }
        return aluno;
    }

}

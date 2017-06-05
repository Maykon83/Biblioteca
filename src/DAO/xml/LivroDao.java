package DAO.xml;

import java.beans.*;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import modelo.Exemplar;
import modelo.Livro;

public class LivroDao {

    public void saveAllLivros(HashMap<String, Livro> livros) {
        FileOutputStream fout = null;
        try {
            fout = new FileOutputStream("F:\\NetBeansProjects\\Nova_Biblioteca\\Acervo\\Acervo.xml");
            BufferedOutputStream bos = new BufferedOutputStream(fout);
            XMLEncoder xmlEncoder = new XMLEncoder(bos);
            xmlEncoder.writeObject(livros);
            xmlEncoder.close();
        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage());
        }
    }

    public HashMap<String, Livro> loadAll() {
        HashMap<String, Livro> livros = new HashMap();
        try {
            FileInputStream fis = new FileInputStream("F:\\NetBeansProjects\\Nova_Biblioteca\\Acervo\\Acervo.xml");
            BufferedInputStream bis = new BufferedInputStream(fis);
            XMLDecoder xmlDecoder = new XMLDecoder(bis);
            livros = (HashMap<String, Livro>) xmlDecoder.readObject();
        } catch (Exception e) {
            System.out.println("erro ao ler");
        }
        return livros;
    }

    public HashMap<Integer, Livro> importarLivros() {

        HashMap<Integer, Livro> livros = new HashMap<Integer, Livro>();
        String pastaDestino = System.getProperty("user.home") + System.getProperty("file.separator") + "livros.xml";
        int contadorExemplar = 0;
        int contadorLivro = 0;
        Scanner teclado = null;
        String linha;
        String[] colunas;

        try {

            teclado = new Scanner(new File(pastaDestino));

            while (teclado.hasNext()) {

                linha = (String) teclado.nextLine();

                if (linha.contains("codigoDeBarras")) {
                    continue;
                } else {
                    colunas = linha.split("\\|");
                    if (colunas.length == 13) {
                        if (colunas[1] != null && livros.get(Integer.parseInt(colunas[1])) != null) {
                            ((Livro) livros.get(Integer.parseInt(colunas[1])))
                                    .AdicionaExemplar(new Exemplar(colunas[0], colunas[2], colunas[3]));
                            contadorLivro++;
                        } else {
                            Livro livro = new Livro(colunas[0], colunas[1], colunas[2], colunas[3], colunas[4],
                                    colunas[5], colunas[6], colunas[7], colunas[8], colunas[9], colunas[10],
                                    colunas[11], colunas[12]);
                            livros.put(livro.getIdLivro(), livro);
                        }
                        contadorExemplar++;
                    }
                }

            }

        } catch (Exception e) {
            System.out.println("Erro:" + e.getMessage());
        } finally {
            teclado.close();
        }

        System.out.printf("Foram importados %s livros e %s exemplares." + "\r\n", contadorLivro, contadorExemplar);
        return livros;
    }
}

package modelo;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Exemplar implements Serializable{

    private int cdBarras;
    private int exemplar;
    private String dataAquisicaoExemplar;

    public Exemplar(int cdBarras, int exemplar, String dataAquisicaoExemplar) {
        super();
        this.cdBarras = cdBarras;
        this.exemplar = exemplar;
        this.dataAquisicaoExemplar = dataAquisicaoExemplar;
    }

    public Exemplar(String cdBarras, String exemplar, String dataAquisicaoExemplar) {
        int cdBarrasInt = Integer.parseInt(cdBarras);
        int exemplarInt = Integer.parseInt(exemplar);
        DateTimeFormatter dateString = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.cdBarras = cdBarrasInt;
        this.exemplar = exemplarInt;
        this.dataAquisicaoExemplar = dateString.toString();
    }

    public int getCdBarras() {
        return cdBarras;
    }

    public void setCdBarras(int cdBarras) {
        this.cdBarras = cdBarras;
    }

    public int getExemplar() {
        return exemplar;
    }

    public void setExemplar(int exemplar) {
        this.exemplar = exemplar;
    }

    public String getDataAquisicaoExemplar() {
        return dataAquisicaoExemplar;
    }

    public void setDataAquisicaoExemplar(String dataAquisicaoExemplar) {
        this.dataAquisicaoExemplar = dataAquisicaoExemplar;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Exemplar)) {
            return false;
        }
        Exemplar other = (Exemplar) obj;
        if (cdBarras != other.cdBarras) {
            return false;
        }
        return true;
    }

}

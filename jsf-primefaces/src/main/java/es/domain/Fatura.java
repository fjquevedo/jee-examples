package es.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Fatura implements Serializable{    
    private long number;
    private Date dataVencimento;
    private String description;

    public Fatura() {
    }

    public Fatura(long number, Date dataVencimento, String description) {
        this.number = number;
        this.dataVencimento = dataVencimento;
        this.description = description;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (this.number ^ (this.number >>> 32));
        hash = 23 * hash + Objects.hashCode(this.dataVencimento);
        hash = 23 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fatura other = (Fatura) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.dataVencimento, other.dataVencimento)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fatura{" + "number=" + number + ", dataVencimento=" +     dataVencimento + ", description=" + description + '}';
    }
 }
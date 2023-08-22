package org.example.entity.oneToOne;


import javax.persistence.*;

@Entity
@Table(name = "adresse")
public class Adress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_adresse")
    private Long id;
    @Column(nullable = false)
    private Integer numero;
    @Column(name = "nom_rue", nullable = false)
    private String nomRue;
    @Column(name = "code_postal", nullable = false, length = 5)
    private String codePostal;
    private String ville;

    @OneToOne(mappedBy = "adress")
    private House house;

    public Adress() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNomRue() {
        return nomRue;
    }

    public void setNomRue(String nomRue) {
        this.nomRue = nomRue;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "id=" + id +
                ", numero=" + numero +
                ", nomRue='" + nomRue + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}

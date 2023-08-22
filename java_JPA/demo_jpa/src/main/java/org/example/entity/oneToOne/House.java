package org.example.entity.oneToOne;


import javax.persistence.*;

@Entity
@Table(name = "maison")
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="maison_id")
    private Long id;

    private Integer taille;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adresse_id",referencedColumnName = "id_adresse")
    private Adress adress;

    public House() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTaille() {
        return taille;
    }

    public void setTaille(Integer taille) {
        this.taille = taille;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", taille=" + taille +
                ", adress=" + adress +
                '}';
    }
}

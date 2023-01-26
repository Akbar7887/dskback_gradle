package uz.backweb.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Catalog {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String weigth;
    private String heigth;
    private String length;
    private String volume;
    private String mass;
    private String concrete;
    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "catalog", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<ImageCatalog> imageCatalogs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "make_id", referencedColumnName = "id")
    @JsonBackReference
    private Make make;

    @Enumerated(EnumType.STRING)
    private Active active = Active.ACTIVE;


    public Catalog() {
    }

    public Catalog(Long id, String name, String weigth, String heigth, String length, String volume, String mass, String concrete, String description, List<ImageCatalog> imageCatalogs, Make make, Active active) {
        this.id = id;
        this.name = name;
        this.weigth = weigth;
        this.heigth = heigth;
        this.length = length;
        this.volume = volume;
        this.mass = mass;
        this.concrete = concrete;
        this.description = description;
        this.imageCatalogs = imageCatalogs;
        this.make = make;
        this.active = active;
    }



    public void addImage(ImageCatalog imageCatalog){
        if (!this.imageCatalogs.contains(imageCatalog)) {
            this.imageCatalogs.add(imageCatalog);
            imageCatalog.setCatalog(this);
        }
    }
    public void removeImage(ImageCatalog imageCatalog){
        if (this.imageCatalogs.contains(imageCatalog)) {
            this.imageCatalogs.remove(imageCatalog);
            imageCatalog.setCatalog(null);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeigth() {
        return weigth;
    }

    public void setWeigth(String weigth) {
        this.weigth = weigth;
    }

    public String getHeigth() {
        return heigth;
    }

    public void setHeigth(String heigth) {
        this.heigth = heigth;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getMass() {
        return mass;
    }

    public void setMass(String mass) {
        this.mass = mass;
    }

    public String getConcrete() {
        return concrete;
    }

    public void setConcrete(String concrete) {
        this.concrete = concrete;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ImageCatalog> getImageCatalogs() {
        return imageCatalogs;
    }

    public void setImageCatalogs(List<ImageCatalog> imageCatalogs) {
        this.imageCatalogs = imageCatalogs;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public Active getActive() {
        return active;
    }

    public void setActive(Active active) {
        this.active = active;
    }
}

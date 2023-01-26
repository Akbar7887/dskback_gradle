package uz.backweb.sevice;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.backweb.models.Active;
import uz.backweb.models.Catalog;
import uz.backweb.models.ImageCatalog;
import uz.backweb.repo.CatalogRepo;
import uz.backweb.repo.ImageCatalogRepo;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class CatalogService {

    @Autowired
    final CatalogRepo catalogRepo;
    @Autowired
    final ImageCatalogRepo imageCatalogRepo;


    public List<Catalog> getallActive() {
        return catalogRepo.getAllActive(Active.ACTIVE);
    }

    public Catalog post(Catalog catalog) {
        return catalogRepo.save(catalog);
    }

    public Catalog postimage(String id, ImageCatalog imageCatalog) {

        Optional<Catalog> catalogOptional = catalogRepo.findById(Long.parseLong(id));
        if (catalogOptional.isPresent()) {
            Catalog catalog = catalogOptional.get();
            catalog.addImage(imageCatalog);
            return catalogRepo.save(catalog);
        } else {
            return null;
        }
    }

    public Catalog remove(String id){
        Optional<Catalog> catalogOptional = catalogRepo.findById(Long.parseLong(id));

        if (catalogOptional.isPresent()) {
            Catalog catalog = catalogOptional.get();
            catalog.setActive(Active.NOACTIVE);
            return catalogRepo.save(catalog);
        } else {
            return null;
        }
    }

}

package uz.backweb.sevice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.backweb.models.Active;
import uz.backweb.models.Dom;
import uz.backweb.models.Kompleks;
import uz.backweb.repo.DomRepo;
import uz.backweb.repo.KompleksRepo;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class DomService {

    private final DomRepo domRepo;
    private final KompleksRepo kompleksRepo;

    public List<Dom> getAllDom() {
        return domRepo.findAll();
    }

    public List<Dom> getDomByIdKompleks(String id) {
        return domRepo.findAllByKompleksAndId(Long.parseLong(id), Active.ACTIVE);
    }



    public Dom saveDom(Dom dom, String kompleks_id) {
        Optional<Kompleks> kompleksOptional = kompleksRepo.findById(Long.parseLong(kompleks_id));
        Kompleks kompleks = kompleksOptional.orElse(null);

        Dom dom1;
        if (dom.getId() == null) {
            dom1 = new Dom();
            dom1.setName(dom.getName());
        } else {
            dom1 = dom;
        }
        dom1.setKompleks(kompleks);

        return domRepo.save(dom1);
    }

    public Dom deleteDom(String id) {

        Dom dom = domRepo.getById(Long.parseLong(id));
        dom.setActive(Active.NOACTIVE);
        return domRepo.save(dom);
    }


}

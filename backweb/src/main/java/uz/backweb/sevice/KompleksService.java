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
public class KompleksService {

    final KompleksRepo kompleksRepo;
    final DomRepo domRepo;

    public List<Kompleks> getAllActive() {
        return kompleksRepo.getAllActive(Active.ACTIVE);
    }

    public Kompleks save(Kompleks kompleks) {
        return kompleksRepo.save(kompleks);
    }

    public Kompleks remove(String id) {
        Optional<Kompleks> houseOptional = kompleksRepo.findById(Long.parseLong(id));
        if (houseOptional.isPresent()) {
            Kompleks kompleks = houseOptional.get();
            kompleks.setActive(Active.NOACTIVE);
            return kompleksRepo.save(kompleks);

        } else {
            return null;
        }
    }

    public Kompleks getById(String id) {
        Optional<Kompleks> houseOptional = kompleksRepo.findById(Long.parseLong(id));
        if (houseOptional.isPresent()) {
            Kompleks kompleks = houseOptional.get();
            return kompleks;
        } else {
            return null;
        }
    }

    public Dom removedom(String dom_id) {

        Optional<Dom> domOptional = domRepo.findById(Long.parseLong(dom_id));
        if (domOptional.isPresent()) {
            Dom dom = domOptional.get();
            dom.setActive(Active.NOACTIVE);
            return domRepo.save(dom);
        } else {
            return null;
        }

    }
}

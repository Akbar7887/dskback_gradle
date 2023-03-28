package uz.dsk.docflow.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.dsk.docflow.models.catalogs.Personal;
import uz.dsk.docflow.repository.catalogs.PersonalRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PersonalService {

    private final PersonalRepository personalRepository;

    public List<Personal> getAll(){
        return personalRepository.findAll();
    }

    public Personal save(Personal worker){
        return personalRepository.save(worker);
    }

    public void delete(Long id){
        personalRepository.deleteById(id);
    }
}

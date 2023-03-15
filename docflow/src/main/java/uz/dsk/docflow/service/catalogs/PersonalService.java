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

    private final PersonalRepository workerRepository;

    public List<Personal> getAll(){
        return workerRepository.findAll();
    }

    public Personal save(Personal worker){
        return workerRepository.save(worker);
    }

    public void delete(Long id){
        workerRepository.deleteById(id);
    }
}

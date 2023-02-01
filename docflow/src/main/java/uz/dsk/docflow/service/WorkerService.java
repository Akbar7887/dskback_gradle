package uz.dsk.docflow.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.dsk.docflow.models.Worker;
import uz.dsk.docflow.repository.WorkerRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class WorkerService {

    private final WorkerRepository workerRepository;

    public List<Worker> getAll(){
        return workerRepository.findAll();
    }

    public Worker save(Worker worker){
        return workerRepository.save(worker);
    }

    public void delete(Long id){
        workerRepository.deleteById(id);
    }
}

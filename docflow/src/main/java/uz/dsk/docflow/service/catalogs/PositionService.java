package uz.dsk.docflow.service.catalogs;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.dsk.docflow.models.catalogs.Position;
import uz.dsk.docflow.repository.catalogs.PositionRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PositionService {

    private final PositionRepository positionRepository;

    public List<Position> getAll(){
        return positionRepository.findAll();
    }

    public Position save(Position position){
        return positionRepository.save(position);
    }

    public void delete(Long id){
        positionRepository.deleteById(id);
    }

}

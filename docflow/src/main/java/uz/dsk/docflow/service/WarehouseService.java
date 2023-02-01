package uz.dsk.docflow.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.dsk.docflow.models.Warehouse;
import uz.dsk.docflow.repository.WarehouseRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class WarehouseService {

    private final WarehouseRepository warehouseRepository;

    private List<Warehouse> getAll() {
        return warehouseRepository.findAll();
    }

    private Warehouse save(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    private void delete(Long id) {
        warehouseRepository.deleteById(id);
    }

}

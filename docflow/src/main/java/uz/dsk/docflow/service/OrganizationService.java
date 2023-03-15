package uz.dsk.docflow.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.dsk.docflow.models.Organization;
import uz.dsk.docflow.repository.OrganizationRepository;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class OrganizationService {

    private final OrganizationRepository organizationRepository;


    public Optional<Organization> getFirst() {
        return organizationRepository.findAll().stream().findFirst();
    }

    public Organization save(Organization organization) {
        return organizationRepository.save(organization);
    }

    public void delete(Long id) {
        organizationRepository.deleteById(id);
    }
}

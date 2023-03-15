package uz.dsk.docflow.resource;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.dsk.docflow.models.Organization;
import uz.dsk.docflow.service.OrganizationService;

@RestController
@RequestMapping("/doc/organization/")
@RequiredArgsConstructor
public class OrganizationResource {

    private final OrganizationService organizationService;

    @GetMapping("get")
    private Organization getAll() {
        return organizationService.getFirst().orElse(null);
    }

    @PostMapping("save")
    private ResponseEntity<Organization> save(@RequestBody Organization organization) {
        return ResponseEntity.ok().body(organizationService.save(organization));
    }

    @DeleteMapping("delete/{id}")
    private void delete(@PathVariable Long id) throws Exception {

        organizationService.delete(id);
    }
}

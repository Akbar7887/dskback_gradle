package uz.dsk.api_gateway.service;

import org.springframework.stereotype.Service;
import uz.dsk.api_gateway.models.AppUser;
import uz.dsk.api_gateway.models.Role;

import java.util.List;

@Service
public interface UserService {

    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);

    AppUser getUser(String username);

    List<AppUser> getUser();


    List<AppUser> findAll();

    void delete(AppUser appUser);
}

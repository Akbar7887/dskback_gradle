package uz.backweb.sevice;

import uz.backweb.models.auth.AppUser;
import uz.backweb.models.auth.Role;

import java.util.List;

public interface UserService {

    AppUser saveUser(AppUser user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String rolename);

    AppUser getUser(String username);

    List<AppUser> getUser();


    List<AppUser> findAll();

    void delete(AppUser appUser);
}

package Main.login;

import Main.modeles.Users;
import Main.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsServie implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepo.findByEmail(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user);
    }
}

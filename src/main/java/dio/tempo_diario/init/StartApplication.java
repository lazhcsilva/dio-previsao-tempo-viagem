package dio.tempo_diario.init;

import dio.tempo_diario.config.PasswordEncoderConfig;
import dio.tempo_diario.model.User;
import dio.tempo_diario.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StartApplication implements CommandLineRunner {

    private final UserRepository repository;
    private final PasswordEncoderConfig passwordEncoder;

    public StartApplication(UserRepository repository, PasswordEncoderConfig passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = repository.findByUsername("user");
        if (user == null) {
            user = new User();
            user.setName("USER");
            user.setUsername("user");
            String senhaCriptografada = passwordEncoder.passwordEncoder().encode("user123");
            user.setPassword(senhaCriptografada);
            user.getRoles().add("USERS");
            repository.save(user);
        }
    }
}

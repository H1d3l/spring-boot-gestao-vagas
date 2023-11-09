package br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.hidelbrandorios.springbootgestaovagas.exceptions.UserFoundException;
import br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.entities.CandidateEntity;
import br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.repositories.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public CandidateEntity execute(CandidateEntity candidateEntity) {
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent(
                        (user) -> {
                            throw new UserFoundException();
                        });

        var password = passwordEncoder.encode(candidateEntity.getPassword());
        candidateEntity.setPassword(password);
        
        return this.candidateRepository.save(candidateEntity);
    }
}

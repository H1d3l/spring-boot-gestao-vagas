package br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.hidelbrandorios.springbootgestaovagas.exceptions.UserFoundException;
import br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.CandidateEntity;
import br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.CandidateRepository;

@Service
public class CreateCandidateUseCase {

    @Autowired
    CandidateRepository candidateRepository;
    
    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
        .ifPresent(
                (user) -> {
                    throw new UserFoundException();
                });
        return this.candidateRepository.save(candidateEntity);
    }
}

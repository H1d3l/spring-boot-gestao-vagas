package br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.dto.ProfileCandidateResponseDTO;
import br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.repositories.CandidateRepository;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {
        var candidate = this.candidateRepository.findById(idCandidate).orElseThrow(() -> {
            throw new UsernameNotFoundException("User not found");
        });

        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .id(candidate.getId())
                .description(candidate.getDescription())
                .email(candidate.getEmail())
                .name(candidate.getName())
                .build();

        return candidateDTO;
    }
}

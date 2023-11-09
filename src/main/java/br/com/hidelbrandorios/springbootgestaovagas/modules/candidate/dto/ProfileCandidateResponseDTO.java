package br.com.hidelbrandorios.springbootgestaovagas.modules.candidate.dto;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {
    
    private UUID id;
    private String name;
    private String username;
    private String description;
    private String email;

}

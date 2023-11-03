package br.com.hidelbrandorios.springbootgestaovagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.hidelbrandorios.springbootgestaovagas.exceptions.UserFoundException;
import br.com.hidelbrandorios.springbootgestaovagas.modules.company.entities.CompanyEntity;
import br.com.hidelbrandorios.springbootgestaovagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {
    
    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    public PasswordEncoder passwordEncoder;

    public CompanyEntity execute(CompanyEntity companyEntity){
        this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(),companyEntity.getEmail()).ifPresent((user) -> {
            throw new UserFoundException();
        });

        var password = passwordEncoder.encode(companyEntity.getPassword());
        companyEntity.setPassword(password);
        return this.companyRepository.save(companyEntity);
        
    }
}

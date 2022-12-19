package services;


import entities.FamilyEntity;
import org.hibernate.type.descriptor.jdbc.JdbcTypeFamilyInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.FamilyRepository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;


@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public CompletableFuture<Optional<FamilyEntity>> findById(){
        System.out.println("Service Thread" + Thread.currentThread().getName());
        return FamilyRepository.findOneById();
    }

    public CompletableFuture<List<FamilyEntity>> findall(){
    System.out.println("Service Thread" + Thread.currentThread().getName());
    return familyRepository.findAllBy();
    }

    public CompletableFuture<FamilyRepository> save(JdbcTypeFamilyInformation.Family family){
     System.out.println("Service Thread" + Thread.currentThread().getName());
     return CompletableFuture.completedFuture(FamilyRepository.save(family));
    }

    public CompletableFuture<FamilyRepository> update(JdbcTypeFamilyInformation.Family family){
        System.out.println("Service Thread" + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(FamilyRepository.update(family));
    }

    public CompletableFuture<Optional<FamilyRepository>> delete(Long id){
        System.out.println("Service Thread" + Thread.currentThread().getName());
        FamilyRepository.deleteById(id);
        return null;
    }
    }

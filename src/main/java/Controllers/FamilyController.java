package Controllers;

import entities.FamilyEntity;
import org.hibernate.type.descriptor.jdbc.JdbcTypeFamilyInformation;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import repositories.FamilyRepository;
import services.FamilyService;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@RequestMapping("/family")
@RestController
@Async
public class FamilyController {

    private final FamilyService familyService;

    public FamilyController(FamilyService familyService){
        this.familyService = familyService;
    }

    @GetMapping
    public CompletableFuture<List<FamilyEntity>> findall() {
        System.out.println("Controller thread" + Thread.currentThread().getName());
        return this.familyService.findall();
    }

    @GetMapping("{id}")
    public CompletableFuture<FamilyEntity> findById(@PathVariable("id") Long id) {
        System.out.println("Controller Thread" + Thread.currentThread().getName());
        return this.familyService.findById().thenApply(familyEntity -> {
            try {
                return familyEntity.get();
            } catch (NoSuchFieldError e) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        });
    }
        @PostMapping
        public CompletableFuture<FamilyRepository> save(@RequestBody JdbcTypeFamilyInformation.Family family){
          System.out.println("Controller Thread" + Thread.currentThread().getName());
          return this.familyService.save(family);
        }
        @PutMapping
        public CompletableFuture<FamilyRepository> update(@RequestBody JdbcTypeFamilyInformation.Family family){
        System.out.println("Controller Thread" + Thread.currentThread().getName());
        return this.familyService.save(family);
    }

    @DeleteMapping("{id}")
    public CompletableFuture<Optional<FamilyEntity>> delete(@PathVariable ("id") Long id){
        System.out.println("Controller Thread" + Thread.currentThread().getName());
        return this.familyService.findById().thenApply(familyEntity -> {
            try {
                return FamilyEntity.get();
            } catch(NoSuchFieldError e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }
        });
    }
}

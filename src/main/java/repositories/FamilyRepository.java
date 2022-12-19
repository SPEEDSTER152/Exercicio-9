package repositories;

import entities.FamilyEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
@Async("customthread")
public interface FamilyRepository {

     CompletableFuture<Optional<FamilyEntity>> findOneById();

    CompletableFuture<List<FamilyEntity>> findAllBy();
}

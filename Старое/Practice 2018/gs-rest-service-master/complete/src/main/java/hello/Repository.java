package hello;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "type", path = "type")
public interface Repository extends MongoRepository<BuildingType, String> {

    List<BuildingType> findByType(@Param("type") String type);

}
package kr.co.tkdenddl1324.Repository;

import kr.co.tkdenddl1324.document.User1Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface User1Repository extends MongoRepository<User1Document, String> {

    public void deleteByUid(String uid);

    public Optional<User1Document> findByUid(String uid);
}

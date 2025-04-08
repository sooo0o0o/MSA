package kr.co.tkdenddl1324.Repository;

import kr.co.tkdenddl1324.document.User2Document;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface User2Repository extends MongoRepository<User2Document, String> {

    public Optional<User2Document> findByUid(String uid);

    public void deleteByUid(String uid);
}

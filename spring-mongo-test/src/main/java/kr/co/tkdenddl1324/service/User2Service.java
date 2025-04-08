package kr.co.tkdenddl1324.service;


import kr.co.tkdenddl1324.Repository.User2Repository;
import kr.co.tkdenddl1324.document.User2Document;
import kr.co.tkdenddl1324.dto.User2DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User2Service {
    private final User2Repository user2Repository;

    public void save(User2DTO user2DTO){
        User2Document doc = user2DTO.toDocument();
        user2Repository.save(doc);
    }

    public List<User2DTO> findAll(){
        List<User2Document> user2List = user2Repository.findAll();

        //변환
        List<User2DTO> user2DTOList = user2List.stream().map((document)-> {
            User2DTO dto = document.toDTO();
            return dto;
        }).toList();
        return user2DTOList;
    }

    public User2DTO findByUid(String uid){
        Optional<User2Document> user2Document = user2Repository.findByUid(uid);

        if(user2Document.isPresent()){
            User2DTO dto = user2Document.get().toDTO();
            return dto;
        }
        return null;
    }

    public void modify(User2DTO user2DTO){
        String uid = user2DTO.getUid();

        Optional<User2Document> optUser2 = user2Repository.findByUid(uid);
        if(optUser2.isPresent()){
            User2Document doc = user2DTO.toDocument();
            doc.set_id(optUser2.get().get_id());

            user2Repository.save(doc);
        }
    }

    public void deleteByUid(String uid){
        user2Repository.deleteByUid(uid);
    }

}

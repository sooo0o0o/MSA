package kr.co.tkdenddl1324.service;

import kr.co.tkdenddl1324.Repository.User1Repository;
import kr.co.tkdenddl1324.document.User1Document;
import kr.co.tkdenddl1324.dto.User1DTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;

    //등록하기
    public void save(User1DTO user1DTO) {
        User1Document doc = user1DTO.toDocument();
        user1Repository.save(doc);
    }

    //출력하기(조회하기)
    public List<User1DTO> findAll(){
        List<User1Document> user1List = user1Repository.findAll();

        //변환
        List<User1DTO> user1DTOList = user1List.stream().map((document)->{
            User1DTO dto = document.toDTO();
            return dto;
        }).toList();

        return user1DTOList;
    }
    

    //아이디별 조회하기
    public User1DTO findByUid(String uid){
        Optional<User1Document> user1Document = user1Repository.findByUid(uid);

        if(user1Document.isPresent()){
            User1DTO dto = user1Document.get().toDTO();
            return dto;
        }

        //없으면 null 로 리턴
        return null;
    }

    //수정하기
    public void modify(User1DTO user1DTO){
        String uid = user1DTO.getUid();

        Optional<User1Document> optUser1 = user1Repository.findByUid(uid);

        if(optUser1.isPresent()){
            //존재한다면 수정
            User1Document user1Document = optUser1.get();
            User1Document modifiedUser1 = User1Document.builder()
                    ._id(user1Document.get_id())
                    .name(user1Document.getName())
                    .age(user1Document.getAge())
                    .addr(user1Document.getAddr())
                    .build();

            /*
            User1Document doc = user1DTO.toDocument();
            doc.set_id(optUser1.get().get_id());
             */

            user1Repository.save(modifiedUser1);

        }
    }
    
    //삭제하기
    public void deleteByUid(String uid){
        user1Repository.deleteByUid(uid);
    }


}

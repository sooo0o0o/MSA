package kr.co.tkdenddl1324.document;

import kr.co.tkdenddl1324.dto.User1DTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(value="user1")
public class User1Document {

    @Id
    private String _id; // mongoDB 식별값 -> DTO에는 없어도 됨!

    private String uid;
    private String name;
    private int age;
    private String addr;

    public User1DTO toDTO(){
        return User1DTO.builder()
                .uid(uid)
                .name(name)
                .age(age)
                .addr(addr)
                .build();
    }

}

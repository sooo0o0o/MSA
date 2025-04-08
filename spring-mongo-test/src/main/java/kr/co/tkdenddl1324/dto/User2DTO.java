package kr.co.tkdenddl1324.dto;

import kr.co.tkdenddl1324.document.User2Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User2DTO {

    private String uid;
    private String name;
    private String hp;
    private int age;

    public User2Document toDocument(){
        return User2Document.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }
}

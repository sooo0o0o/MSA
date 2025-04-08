package kr.co.tkdenddl1324.document;

import kr.co.tkdenddl1324.dto.User2DTO;
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
@Document(value="user2")
public class User2Document {

    @Id
    private String _id;
    private String uid;
    private String name;
    private String hp;
    private int age;

    public User2DTO toDTO(){
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .age(age)
                .build();
    }
}

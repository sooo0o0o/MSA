package kr.co.tkdenddl1324.dto;

import kr.co.tkdenddl1324.document.User1Document;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//DTO 사용하지 않아도 됨! => 원칙적으로는 사용해야하나, toDTO, toDocument 과정 생략 가능
public class User1DTO {

    private String uid;
    private String name;
    private int age;
    private String addr;


    public User1Document toDocument(){
        return User1Document.builder()
                .uid(uid)
                .name(name)
                .age(age)
                .addr(addr)
                .build();
    }

}

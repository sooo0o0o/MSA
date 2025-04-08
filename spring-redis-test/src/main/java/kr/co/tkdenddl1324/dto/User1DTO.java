package kr.co.tkdenddl1324.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1DTO implements Serializable { //redis 에 저장하기위한 "직렬화"
    private String uid;
    private String name;
    private int age;
    private String addr;

}

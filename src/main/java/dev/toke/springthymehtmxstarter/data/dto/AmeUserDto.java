package dev.toke.springthymehtmxstarter.data.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AmeUserDto {
//    "userId": 1,
    private Integer userId;
//    "deviceId": 0,
    private Integer deviceId;
//    "loginId": 0,
    private Integer loginId;
//    "fullName": "Adam Burger",
    private String fullName;
//    "username": "AME\\adamb",
    private String username;
//    "locationId": 752,
    private Integer locationId;
//    "locationType": 1,
    private Integer locationType;
//    "locationTypeOut": 2,
    private Integer locationTypeOut;
//    "userTypeId": 2,
    private Integer userTypeId;
//    "association": null
    private String association;
}

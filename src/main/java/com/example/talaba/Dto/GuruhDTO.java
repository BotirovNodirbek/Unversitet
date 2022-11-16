package com.example.talaba.Dto;

import lombok.Data;

import java.util.List;

@Data
public class GuruhDTO {
private String guruhnomi;
private Integer fakultetID;
private List<Integer>fanID;
private List<Integer>talabaID;

}

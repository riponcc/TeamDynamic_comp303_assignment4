package com.abdul.Microservice2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Player {
    private int playerId;
    private String firstName;
    private String lastName;
    private String position;
    private int jerseyNumber;
    private int age;
    private int teamId;
}

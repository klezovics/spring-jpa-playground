package com.klezovich.springjpa.advanced.customhbmtype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BracketPair {

    private Integer open;
    private Integer closed;


}

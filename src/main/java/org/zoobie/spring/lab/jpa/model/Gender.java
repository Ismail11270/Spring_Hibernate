package org.zoobie.spring.lab.jpa.model;

import java.util.Arrays;

public enum Gender {
    MALE('M'), FEMALE('F'), OTHER('O');

    private char gender;

    Gender(char c){
        gender = c;
    }

    public char getGenderChar() {
        return gender;
    }

    public static Gender getGenderFromChar( char c ){
        return Arrays.stream( values()).filter( x -> x.gender == c ).findFirst().orElse( OTHER );
    }

}

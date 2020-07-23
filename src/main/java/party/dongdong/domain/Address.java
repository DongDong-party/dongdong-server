package party.dongdong.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class Address {
    private String metropolitan;
    private String city;
    private String gu;
}

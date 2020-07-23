package party.dongdong.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Getter
@Embeddable
public class Address {
    private String metropolitan;
    private String city;
    private String gu;
}

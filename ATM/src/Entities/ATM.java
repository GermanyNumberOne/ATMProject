package Entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ATM {
    private long atmMoney;
    private boolean authorized = false;

}

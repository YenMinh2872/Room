package empire.m.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.math.BigDecimal;

/**
 * Created by YENMINH on 10/30/2017 1:13 AM.
 * Code and Life ( ^ .,,. ^ )
 * ---------------------------------------------
 */
@Entity
public class CoinDTO {

    @PrimaryKey
    int uid;

    @ColumnInfo(name = "name")
    String name;

    @ColumnInfo(name = "value")
    String value;

    @ColumnInfo(name = "volume")
    String volume;

    @ColumnInfo(name = "balance")
    String balance;

    @ColumnInfo(name = "expPrice")
    String expPrice;

    public CoinDTO() {
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getExpPrice() {
        return expPrice;
    }

    public void setExpPrice(String expPrice) {
        this.expPrice = expPrice;
    }
}

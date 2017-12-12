package empire.m.room.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by YENMINH on 12/9/2017 4:57 PM.
 * Code and Life ( ^ .,,. ^ )
 * ---------------------------------------------
 */

@Entity
public class ItemValue {

    @PrimaryKey
    int id = 1;

    @ColumnInfo(name = "value")
    public int value;
}

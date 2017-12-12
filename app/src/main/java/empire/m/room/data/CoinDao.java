package empire.m.room.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

/**
 * Created by YENMINH on 10/30/2017 1:17 AM.
 * Code and Life ( ^ .,,. ^ )
 * ---------------------------------------------
 */
@Dao
public interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertCoinDTO(ItemValue coinDTO);

    @Update
    void updateDTO(ItemValue itemValue);

    @Query("Select * from ItemValue")
    Flowable<ItemValue> getDTO();
}

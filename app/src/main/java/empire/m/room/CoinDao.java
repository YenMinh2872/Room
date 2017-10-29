package empire.m.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by YENMINH on 10/30/2017 1:17 AM.
 * Code and Life ( ^ .,,. ^ )
 * ---------------------------------------------
 */
@Dao
public interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertCoinDTO(CoinDTO coinDTO);

    @Query("Select * from CoinDTO")
    public List<CoinDTO> getDTO();
}

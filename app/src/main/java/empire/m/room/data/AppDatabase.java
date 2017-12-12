package empire.m.room.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by YENMINH on 10/30/2017 1:18 AM.
 * Code and Life ( ^ .,,. ^ )
 * ---------------------------------------------
 */
@Database(entities = {ItemValue.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    public static String DATABASE_NAME = "AppDatabase";

    public abstract CoinDao coinDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context,
                    AppDatabase.class, DATABASE_NAME)
                    //day la demo can remove dong nay ra va thuc hien query bat dong bo asynctask hoac thread
                    //.allowMainThreadQueries()
                    .build();

        }
        return INSTANCE;
    }
}

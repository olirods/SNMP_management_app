package com.example.clientesnmp;

import android.content.Context;
import android.widget.Toast;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {UserEntity.class, EquipoEntity.class}, version = 6)
public abstract class Database extends RoomDatabase {

    private static final String dbName = "snmpDatabase";
    private static Database database;

    public static synchronized Database getDatabase(Context context) {

        if (database == null) {
            database = Room.databaseBuilder(context, Database.class, dbName)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return database;
    }

    public abstract UserDao userDao();

    public abstract EquipoDao equipoDao();

}

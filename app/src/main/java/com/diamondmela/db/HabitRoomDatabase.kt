package com.diamondmela.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diamondmela.db.dao.UserDao

@Database(entities = arrayOf(UserDao::class), version = 1)
abstract class HabitRoomDatabase : RoomDatabase() {
    abstract fun wordDao(): UserDao
}
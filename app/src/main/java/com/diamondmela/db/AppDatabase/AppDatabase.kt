package com.diamondmela.db.AppDatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.diamondmela.db.dao.UserDao
import com.diamondmela.db.entity.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
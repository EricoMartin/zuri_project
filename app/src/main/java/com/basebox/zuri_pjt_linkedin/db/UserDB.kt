package com.basebox.zuri_pjt_linkedin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.basebox.zuri_pjt_linkedin.dao.UserDAO
import com.basebox.zuri_pjt_linkedin.entity.User

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {

    abstract fun userDao(): UserDAO

    companion object{
        @Volatile private var instance: UserDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance?: synchronized (LOCK){
            instance?: buildDatabase(context)
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            UserDB::class.java, "users.db").build()
    }
}

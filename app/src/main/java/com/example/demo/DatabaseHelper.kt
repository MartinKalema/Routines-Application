package com.example.demo

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "names_database"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "names_table"
        private const val COLUMN_NAME = "name"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_NAME TEXT)"
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertName(name: String) {
        val db = writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_NAME, name)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    fun getAllNames(): List<String> {
        val namesList = mutableListOf<String>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        if (cursor != null) {
            val nameIndex = cursor.getColumnIndex(COLUMN_NAME)
            while (cursor.moveToNext()) {
                if (nameIndex >= 0) {
                    val name = cursor.getString(nameIndex)
                    namesList.add(name)
                }
            }
            cursor.close()
        }

        db.close()
        return namesList
    }

    fun deleteRecord(name: String): Boolean {
        val db = this.writableDatabase
        val whereClause = "$COLUMN_NAME = ?"
        val whereArgs = arrayOf(name)

        val deletedRows = db.delete(TABLE_NAME, whereClause, whereArgs)
        db.close()

        return deletedRows > 0
    }



}

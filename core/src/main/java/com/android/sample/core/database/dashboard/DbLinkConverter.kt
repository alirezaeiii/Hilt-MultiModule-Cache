package com.android.sample.core.database.dashboard

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object DbLinkConverter {

    private lateinit var dbLinkJsonAdapter: JsonAdapter<List<DbLink>>

    fun initialize(moshi: Moshi){
        val listDbLink = Types.newParameterizedType(MutableList::class.java, DbLink::class.java)
        dbLinkJsonAdapter = moshi.adapter(listDbLink)
    }

    @TypeConverter
    @JvmStatic
    fun jsonToList(value: String): List<DbLink>? = dbLinkJsonAdapter.fromJson(value)

    @TypeConverter
    @JvmStatic
    fun listToJson(list: List<DbLink>?): String = dbLinkJsonAdapter.toJson(list)
}
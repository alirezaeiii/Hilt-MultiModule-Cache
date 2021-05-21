package com.android.sample.core.database.dashboard

import androidx.room.TypeConverter
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

object DbLinkConverter {

    private lateinit var moshi: Moshi

    fun initialize(moshi: Moshi){
        this.moshi = moshi
    }

    @TypeConverter
    @JvmStatic
    fun jsonToList(value: String): List<DbLink>? = getDbLinkJsonAdapter().fromJson(value)

    @TypeConverter
    @JvmStatic
    fun listToJson(list: List<DbLink>?): String = getDbLinkJsonAdapter().toJson(list)

    private fun getDbLinkJsonAdapter(): JsonAdapter<List<DbLink>> {
        val listDbLink = Types.newParameterizedType(MutableList::class.java, DbLink::class.java)
        return moshi.adapter(listDbLink)
    }
}
package com.loc.newsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverters
import com.loc.newsapp.domain.models.Source


@ProvidedTypeConverter
class NewsTypeConverter {

    @TypeConverters
    fun sourceToString(source: Source) : String{
        return "${source.id}, ${source.name}"
    }

    @TypeConverters
    fun stringToSource(source: String):Source{
        return source.split(",").let { sourceArray ->
            Source(sourceArray[0],sourceArray[1])
        }
    }

}
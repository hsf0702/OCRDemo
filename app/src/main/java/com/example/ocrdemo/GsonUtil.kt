package com.example.ocrdemo


import com.google.gson.Gson
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken

import java.util.ArrayList


object GsonUtil {


    var gson: Gson? = null
        private set

    init {
        if (gson == null) {
            gson = Gson()
        }
    }


    /**
     * 将object对象转成json字符串
     *
     * @param object
     * @return
     */
    fun GsonString(`object`: Any): String? {
        var gsonString: String? = null
        if (gson != null) {
            gsonString = gson!!.toJson(`object`)
        }
        return gsonString
    }


    /**
     * 将gsonString转成泛型bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    fun <T> GsonToBean(gsonString: String, cls: Class<T>): T? {
        var t: T? = null
        if (gson != null) {
            t = gson!!.fromJson(gsonString, cls)
        }
        return t
    }

    /**
     * 转成list
     * 解决泛型问题
     * @param json
     * @param cls
     * @param <T>
     * @return
    </T> */
    fun <T> jsonToList(json: String, cls: Class<T>): List<T> {
        val gson = Gson()
        val list = ArrayList<T>()
        val array = JsonParser().parse(json).asJsonArray
        for (elem in array) {
            list.add(gson.fromJson(elem, cls))
        }
        return list
    }


    /**
     * 转成list中有map的
     *
     * @param gsonString
     * @return
     */
    fun <T> GsonToListMaps(gsonString: String): List<Map<String, T>>? {
        var list: List<Map<String, T>>? = null
        if (gson != null) {
            list = gson!!.fromJson<List<Map<String, T>>>(gsonString,
                object : TypeToken<List<Map<String, T>>>() {

                }.type
            )
        }
        return list
    }


    /**
     * 转成map的
     *
     * @param gsonString
     * @return
     */
    fun <T> GsonToMaps(gsonString: String): Map<String, T>? {
        var map: Map<String, T>? = null
        if (gson != null) {
            map = gson!!.fromJson<Map<String, T>>(gsonString, object : TypeToken<Map<String, T>>() {

            }.type)
        }
        return map
    }

}

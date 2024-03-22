package com.example.json_editing

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject

object JsonModifier {
    fun addTestKey(jsonString: String): String {
        val gson = Gson()
        val jsonObject = gson.fromJson(jsonString, JsonObject::class.java)

        addTestKeyRecursively(jsonObject)

        return gson.toJson(jsonObject)
    }

    private fun addTestKeyRecursively(jsonElement: JsonElement) {
        if (jsonElement.isJsonObject) {
            val jsonObject = jsonElement.asJsonObject
            if (jsonObject.has("_sd") && !jsonObject.has("test")) {
                jsonObject.addProperty("test", "add new result")
            }
            jsonObject.entrySet().forEach { (_, value) ->
                addTestKeyRecursively(value)
            }
        } else if (jsonElement.isJsonArray) {
            jsonElement.asJsonArray.forEach { arrayElement ->
                addTestKeyRecursively(arrayElement)
            }
        }
    }
}

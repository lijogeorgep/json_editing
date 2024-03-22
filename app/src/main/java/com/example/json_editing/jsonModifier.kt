import android.util.Base64
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import java.security.MessageDigest

object JsonModifier {
    private const val TAG = "JsonModifier"

    private fun calculateSHA256Hash(inputString: String?): String? {
        if (inputString == null)
            return null
        val decodedBytes = inputString.toByteArray(Charsets.UTF_8)
        val sha256Digest = MessageDigest.getInstance("SHA-256").digest(decodedBytes)
        val base64urlEncodedHash = Base64.encodeToString(
            sha256Digest,
            Base64.URL_SAFE or Base64.NO_WRAP or Base64.NO_PADDING
        )
        return base64urlEncodedHash
    }

    private fun decodeBase64(encodedString: String): String {
        val decodedBytes = Base64.decode(encodedString, Base64.DEFAULT)
        return String(decodedBytes, Charsets.UTF_8)
    }

    private fun extractKeyValue(decodedString: String): Pair<String, String> {
        val jsonArray = JsonParser.parseString(decodedString).asJsonArray
        val key = jsonArray[1].asString
        val value = jsonArray[2].asString
        return Pair(key, value)
    }

    fun addTestKey(jsonString: String, disclosures: List<String>): String {
        val gson = Gson()
        val jsonObject = gson.fromJson(jsonString, JsonObject::class.java)
        val hashList: MutableList<String> = mutableListOf()
        disclosures.forEach { encodedString ->
            try {
                val hash = calculateSHA256Hash(encodedString)
                if (hash != null) {
                    hashList.add(hash)
                }
            } catch (e: IllegalArgumentException) {
                // Handle invalid base64-encoded strings
                Log.e(TAG, "Invalid base64-encoded string: $encodedString")
            }
        }
        addTestKeyRecursively(jsonObject, disclosures, hashList)

        return gson.toJson(jsonObject)
    }

    private fun addTestKeyRecursively(
        jsonElement: JsonElement,
        disclosures: List<String>,
        hashList: MutableList<String>
    ) {
        if (jsonElement.isJsonObject) {
            val jsonObject = jsonElement.asJsonObject
            if (jsonObject.has("_sd")) {
                val sdList = jsonObject.getAsJsonArray("_sd")

                hashList.forEachIndexed { index, hash ->
                    val sdKey = sdList[index].asString
                    if (hash == sdKey) {
                        try {
                            val disclosure = decodeBase64(disclosures[index])
                            // Extract key-value pair from the encodedString
                            val (decodedKey, decodedValue) = extractKeyValue(disclosure)
                            Log.d(TAG, "decodedKey:decodedValue = $decodedKey:$decodedValue")
                            // Add key-value pair to jsonObject
                            jsonObject.addProperty(decodedKey, decodedValue)
                        } catch (e: IllegalArgumentException) {
                            // Handle invalid base64-encoded strings
                            Log.e(TAG, "Invalid base64-encoded string in _sd list: $sdKey")
                        }
                    }
                }
            }
            jsonObject.entrySet().forEach { (_, value) ->
                addTestKeyRecursively(value, disclosures, hashList)
            }
        } else if (jsonElement.isJsonArray) {
            jsonElement.asJsonArray.forEach { arrayElement ->
                addTestKeyRecursively(arrayElement, disclosures, hashList)
            }
        }
    }


}

package commentResponse

import com.google.gson.Gson
import myAPIkey
import java.net.URL

fun main() {
    print("Please enter the video ID and press enter: ")
    val myVideoId = readLine()
    val response =
        URL("https://www.googleapis.com/youtube/v3/commentThreads?key=$myAPIkey&textFormat=plainText&part=snippet&videoId=$myVideoId&maxResults=100").readText()
    val gson = Gson()

//    gson object
    val commentResponse = gson.fromJson(response, CommentResponse::class.java)
    for (i in 0 until commentResponse.items.size) {
        print("${commentResponse.items[i].snippet.topLevelComment.snippet.authorDisplayName} : ")
        println(commentResponse.items[i].snippet.topLevelComment.snippet.authorChannelUrl)
    }
}
package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val message = Message.builder()
        .putData("action", "NEW_MESSAGE")
        .putData(
            "content", """{
          "senderId": 1,
          "senderName": "Vasiliy",
          "postId": 2,
          "postContent": "(It starts with one)
One thing, I don’t know why
It doesn’t even matter how hard you try
Keep that in mind; I designed this rhyme
To explain, in due time
All I know; time is a valuable thing
Watch it fly by as the pendulum swings
Watch it count down to the end of the day
The clock ticks life away, it’s so unreal
"
        }""".trimIndent()
        )
        .setToken(token)
        .build()
    val message2 = Message.builder()
        .putData("action", "NEW_POST")
        .putData(
            "content", """{
          "authorId": 1,
          "authorName": "Vasiliy",
          "postId": 2,
          "postContent": "Я публикую огромный
          длинный 
          пост
          о
          чем нибудь
          крайне
          интересном
          и 
          важном"
        }""".trimIndent()
        )
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)
    FirebaseMessaging.getInstance().send(message2)
}
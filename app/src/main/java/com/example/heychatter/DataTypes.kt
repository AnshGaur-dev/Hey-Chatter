package com.example.heychatter
//custom dataclasss according to user data
data class UserData(
    var userid:String? ="",
    var name:String? ="",
    var number:String? ="",
    var imageurl:String? ="",
){
    fun toMap()= mapOf( //aapan ne yeah banaya h jisse firebase pe data map k format m jaye
        "userid" to userid,
        "name" to name,
        "number" to imageurl,
        "imageurl" to imageurl
    )
}

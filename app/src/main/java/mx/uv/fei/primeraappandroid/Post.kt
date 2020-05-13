package mx.uv.fei.primeraappandroid

import org.json.JSONObject

class Post {
    var userId : Int = 0
    var id : Int = 0
    var title : String
    var body : String

    constructor(userId: Int, id: Int, title: String, body: String) {
        this.userId = userId
        this.id = id
        this.title = title
        this.body = body
    }

    constructor(jsonString: String) {
        var json = JSONObject(jsonString)
        this.userId = json.getInt("userId")
        this.id = json.getInt("id")
        this.title = json.getString("title")
        this.body = json.getString("body")
    }
}
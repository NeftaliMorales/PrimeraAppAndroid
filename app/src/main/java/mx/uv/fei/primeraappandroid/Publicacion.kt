package mx.uv.fei.primeraappandroid

import org.json.JSONObject

class Publicacion {
    var idUsuario : Int = 0
    var id : Int = 0
    var titulo : String
    var cuerpo : String

    constructor(idUsuario: Int, id: Int, titulo: String, cuerpo: String) {
        this.idUsuario = idUsuario
        this.id = id
        this.titulo = titulo
        this.cuerpo = cuerpo
    }

    constructor(cadenaJSON: String) {
        var json = JSONObject(cadenaJSON)
        this.idUsuario = json.getInt("userId")
        this.id = json.getInt("id")
        this.titulo = json.getString("title")
        this.cuerpo = json.getString("body")
    }

}
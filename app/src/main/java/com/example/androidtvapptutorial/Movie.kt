package com.example.androidtvapptutorial

class Movie {

    private val TAG = Movie::class.java.getSimpleName()

    val serialVersionUID = 727566175075960653L

    private var id : Long? = null
    private var title: String? = null
    private var studio: String? = null

    constructor()

    fun getId() : Long{
        return id?:0
    }

    fun setId(id : Long){
        this.id = id
    }

    fun  getTitle() : String{
        return title?:""
    }

    fun setTitle(title : String){
        this.title = title
    }

    fun getStudio(): String {
        return studio?:""
    }

    fun setStudio(studio: String) {
        this.studio = studio
    }

    override fun toString(): String {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\''.toString() +
                '}'.toString()
    }
}
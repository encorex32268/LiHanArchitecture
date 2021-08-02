package com.example.lihanarchitecture.model

import com.google.gson.annotations.SerializedName

/**
 *
 * _id: '{{objectId()}}',
age: '{{integer(20, 40)}}',
name: '{{firstName()}} {{surname()}}',
gender: '{{gender()}}',
company: '{{company().toUpperCase()}}',
email: '{{email()}}'
}
 */

data class User(
    @SerializedName("_id")
    val id : String ,
    val age : Int ,
    val name : String ,
    val gender : String ,
    val company : String ,
    val email : String
) {

    override fun toString(): String {
        return "User(id='$id', age=$age, name='$name', gender='$gender', company='$company', email='$email')"
    }
}
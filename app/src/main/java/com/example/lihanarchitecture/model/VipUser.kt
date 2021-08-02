package com.example.lihanarchitecture.model

//https://34a75f4d-d83a-44e8-81a2-a1f3161df64b.mock.pstmn.io/vipusers
data class VipUser(
    val name : String ,
    val gender :String ,
    val company : String ,
    val email : String ,
    val phone : String ,
    val registered : String ,
    val latitude : Float,
    val longitude :Float

){
    override fun toString(): String {
        return "VipUser(name='$name', gender='$gender', company='$company', email='$email', phone='$phone', registered='$registered', latitude=$latitude, longitude=$longitude)"
    }
}
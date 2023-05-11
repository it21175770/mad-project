package com.example.financemanagementclient

data class UserData(val name: String? = null, val operator: String? = null,
                    val location: String? = null, val phone: String? = null){

}
data class ExpenseData(val id: String? = null, val type: String? = null,
                        val amount: String? = null, val date: String? = null){

}

data class IncomeData(val id: String? = null, val type: String? = null,
                       val amount: String? = null, val date: String? = null){

}

data class ProfileData(val name: String? = null, val email: String? = null,
                      val address: String? = null, val phone: String? = null){

}
fun main() {
    val commissionSize = calcCommission(1000000,"МИР" )
    if (commissionSize < 0) {
        println("Ошибка операции: $commissionSize")
    } else
        println("Комиссия составит: $commissionSize руб.")
}

fun calcCommission(amountOfTransfer: Int, typeOfCard: String = "VK Pay", amountOfPreviousTransfer: Int = 0): Int {
    val commission = when {
        (typeOfCard == "VK Pay") -> {
            if (amountOfTransfer > 15_000 || (amountOfTransfer + amountOfPreviousTransfer) > 40_000) -1 else 0
        }

        (amountOfTransfer > 150_000 || (amountOfTransfer + amountOfPreviousTransfer) > 600_000) -> {
            -2
        }

        (typeOfCard == "Mastercard" || typeOfCard == "Maestro") -> {
            if (amountOfTransfer + amountOfPreviousTransfer > 75_000) (amountOfTransfer * 0.6 / 100).toInt() + 20 else 0
        }

        (typeOfCard == "Visa" || typeOfCard == "МИР") -> {
            if ((amountOfTransfer * 0.75 / 100).toInt() > 35) (amountOfTransfer * 0.75 / 100).toInt() else 35
        }

        else -> -3
    }
    return commission
}




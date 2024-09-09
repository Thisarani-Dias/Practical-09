package q3

object q3 {
  class Account(var balance: Double) {

    def deposit(amount: Double): Unit = {
      require(amount > 0, "Deposit amount must be positive")
      balance += amount
      println(s"Deposited $$${amount}, New balance: $$${balance}")
    }

    def withdraw(amount: Double): Unit = {
      require(amount > 0, "Withdraw amount must be positive")
      if (balance >= amount) {
        balance -= amount
        println(s"Withdrew $$${amount}, New balance: $$${balance}")
      } else {
        println("Insufficient balance")
      }
    }

    def transfer(amount: Double, toAccount: Account): Unit = {
      require(amount > 0, "Transfer amount must be positive")
      if (balance >= amount) {
        this.withdraw(amount)
        toAccount.deposit(amount)
        println(s"Transferred $$${amount} to another account")
      } else {
        println("Insufficient balance for transfer")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val account1 = new Account(1000.0)
    val account2 = new Account(500.0)

    account1.deposit(200)

    account2.withdraw(100)

    account1.transfer(300, account2)

    println(s"Account1 balance: $$${account1.balance}")
    println(s"Account2 balance: $$${account2.balance}")

  }
}

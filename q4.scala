package q4

object q4 {
  class Account(var balance: Double) {

    def deposit(amount: Double): Unit = {
      require(amount > 0, "Deposit amount must be positive")
      balance += amount
    }

    def withdraw(amount: Double): Unit = {
      require(amount > 0, "Withdraw amount must be positive")
      if (balance >= amount) balance -= amount
    }

    def transfer(amount: Double, toAccount: Account): Unit = {
      if (balance >= amount) {
        this.withdraw(amount)
        toAccount.deposit(amount)
      }
    }

    def applyInterest(): Unit = {
      if (balance > 0) balance += balance * 0.05
      else balance += balance * 0.1
    }
  }


  object Bank {
    type Accounts = List[Account]

    def accountsWithNegativeBalances(accounts: Accounts): Accounts = {
      accounts.filter(_.balance < 0)
    }

    def sumOfAllBalances(accounts: Accounts): Double = {
      accounts.map(_.balance).sum
    }

    def applyInterestToAll(accounts: Accounts): Accounts = {
      accounts.foreach(_.applyInterest()) // Apply interest to each account
      accounts
    }
  }

def main(args: Array[String]): Unit = {
  val acc1 = new Account(1000)
  val acc2 = new Account(-200)
  val acc3 = new Account(500)
  val acc4 = new Account(-50)

  val bankAccounts = List(acc1, acc2, acc3, acc4)

  val negativeAccounts = Bank.accountsWithNegativeBalances(bankAccounts)
  println("Accounts with negative balances:")
  negativeAccounts.foreach(acc => println(s"Balance: $$${acc.balance}"))

  val totalBalance = Bank.sumOfAllBalances(bankAccounts)
  println(s"Total balance of all accounts: $$${totalBalance}")

  Bank.applyInterestToAll(bankAccounts)
  println("Final balances after applying interest:")
  bankAccounts.foreach(acc => println(s"Balance: $$${acc.balance}"))

}
}

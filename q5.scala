package q5

object q5 {
  object WordProcessor {

    def countLetterOccurrences(words: List[String]): Int = {
      val lengths = words.map(_.length)

      val totalLetters = lengths.reduce(_ + _)

      totalLetters
    }
  }

def main(args: Array[String]): Unit = {
  val words = List("apple", "banana", "cherry", "date")
  val totalCount = WordProcessor.countLetterOccurrences(words)
  println(s"Total count of letter occurrences: $totalCount")
}
}

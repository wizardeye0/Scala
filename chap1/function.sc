import scala.io.Source

object FunctionEx {
	def main(args: Array[String])
	{
		processFile("chap1_study.sc", 45)
	}

	//	객체의 멤버 함수. "method"
	def processFile(fileName: String, width: Int) {
		//	함수 내에서 다시 함수를 정의할 수 있다.
		def processLine(line: String)
		{
			if (line.length > width)
				println(fileName + ": " + line.trim)
		}

		val source = Source.fromFile(fileName)
		for (line <- source.getLines())
			processLine(line)
	}
}
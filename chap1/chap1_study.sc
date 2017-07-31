//	control structure

object ControlEx {
	def main(args: Array[String]) {

//	스칼라 if 는 값을 가진다. c++ 도 삼항연산자로 지원은 가능하지만, 스칼라는 if 결과로 어떤 것이든 반환이 가능함
//	c++ :: string filename = !(args.isEmpry()) ? args(0) : "default.txt"; 
		val filename =
			if (!args.isEmpty) args(0)	/// String
			else 0.0	///	Double

		println("String or None-String? : " + filename)

//	또한, 부수효과가 없기 때문에 변수명을 표현식으로 대체할 수 있다.
		println(if (!args.isEmpty) args(0) else "default.txt")

//	스칼라 while, do-while loop 구조는 수행 결과가 특정 값이 아닌 Unit
//	아래의 loop 는 반환 값이 없다. C++ loop 와 동일
//	순수한 함수형 언어에는 표현식은 있지만 loop 는 없다.
//	스칼라에는 loop 가 존재하는데, 때로는 명령형의 해법이 가독성이 뛰어나기 때문이다.
//	하지만 loop 는 var 와 유사하기 때문에 이를 권장하지 않음
		println("gcd loop style : " + gcdLoop(100,25))	
		println("gcd recursive style : " + gcdRecursive(100,25))

//	스칼라 for 는 표현식으로 사용할 수 있다.
//	1. collection 순회. modern c++ 도 동일하게 지원한다.
		for (file <- filesHere) println("for Iteration. file list : " + file)

		for (i <- 1 to 5) println("for Iteration. range-base for : " + i)

//	2. for 표현식에 필터를 추가할 수 있다. 
//	for 문이 표현식이라고 불리는 이유는 사용하기 위한 값을 결과로 내놓기 때문이다.
		for (file <- filesHere if file.getName.endsWith(".sc"))
			println("for with Filter. '*.sc' file list : " + file)

//	3. generator 를 여러개(overlap) 사용할 수도 있고, 표현식 수행 중 변수 바인딩도 가능하다.
		grep(".*gcd.*")

//	4. 새로운 collection 을 만들어 낼 수 있다.
		val forLineLengths = 
			for {
				file <- filesHere
				if file.getName.endsWith(".sc")
				line <- fileLines(file)
				trimmed = line.trim
				if trimmed.matches(".*for.*")
			} yield trimmed.length

		for (length <- forLineLengths)
			println("for yield. line length : " + length)

	}

	//	while loop
	def gcdLoop(x: Long, y: Long): Long = {
		var a = x
		var b = y

		while (a != 0) {
			val temp = a
			a = b % a
			b = temp
		}
		b
	}

	//	recursive
	def gcdRecursive(x: Long, y: Long): Long =
		if (y == 0) x else gcdRecursive(y, x % y)

	def filesHere = new java.io.File(".").listFiles

	def fileLines(file: java.io.File) =
		scala.io.Source.fromFile(file).getLines().toList

	//	for overlapping
	def grep(pattern: String) =
		for {
			file <- filesHere
			if file.getName.endsWith(".sc");
			line <- fileLines(file)
			trimmed = line.trim /// val binding
			if trimmed.matches(pattern)
		} println("for overlapping. " + file + ": " + trimmed)

}


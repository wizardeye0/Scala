object ArrayEx {
	def main(args: Array[String]) 
	{
		//	기본 배열 생성, 초기화
		val arrs1 = new Array[Int](5)
		var count = 0
		while (count < 5) {
			arrs1(count) = count
			println("array index access arrs : " + arrs1(count))
			count += 1
		}

		val arrs2 = Array(0, 1,2,3,4)
		for (arr <- arrs2) println("array sequence arrs : " + arr)
	}
}
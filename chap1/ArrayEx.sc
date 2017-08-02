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

		//	ArrayBuffer 는 모든 배열 메소드를 사용할 수 있으면서, 배열의 끝 또는 시작에 
		//	원소를 추가/삭제할 수 있으며, toArray 를 이용해 일반 배열로 변경할 수 있다.
		import scala.collection.mutable.ArrayBuffer
		val buf = new ArrayBuffer[Int]()
		buf += 1
		buf += 2
		buf += 3
		buf foreach println
	}
}
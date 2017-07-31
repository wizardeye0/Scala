//	control structure
//	스칼라 if 는 값을 가진다. c++ 도 삼항 연산자가 비슷한 개념인거 같은데?
//	c++ :: string filename = !(args.isEmpry()) ? args(0) : "default.txt"; 

//	차이점은 스칼라는 if 결과로 어떤 것이든 반환이 가능함

object ControlEx {
	def main(args: Array[String]) {
		val filename =
			if (!args.isEmpty) args(0)	/// String
			else 0.0	///	Double

		println("filename : " + filename)
	}
}


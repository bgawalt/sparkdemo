import org.apache.spark.SparkContext

object SparkDemo {
	
	def main(args: Array[String]) {
		val sc = new SparkContext("local", "SparkDemo")
		val numbers = sc.parallelize(1 to 10)
		println(numbers.reduce(_+_))

    sc.stop()
	}
}
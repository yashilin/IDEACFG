package com.example

import org.apache.spark.sql.SparkSession
import org.json4s.FullTypeHints
import org.json4s.native.Serialization
import org.json4s.jackson.JsonMethods._
import org.json4s._

case class Users (
                    id: Option[Int],
                    country: Option[String],
                    points: Option[Int],
                    price: Option[Double],
                    title: Option[String],
                    variety: Option[String],
                    winery: Option[String]
)

object JsonReader extends  App {
  implicit val formats = {
    Serialization.formats(FullTypeHints(List(classOf[Users])))
  }
  val spark = SparkSession.builder().master("local[*]").getOrCreate()
  import spark.implicits._
  val sc = spark.sparkContext
  val filename = args(0)
  val decodeUser = sc.textFile(filename)
  decodeUser.foreach(i => println(parse(i).extract[Users]))
}

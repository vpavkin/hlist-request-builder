import shapeless.{::, HNil}
import shapeless.test.illTyped
import utils.{IsDistinctConstraint, NotContainsConstraint}

object Test extends App {

  import api._

  implicitly[NotContainsConstraint[HNil, Int]]
  implicitly[NotContainsConstraint[Int :: HNil, String]]
  implicitly[NotContainsConstraint[Int :: String :: Boolean :: HNil, Long]]
  illTyped("""implicitly[NotContainsConstraint[Int :: HNil, Int]]""")
  illTyped("""implicitly[NotContainsConstraint[Int :: String :: Boolean :: HNil, Boolean]]""")

  implicitly[IsDistinctConstraint[HNil]]
  implicitly[IsDistinctConstraint[Int :: HNil]]
  implicitly[IsDistinctConstraint[Int :: String :: Boolean :: HNil]]
  illTyped("""implicitly[IsDistinctConstraint[Int :: Int :: HNil]]""")
  illTyped("""implicitly[IsDistinctConstraint[Int :: Long :: String :: Long :: HNil]]""")

  val singleResult = builder.get[Projects].execute
  val multipleResult = builder.get[Projects].and[Labels].and[Comments].execute

  println(singleResult)
  println(multipleResult)

  illTyped("""builder.get[Projects].and[Projects].execute""")
  illTyped("""builder.get[Projects].and[String].execute""")
  illTyped("""builder.get[String].execute""")
}

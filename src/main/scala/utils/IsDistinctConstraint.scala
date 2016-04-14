package utils

import scala.annotation.implicitNotFound
import shapeless._

/**
  * Type class witnessing that all elements of `L` have distinct types
  */
@implicitNotFound("Implicit not found: " +
  "shapeless.IsDistinctConstraint[${L}]. " +
  "Some elements have the same type.")
trait IsDistinctConstraint[L <: HList] extends Serializable

object IsDistinctConstraint {

  def apply[L <: HList](implicit idc: IsDistinctConstraint[L]): IsDistinctConstraint[L] = idc

  implicit val hnilIsDistinct = new IsDistinctConstraint[HNil] {}
  implicit def hlistIsDistinct[U, L <: HList](implicit d: IsDistinctConstraint[L],
                                              nc: NotContainsConstraint[L, U]): IsDistinctConstraint[U :: L] =
    new IsDistinctConstraint[U :: L] {}
}

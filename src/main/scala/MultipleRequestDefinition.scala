import shapeless.ops.hlist.LiftAll
import shapeless.{::, HList}
import utils.{IsDistinctConstraint, NotContainsConstraint}

class MultipleRequestDefinition[L <: HList](implicit
                                            ID: IsDistinctConstraint[L],
                                            allAR: LiftAll[APIResource, L])
  extends RequestDefinition[L] {

  def and[R](implicit NC: L NotContainsConstraint R,
             AR: APIResource[R]): MultipleRequestDefinition[R :: L] =
    new MultipleRequestDefinition[R :: L]
}

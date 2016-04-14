import shapeless.ops.hlist.LiftAll
import shapeless.{::, HList}
import utils.{IsDistinctConstraint, NotContainsConstraint}

class MultipleRequestDefinition[R <: HList](implicit
                                            ID: IsDistinctConstraint[R],
                                            allAR: LiftAll[APIResource, R]) extends RequestDefinition[R] {

  def and[RR](implicit
              NC: R NotContainsConstraint RR,
              AR: APIResource[RR]): MultipleRequestDefinition[RR :: R] =
    new MultipleRequestDefinition[RR :: R]
}

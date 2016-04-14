import shapeless.{::, =:!=, HNil}

class SingleRequestDefinition[R: APIResource] extends RequestDefinition[R] {

  def and[RR](implicit
              NEQ: RR =:!= R,
              AR: APIResource[RR]): MultipleRequestDefinition[RR :: R :: HNil] =
    new MultipleRequestDefinition[RR :: R :: HNil]
}

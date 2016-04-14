class Builder {

  def get[R: APIResource]: SingleRequestDefinition[R] =
    new SingleRequestDefinition[R]

}

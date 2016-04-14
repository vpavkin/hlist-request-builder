trait RequestDefinition[R] {
  def execute(implicit ev: MockResponse[R]): R = ev.value
}





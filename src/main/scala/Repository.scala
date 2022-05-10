trait NameRepository{
  def getName: String
}


class OneNameRepository extends NameRepository {
  override def getName: String = "Ivan"
}

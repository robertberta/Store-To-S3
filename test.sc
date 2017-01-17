case class Documents(
                      idDocument: Int,
                      company: String,
                      team: String,
                      name: String
                    )
val l = List(Documents(1,"1","1","1"),Documents(2,"2","2","2"))
val m = l.groupBy(_.idDocument)
val a = None
val b = Map(1->2)
a.flatMap(b.get)
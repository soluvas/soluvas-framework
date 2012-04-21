name := "soluvas-ldap"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.9.1"

//resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

//resolvers += "Local Nexus" at "http://localhost:8080/nexus/content/groups/public"

// needed to get sources of jena-core, although it's already a transitive dependency of jena-arq
libraryDependencies += "org.apache.jena" % "jena-core" % "2.7.0-incubating" withSources()

libraryDependencies += "org.apache.jena" % "jena-arq" % "2.9.0-incubating" withSources()

libraryDependencies += "org.apache.directory.server" % "apacheds-core" % "2.0.0-M6"

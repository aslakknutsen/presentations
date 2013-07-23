    Maven.resolver()
       .loadPomFromFile("pom.xml")
       .resolve("x:y", "x:y:1.0")
       .withTransitivity()
       .asFile();
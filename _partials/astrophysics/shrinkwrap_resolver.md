	Resolvers.use(MavenResolverSystem.class)
		.loadPomFromFile("pom.xml")
		.resolve("x:y:1.0.0", "x:y")
		.withTransitivity()
		.as(File.class);

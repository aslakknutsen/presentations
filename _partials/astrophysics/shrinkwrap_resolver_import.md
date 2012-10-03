	Resolvers.use(MavenResolverSystem.class)
		.loadPomFromFile("pom.xml", "profile-name")
		.importRuntimeDependencies()
		.as(File.class);

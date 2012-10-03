    ShrinkWrap.create(JavaArchive.class)
        .addClasses(x)
        .addPackages(x.z)

    ShrinkWrap.create(WebArchive.class)
        .addAsLibraries(x)
        .addAsWebInfResource(x)
        .setWebXML(z)

    ShrinkWrap.create(EnterpriseArchive.class)
        .addAsModules(war, jar)
        .setApplicationXML(x)
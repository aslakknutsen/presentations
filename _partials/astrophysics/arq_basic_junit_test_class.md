    @RunWith(Arquillian.class)
    
    
        @Deployment
        public static Archive<?> createDeployment() {
            return ShrinkWrap.create(WebArchive.class)
                .addXYZ(...);
        }
        
        @Inject
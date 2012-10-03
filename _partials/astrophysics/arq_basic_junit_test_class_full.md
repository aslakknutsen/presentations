	@RunWith(Arquillian.class)
    public class MyTestClass {

        @Deployment
        public static Archive<?> createDeployment() {
            return ShrinkWrap.create(WebArchive.class)
                .addXYZ(...);
        }
        
        @Inject
        private MyBean bean;

        @Test
        public void shouldBeAbleTo() {
            Assert.assertNotNull(bean);
        }
    }
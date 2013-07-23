require 'bootstrap-sass'
#require 'tilt'
#require 'tilt/markdown'

Awestruct::Extensions::Pipeline.new do
  #Tilt::register(Tilt::RedClothTemplate, '.md')
  # extension Awestruct::Extensions::Posts.new( '/news' ) 
  # extension Awestruct::Extensions::Indexifier.new
	helper Awestruct::Extensions::Partial
end


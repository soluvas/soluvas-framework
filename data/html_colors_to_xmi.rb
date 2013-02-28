require 'csv'

csv = File.read('html_colors.csv')

data = CSV.parse(csv)
puts '<?xml version="1.0" encoding="ASCII"?>
<data:DataCatalog xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:data="http://www.soluvas.org/schema/data/1.0" xsi:schemaLocation="http://www.soluvas.org/schema/data/1.0 data.ecore" name="base_color-term">'

data.each do |line|
	name = line[3]
	displayName = line[4]
	next if name == 'lowname'
	#color = line[2]
    puts %Q{  <terms name="#{name}" nsPrefix="base" color="#{name}" displayName="#{displayName}" attributeTypeNsPrefix="base" attributeTypeName="color"/>}
end

puts '</data:DataCatalog>'

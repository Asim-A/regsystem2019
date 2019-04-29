#"hamza";"aftab";"2019-04-27";"moisty mire";"3";"500"
import csv;
# , "0", "[]", "[]"
csvData = [["Asim", "Abazi", "2010-02-03", "Lucky Landing", "1", "0", "[]", "[]"]]


for i in range(25000):
	fornvn = "Asim"
	etternvn = "Abazi"
	dato = "1998-22-08"
	sted = "TILTED TOWER"
	nr = i
	ub = "0"
	ha = "[]"
	csvData.append([fornvn,etternvn,dato,sted,nr,ub,ha,ha])



with open("kunde.csv", "w", newline='') as csvFile:
	writer = csv.writer(csvFile, delimiter = ";", quotechar='"', quoting=csv.QUOTE_ALL)
	writer.writerows(csvData)

csvFile.close()
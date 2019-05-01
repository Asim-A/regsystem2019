#"hamza";"aftab";"2019-04-27";"moisty mire";"3";"500"
import csv, random
from attributegenerator import readFileToArray

def randomDato():
	dato = ""
	day = random.randint(1,30)
	month = random.randint(1,12)
	year = random.randint(1900, 2019)
	dato = str(year)+"-"+str(month)+"-"+str(day)
	return dato

# , "0", "[]", "[]"
csvData = [["Asim", "Abazi", "2010-02-03", "Lucky Landing", "1", "0", "[]", "[]"]]
navn = readFileToArray("names.txt")
loc = readFileToArray("fortnitelocation.txt")

def genererKunder(size, navn, loc):
	for i in range(size):
		fornvn = random.choice(navn)
		etternvn = random.choice(navn) + "sen"
		dato = randomDato()
		sted = random.choice(loc)
		nr = i
		ub = "0"
		ha = "[]"
		csvData.append([fornvn,etternvn,dato,sted,nr,ub,ha,ha])

def skrivKunderTilCSV(csvData):
	with open("kunde.csv", "w", newline='') as csvFile:
		writer = csv.writer(csvFile, delimiter = ";", quotechar='"', quoting=csv.QUOTE_ALL)
		writer.writerows(csvData)
		csvFile.close()

# genererKunder(9999, navn, loc)
# skrivKunderTilCSV(csvData)
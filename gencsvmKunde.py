import csv


csvData = '"Asim";"Abazi";"2019-05-01";"TrengerDatasett22";"22";"0";"[Baatforsikring;123.0;321.0;JegTRENGERetDATASETTmellomromFUNKERikkeHERjakob;2019-05-01;Asim;3321;Cadilac;1421234;1998;333HP;*]";"[]"\n'

def skrivKunderTilCSV(csvData):
	fo = open("faf.csv", "w")
	for i in range(9999):
		fo.write(csvData)
	fo.close()

skrivKunderTilCSV(csvData)
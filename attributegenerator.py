import json, urllib.request

namesURL = "https://raw.githubusercontent.com/dominictarr/random-name/master/first-names.json"
fortnitelocationURL = "https://raw.githubusercontent.com/beaushinkle/fortnite-loot/master/rankedLocations.json"

def getJSONFromURL(URL):
	with urllib.request.urlopen(URL) as namesURL:
		return json.loads(namesURL.read().decode())

def getNamesAsArrayFromJSON(URL):
	namesJSON = getJSONFromURL(URL)

	nameArray = []

	for item in namesJSON:
		nameArray.append(item)

	return nameArray

def getFortniteLocNamesAsArrayFromJSON(URL):

	jsonList = getJSONFromURL(URL)

	fortniteLocNames = []

	for obj in jsonList:
		fortniteLocNames.append(obj["Name"])

	return fortniteLocNames

def writeArrayToFile(array, filename):

	fo = open(filename, "w")
	for item in array:
		fo.write(item+"\n")
	fo.close

def readFileToArray(filename):
	fo = open(filename, "rU")
	inputArray = fo.read().splitlines()
	return inputArray
from collections import defaultdict
from itertools import permutations
from pprint import pprint
import xml.etree.ElementTree as ET

def createCoauthoringMatrix(fileName):
    matrix = defaultdict(int)
    tree = ET.parse(fileName)
    root = tree.getroot()

    for article in root.findall('Article'):
        authors = []
        for author in article.findall('./AuthorList/Author'):
            lastName = author.find('LastName').text
            foreName = author.find('ForeName').text
            fullName = f'{lastName}, {foreName}'
            authors.append(fullName)
        for author in authors:
            matrix[author,author] += 1
        for pair in permutations(authors, 2):
            matrix[pair] += 1
            
    return matrix

matrix = createCoauthoringMatrix('example.xml')
pprint(matrix)
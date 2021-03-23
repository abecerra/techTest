
all:
	@javac Network.java RandomList.java
	@echo "-------------------------"
	@echo "A. Question 1. randlist.py"
	python3 randlist.py
	@echo "-------------------------"
	@echo "B. Question 2. RandomList.java"
	java -cp . RandomList
	@echo "-------------------------"
	@echo "C. Question 1. Network.java"
	java -cp . Network
	@echo "-------------------------"
	@echo "D. Question 1. coauthoring.py"
	python3 coauthoring.py


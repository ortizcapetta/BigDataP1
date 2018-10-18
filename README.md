# Big Data Analysis Project 1
First project for Big Data Analysis course CIIC5995 @ UPRM.
The project consists of analysing data from a .json file composed of tweets (which is not provided in this repository) with hadoop map-reduce.
There are 5 Map Reduce programs:
1. MR1 - Find Specific Key words in the tweets. In our case the words chosen were : {Trump, Sika, Ebola, Headache, Measles, diarrhea, flu}
2. MR2 - Find all different words 
3. MR3 - Find all the unique @s
4. MR4 - Find all RTs, left unimplemented because of no RT data
5. MR5 - Find all message IDs with their replies
6. MR6 - Find all messages by User ID

## Compilation
Make sure maven is installed in your machine and run
```
mvn clean install
```
in the project folder where the pom.xml is located

## Running the Map-Reduce
Make sure [hadoop]( https://hadoop.apache.org/docs/r3.1.1/hadoop-project-dist/hadoop-common/SingleCluster.html) is installed in your machine. For the purpose of testing, we ran it locally and is the set of instructions we will provide. 
Go to the /target file and write the 
folowing command in the terminal in the target folder where the .jar file is located:
```
hadoop <JARNAME>.jar <MR_#> <INPUT_FILE_LOCATION> <OUTPUT_FILE_LOCATION>
```
where <MR_#> is one of the map-reduce listed above. Make sure to have the .json file stored in <INPUT_FILE_LOCATION>. The output file
must not exist in the system. 

## Visualization of pre-provided data
For the purpose of this project we have provided some .tsv files located in the [MRVisuals folder](/MRVisuals) with information obtained from our map-reduce program. 
Alongside these .tsv files, we provided some .html files for visualization. To view, an http server must be setup. We utilized:
```
python3 -m http.server
```
and simply opened the .html files on our favorite browser.

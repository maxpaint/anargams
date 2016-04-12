1) mvn clean install

2) cd target

3) java -jar anagram.jar <txt-file-name>

Performance:
1) Filtering input dataset. My solution works only with unique set. English language contains only 1_000_000 words. And if try to upload 100 billion, unique words will be only 1_000_000 or less))
2) Working with set in parallelStream();
3) For defining as anagrams, program compares two sorted arrays of chars.
4) Storing anagrams in map. The map which contains key – is a sorted word, the value - is a collection of anagrams. For map interface I used ConcurrentHashMap, and for collection  Collections.synchronizedList(new ArrayList<>()).
Program works in multithreading, that’s why I used concurrent implementation.

Scalability:
1) You can run my code in multi-nodes environment and feed the node with some parts of data;
2) My class Anagram works with unique words set and returns list of anagram collections;

Maintainability:
I think my code is easy to maintain, expand and support.
One class stands for one responsibility.

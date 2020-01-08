**Collections Framework**

When we talk about collections in Java, we're referring to:

**1)the Collection interface**

**2)the Collections API**

The **Collection Interface** is an interface which extends the **Iterable** interface. All of the classes which inherit from the Collection interface can store collections of objects and iterable. These classes do not inherit directly from the Collection interface, but from subinterfaces of the Collection interface. Some of the most prominent subinterfaces include:

-List
-Set
-Queue

Each of these subinterfaces imposes its own restrictions on its implementing classes.

**List**

The **List** interface allows us to create ordered collections that support duplicate elements. Some of the implementing classes include:

--ArrayList: This is a resizable-array implementation of the List interface. Traversal of an ArrayList is fast, but insertion is slow. Supports random access as it implements the RandomAccess interface. Note that this is not a synchronized implementation of the List interface.

--LinkedList: This is a doubly-linked list implementation of the List and Deque interfaces. Traversal is slow, but insertion is fast. Does not support random access. Note that this is not a synchronized implementation of the List interface.

--Vector: Like ArrayList, this is a resizable-array implementation of the List interface. Supports random access. Note that this IS a synchronized implementation of the List interface. Thus, it is safe to use in multi-threaded environments.

--Stack: This is an implementation of the List interface which extends the Vector class. A stack follows a first-in, last-out policy, which means that the first element that is added is the last element that will be removed.

**Set**

The **Set** interfaces allows us to create unordered collections that do NOT support duplicate elements. Some of the implementing classes and subinterfaces include:

--HashSet: This is an implementation of the Set interface that is backed by a HashMap. Note that this implementaiton does not support random access, nor is it synchronized.

--SortSet: This is a subinterface of the Set interface which allows the creation of a set that is sorted (and thus maintains this sorted order).

--TreeSet: This is an implementation of the SortedSet interface which allows for the creation of sorted sets. Note that this implementation does not support random access, nor is it synchronized.

The **Queue** interface allows us to create collections that follow a first-in, first-out philosophy. Some implementating classes include:

--PriorityQueue: This is an implementation of the Queue interface which orders elements according to their natural ordering (i.e. the ordering determined by the compareTo() method defined on the Comparable interface) or by a Comparator provided at queue construction time. Note that this implementation is not synchronized.

--LinkedList: This class also implements the Queue interface.

**Map Interface**

The Map interface allows us to map keys to values. A map cannot contain duplicate keys. Note that the Map interface is NOT a part of the Collection interface. Because the Map interface does not extend the Iterable interface, maps are not iterable and we cannot obtain iterators for maps. Here are some common implementations of the Map interface:

--HashMap: This is an unsynchronized implementation of the Map interface that allows for null values and null keys. This class makes no guarantees in terms of the order of the map.

--Hashtable: This is a synchronized implementation of the Map interface that does not allow for null keys.

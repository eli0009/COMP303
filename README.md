# McGill COMP303 - Software Design Notes

My COMP303 course notes. Available in Markdown. A sample of my notes for [Module 3](m3.md) is available below.


---

# Object state

## Abstract state

An abstract state is a state that impact how an object would be used. For example appending to a linked list when it is empty vs when it has more than 1 element

## Optional type

Use `Optional.empty()` instead of `null` to help avoid nullpointer exceptions.

See [OptionalType.java](code/OptionalType.java) 

## NULL OBJECT design pattern

Goal: avoid `null` and `Optional`, but still avoid nullpointer exceptions.

Create an implementation of an interface that represents a null class instead of directly passing `null` so that the code doesn't break when null isn't checked.

See [NullObject.java](code/NullObject.java)

## FLYWEIGHT design pattern

Goal: Avoid redundancy when storing data

Create an array that contains the values, then newly created object simply need to keep track of the index of the value, saving memory. 4 steps to realize this:
1. private constructor
2. static initializing fields that creates the flyweight objects
3. static flyweight store (ex: array) that stores all the flyweight objects
4. static access method that returns the flyweigth objects according to a key

See [Flyweight.java](code/Flyweight.java) 

## SINGLETON design pattern

Goal: ensure only 1 instance of class (ex: database access, aggregation of states)

This is similar to flyweight, but in this case we only want 1 instance, so no key, and the store is a variable that points to the instance. 3 steps to realize this:
1. private constructor
2. variable that points to the instance
3. static access method

See [Singleton.java](code/Singleton.java) 

## Anonymous classes

Create an anonymous class from an interface (ex: using `Comparator<T>`) without defining it by using `return new Interface() {}`

See [Anonymous.java](code/Anonymous.java) 


## Create a high quality `equals` method
1. `null` always return false
1. Use `==` to check if same instance. If so return `true`
2. Use `instanceof` to check if same type. If not return `false`
3. Cast to correct type
4. For each significant field, check that they are equal to eachother
   - `float`: use `Float.compare(float, float)`
   - `double`: use `Double.compare(double, double)`
   - Primitive fields: use `==`
   - Others: `Objects.equals(Object, Object)`

Additionally, use `@Override`

See [QualityEqual.java](code/QualityEqual.java) 

## Always override `hashCode` when overriding equals

Improper implementation of hashcode will prevent proper functioning in collections like hashmap or hashset. Always test whether 2 equal instances have same hash code.

Requirements:
1. must consistently return the same value when called on the same object if no info is modified
2. if two objects are equal according to `equals()`, they must have the same hashcode
3. two objects that are not equal don't need to have distinct hashcode, but that might improve performance

How to create good hashcode:
1. select random non-zero constant into int `result` (ex: 17)
2. for each field:
   1. compute hashcode `c`
   2. Combine hashcode `c` into `result`: `result = 31 * result + c`
3. return result

See [QualityEqual.java](code/QualityEqual.java) 

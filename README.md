#JMH Fun

## What is faster?
Checking if a 5 digit string is contained in a List or a Set?

`Set.contains` has a complexity of O(1) up to O(logN).

`List.contains` is O(n)

In theory Set is faster, but... if you have a small list, 
and the index of the searched element in the List is near the beginning, then List starts to shine.

## Let's give it a try
With 10 elements in each collection:

```
# JMH version: 1.33
# VM version: JDK 11.0.2, OpenJDK 64-Bit Server VM, 11.0.2+7
# VM invoker: /Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/java
# VM options: -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=52668:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 2 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: eval.SetVsList.testHashCode

# Run progress: 0.00% complete, ETA 00:05:50
# Fork: 1 of 1
# Warmup Iteration   1: 2.874 ns/op
# Warmup Iteration   2: 3.161 ns/op
Iteration   1: 2.566 ns/op
Iteration   2: 2.553 ns/op
Iteration   3: 2.557 ns/op
Iteration   4: 2.529 ns/op
Iteration   5: 2.525 ns/op


Result "eval.SetVsList.testHashCode":
  2.546 ±(99.9%) 0.069 ns/op [Average]
  (min, avg, max) = (2.525, 2.546, 2.566), stdev = 0.018
  CI (99.9%): [2.477, 2.615] (assumes normal distribution)


# JMH version: 1.33
# VM version: JDK 11.0.2, OpenJDK 64-Bit Server VM, 11.0.2+7
# VM invoker: /Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/java
# VM options: -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=52668:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 2 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: eval.SetVsList.testListWithFarPin

# Run progress: 20.00% complete, ETA 00:04:43
# Fork: 1 of 1
# Warmup Iteration   1: 41.570 ns/op
# Warmup Iteration   2: 44.575 ns/op
Iteration   1: 38.826 ns/op
Iteration   2: 38.932 ns/op
Iteration   3: 38.975 ns/op
Iteration   4: 38.729 ns/op
Iteration   5: 38.621 ns/op


Result "eval.SetVsList.testListWithFarPin":
  38.817 ±(99.9%) 0.560 ns/op [Average]
  (min, avg, max) = (38.621, 38.817, 38.975), stdev = 0.145
  CI (99.9%): [38.257, 39.377] (assumes normal distribution)


# JMH version: 1.33
# VM version: JDK 11.0.2, OpenJDK 64-Bit Server VM, 11.0.2+7
# VM invoker: /Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/java
# VM options: -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=52668:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 2 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: eval.SetVsList.testListWithNearPin

# Run progress: 40.00% complete, ETA 00:03:32
# Fork: 1 of 1
# Warmup Iteration   1: 4.172 ns/op
# Warmup Iteration   2: 4.185 ns/op
Iteration   1: 3.885 ns/op
Iteration   2: 3.889 ns/op
Iteration   3: 3.866 ns/op
Iteration   4: 3.863 ns/op
Iteration   5: 3.877 ns/op


Result "eval.SetVsList.testListWithNearPin":
  3.876 ±(99.9%) 0.044 ns/op [Average]
  (min, avg, max) = (3.863, 3.876, 3.889), stdev = 0.011
  CI (99.9%): [3.832, 3.920] (assumes normal distribution)


# JMH version: 1.33
# VM version: JDK 11.0.2, OpenJDK 64-Bit Server VM, 11.0.2+7
# VM invoker: /Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/java
# VM options: -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=52668:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 2 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: eval.SetVsList.testSetWithFarPin

# Run progress: 60.00% complete, ETA 00:02:21
# Fork: 1 of 1
# Warmup Iteration   1: 13.065 ns/op
# Warmup Iteration   2: 13.062 ns/op
Iteration   1: 10.933 ns/op
Iteration   2: 10.911 ns/op
Iteration   3: 10.923 ns/op
Iteration   4: 10.931 ns/op
Iteration   5: 10.914 ns/op


Result "eval.SetVsList.testSetWithFarPin":
  10.922 ±(99.9%) 0.038 ns/op [Average]
  (min, avg, max) = (10.911, 10.922, 10.933), stdev = 0.010
  CI (99.9%): [10.885, 10.960] (assumes normal distribution)


# JMH version: 1.33
# VM version: JDK 11.0.2, OpenJDK 64-Bit Server VM, 11.0.2+7
# VM invoker: /Library/Java/JavaVirtualMachines/jdk-11.0.2.jdk/Contents/Home/bin/java
# VM options: -javaagent:/Applications/IntelliJ IDEA.app/Contents/lib/idea_rt.jar=52668:/Applications/IntelliJ IDEA.app/Contents/bin -Dfile.encoding=UTF-8
# Blackhole mode: full + dont-inline hint (default, use -Djmh.blackhole.autoDetect=true to auto-detect)
# Warmup: 2 iterations, 10 s each
# Measurement: 5 iterations, 10 s each
# Timeout: 10 min per iteration
# Threads: 1 thread, will synchronize iterations
# Benchmark mode: Average time, time/op
# Benchmark: eval.SetVsList.testSetWithNearPin

# Run progress: 80.00% complete, ETA 00:01:10
# Fork: 1 of 1
# Warmup Iteration   1: 8.737 ns/op
# Warmup Iteration   2: 8.848 ns/op
Iteration   1: 7.171 ns/op
Iteration   2: 7.158 ns/op
Iteration   3: 7.150 ns/op
Iteration   4: 7.173 ns/op
Iteration   5: 7.316 ns/op


Result "eval.SetVsList.testSetWithNearPin":
  7.193 ±(99.9%) 0.267 ns/op [Average]
  (min, avg, max) = (7.150, 7.193, 7.316), stdev = 0.069
  CI (99.9%): [6.927, 7.460] (assumes normal distribution)


# Run complete. Total time: 00:05:53

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                      Mode  Cnt   Score   Error  Units
SetVsList.testHashCode         avgt    5   2.546 ± 0.069  ns/op
SetVsList.testListWithFarPin   avgt    5  38.817 ± 0.560  ns/op
SetVsList.testListWithNearPin  avgt    5   3.876 ± 0.044  ns/op
SetVsList.testSetWithFarPin    avgt    5  10.922 ± 0.038  ns/op
SetVsList.testSetWithNearPin   avgt    5   7.193 ± 0.267  ns/op
```

## Comments
Testing if a `Set` contains an element takes in average 7-10 ns. 
Although the exact location is known upfront, the hashcode of the searched element has to be calculated. 
It could be very quick and as simple as `return 5`, but then you end up with collisions - all elements will go into 
one bucket. This will result in costly searches in that bucket.
For various hash functions I've found this 
[blog post](https://softwareengineering.stackexchange.com/questions/49550/which-hashing-algorithm-is-best-for-uniqueness-and-speed) 
very informative, however, String is `final` and you cannot override `hashcode`. 
You need to wrap it into a class or live with the default hashcode.

Testing if a `List` contains an element is as simple as iterating through all elements in the `List` and call `equals()`.
If the searched element is at the very beginning, `contains` is fast. **Faster than `Set`**.

Also note, that the `equals()` method is iterating over each character in the String, 
therefore the longer the String, the smaller the benefit of using List.